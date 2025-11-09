//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.*;
//
//public class TopWords {
//    public static void main(String[ ] args) {
//        String filePath = "FileWithNames.txt";
//        File file = new File(filePath);
//
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        // создаем объект Map для хранения слов и их количества
//        Map<String, Integer> map = new HashMap<>();
//        // читаем файл по словам и добавляем их в Map
//        while (scanner.hasNext()) {
//            String name = scanner.nextLine();
//            if (map.containsKey(name)) {
//                map.put(name, map.get(name) + 1);
//            } else {
//                map.put(name, 1);
//            }
//        }
//        // закрываем Scanner
//        try {
//            scanner.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        // создаем список из элементов Map
//        ******
//        // сортируем список по убыванию количества повторений
//        Collections.sort(list, new Comparator< Map.Entry< String,
//        Integer> > (){
//            @Override
//            public int compare(Map.Entry< String, Integer> o1,Map.Entry< String, Integer> o2) {
//                ******
//            }
//        });
//        // выводим топ-10 слов
//        ******
//    }
//    // выводим результат
//    *******
//
//}