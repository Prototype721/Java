package Lab_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "FileWithNames.txt";
        File file = new File(filePath);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> map = new HashMap<>();
        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }

        try {
            scanner.close();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(entry);
        }
        // сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator< Map.Entry< String, Integer> > (){
            @Override
            public int compare(Map.Entry< String, Integer> o1,Map.Entry< String, Integer> o2) {
                return (int) o2.getValue() - o1.getValue();
            }
        });
        // выводим топ-10 слов
        int i = 1;
        for (Map.Entry<String, Integer> entry : list){
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (i >= 10) break;
            i++;
        }
    }
}