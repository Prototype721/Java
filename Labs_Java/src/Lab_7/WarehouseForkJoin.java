package Lab_7;

import java.util.*;
import java.util.concurrent.*;

public class WarehouseForkJoin {
    private static final int MAX_WEIGHT_PER_TRIP = 150;
    private static final int NUM_LOADERS = 3;


    static class Item {
        private final String name;
        private final int weight;

        public Item(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public int getWeight() { return weight; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return name + "(" + weight + "кг)";
        }
    }


    static class LoadResult {
        private final List<Item> loadedItems = new ArrayList<>();
        private int totalWeight = 0;

        public boolean canAddItem(Item item) {
            return totalWeight + item.getWeight() <= MAX_WEIGHT_PER_TRIP;
        }

        public void addItem(Item item) {
            loadedItems.add(item);
            totalWeight += item.getWeight();
        }

        public int getTotalWeight() { return totalWeight; }
        public List<Item> getLoadedItems() { return loadedItems; }

        @Override
        public String toString() {
            return "Груз: " + loadedItems + " | Общий вес: " + totalWeight + "кг";
        }
    }


    static class WarehouseTask extends RecursiveTask<List<LoadResult>> {
        private final List<Item> items;
        private final int start;
        private final int end;
        private static final int THRESHOLD = 10; // Порог деления

        public WarehouseTask(List<Item> items, int start, int end) {
            this.items = items;
            this.start = start;
            this.end = end;
        }

        @Override
        protected List<LoadResult> compute() {
            if (end - start <= THRESHOLD) {
                return processSequentially();

            } else {

                int mid = start + (end - start) / 2;
                WarehouseTask leftTask = new WarehouseTask(items, start, mid);
                WarehouseTask rightTask = new WarehouseTask(items, mid, end);

                leftTask.fork(); // Запускаем левую задачу асинхронно
                List<LoadResult> rightResult = rightTask.compute(); // Выполняем правую задачу
                List<LoadResult> leftResult = leftTask.join(); // Ждем результат левой задачи

                return mergeResults(leftResult, rightResult);
            }
        }

        private List<LoadResult> processSequentially() {
            List<LoadResult> allTrips = new ArrayList<>();
            LoadResult currentTrip = new LoadResult();

            for (int i = start; i < end; i++) {
                Item item = items.get(i);

                if (currentTrip.canAddItem(item)) {
                    currentTrip.addItem(item);
                } else {

                    if (currentTrip.getTotalWeight() > 0) {
                        allTrips.add(currentTrip);
                    }
                    currentTrip = new LoadResult();
                    currentTrip.addItem(item);
                }
            }

            // Последняя
            if (currentTrip.getTotalWeight() > 0) {
                allTrips.add(currentTrip);
            }

            return allTrips;
        }

        private List<LoadResult> mergeResults(List<LoadResult> left, List<LoadResult> right) {
            if (left.isEmpty()) return right;
            if (right.isEmpty()) return left;

            List<LoadResult> merged = new ArrayList<>(left);

            // Последняя поездка left + первая поездка right
            LoadResult lastLeft = left.get(left.size() - 1);
            LoadResult firstRight = right.get(0);


            if (lastLeft.getTotalWeight() + firstRight.getTotalWeight() <= MAX_WEIGHT_PER_TRIP) {

                LoadResult mergedTrip = new LoadResult();
                for (Item item : lastLeft.getLoadedItems()) {
                    mergedTrip.addItem(item);
                }
                for (Item item : firstRight.getLoadedItems()) {
                    mergedTrip.addItem(item);
                }


                merged.remove(merged.size() - 1);
                merged.add(mergedTrip);
                merged.addAll(right.subList(1, right.size()));
            } else {

                merged.addAll(right);
            }

            return merged;
        }
    }


    static class Loader extends Thread {
        private final int id;
        private final BlockingQueue<LoadResult> tripQueue;
        private int tripsCompleted = 0;
        private int totalWeightCarried = 0;

        public Loader(int id, BlockingQueue<LoadResult> tripQueue) {
            this.id = id;
            this.tripQueue = tripQueue;
            setName("Грузчик-" + id);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // Берем поездку синхронно
                    LoadResult trip = tripQueue.poll(1, TimeUnit.SECONDS);

                    if (trip == null) {
                        break;
                    }


                    System.out.println(getName() + " начинает перенос: " + trip);
                    Thread.sleep(500 + new Random().nextInt(1000));

                    tripsCompleted++;
                    totalWeightCarried += trip.getTotalWeight();

                    System.out.println(getName() + " завершил разгрузку: " + trip);
                }

                System.out.println(getName() + " завершил работу. " +
                        "Поездок: " + tripsCompleted +
                        ", Общий вес: " + totalWeightCarried + "кг");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        List<Item> warehouse = generateWarehouse(50);

        System.out.println("=============== СКЛАД ===============");
        System.out.println("Всего товаров: " + warehouse.size());
        int totalWeightBefore = 0;
        for (Item item : warehouse) {
            totalWeightBefore += item.getWeight();
        }
        System.out.println("Общий вес: " + totalWeightBefore + " кг");

        System.out.println("Товары: " + warehouse);
        System.out.println();


        ForkJoinPool forkJoinPool = new ForkJoinPool();
        WarehouseTask mainTask = new WarehouseTask(warehouse, 0, warehouse.size());

        System.out.println("=============== ПЛАНИРОВАНИЕ ПОЕЗДОК ===============");
        List<LoadResult> allTrips = forkJoinPool.invoke(mainTask);

        System.out.println("Запланировано поездок: " + allTrips.size());
        for (int i = 0; i < allTrips.size(); i++) {
            System.out.println("Поездка " + (i + 1) + ": " + allTrips.get(i));
        }
        System.out.println();


        BlockingQueue<LoadResult> tripQueue = new LinkedBlockingQueue<>(allTrips);

        System.out.println("=============== НАЧАЛО ПЕРЕНОСА ===============");


        List<Loader> loaders = new ArrayList<>();
        for (int i = 1; i <= NUM_LOADERS; i++) {
            Loader loader = new Loader(i, tripQueue);
            loaders.add(loader);
            loader.start();
        }


        for (Loader loader : loaders) {
            try {
                loader.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("=============== ПЕРЕНОС ЗАВЕРШЕН ===============");

        int totalTrips = loaders.stream().mapToInt(l -> l.tripsCompleted).sum();
        int totalWeight = loaders.stream().mapToInt(l -> l.totalWeightCarried).sum();

        System.out.println("Итого: " + totalTrips + " поездок, " + totalWeight + "кг перенесено");

        forkJoinPool.shutdown();
    }


    private static List<Item> generateWarehouse(int itemCount) {
        List<Item> warehouse = new ArrayList<>();
        Random random = new Random();
        String[] itemNames = {"Холодильник", "Телевизор", "Стиральная машина", "Диван",
                "Стол", "Стул", "Кровать", "Шкаф", "Микроволновка", "Компьютер"};

        for (int i = 1; i <= itemCount; i++) {
            String name = itemNames[random.nextInt(itemNames.length)] + "-" + i;
            int weight = 5 + random.nextInt(46); // Вес от 5 до 50 кг
            warehouse.add(new Item(name, weight));
        }

        return warehouse;
    }
}