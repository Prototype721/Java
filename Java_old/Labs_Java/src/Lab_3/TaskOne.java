package Lab_3;

import java.util.List;

public class TaskOne {
    public static void main(String[] args) {


        HashTable<String, String> ht = new HashTable<>(4);

        System.out.println("Table created. isEmpty(): " + ht.isEmpty());
        System.out.println("Initial size: " + ht.size());
        System.out.println();

        System.out.println("Adding elements...");
        ht.put("apple", "red");
        ht.put("banana", "yellow");
        ht.put("cherry", "red");
        ht.put("apple", "green"); // заменит "red"
        ht.put("melon", "green");
        System.out.println("Size after adds: " + ht.size());
        System.out.println();

        System.out.println("Getting values:");
        printList("apple", ht.get("apple"));
        printList("banana", ht.get("banana"));
        printList("melon", ht.get("melon"));
        printList("notInTable", ht.get("notInTable"));
        System.out.println();

        System.out.println("Removing key 'apple'...");
        ht.remove("apple");
        System.out.println("Size after removing 'apple': " + ht.size());
        printList("apple", ht.get("apple"));
        System.out.println();

        System.out.println("Removing key 'notHere' (should do nothing)...");
        ht.remove("notHere");
        System.out.println("Size still: " + ht.size());
        System.out.println();

        System.out.println("Removing remaining keys...");
        ht.remove("banana");
        ht.remove("cherry");
        ht.remove("melon");
        System.out.println("Size after clearing: " + ht.size());
        System.out.println("isEmpty(): " + ht.isEmpty());
    }

    private static <V> void printList(String key, List<V> list) {
        System.out.print("get(" + key + ") : ");
        if (list == null || list.isEmpty()) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
