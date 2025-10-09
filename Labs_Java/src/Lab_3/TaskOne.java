package Lab_3;

public class TaskOne {
    public static void main(String[] args) {

        HashTable ht = new HashTable(4);

        System.out.println("Table created. isEmpty(): " + ht.isEmpty());
        System.out.println("Initial size: " + ht.size());
        System.out.println();

        // --- Test put() ---
        System.out.println("Adding elements...");
        ht.put("apple", "red");
        ht.put("banana", "yellow");
        ht.put("cherry", "red");
        ht.put("apple", "green");   // duplicate key (to test multiple values for same key)
        ht.put("melon", "green");   // potential collision due to small table size
        System.out.println("Size after adds: " + ht.size());
        System.out.println();

        // --- Test get() ---
        System.out.println("Getting values:");
        printArray("apple", ht.get("apple"));
        printArray("banana", ht.get("banana"));
        printArray("melon", ht.get("melon"));
        printArray("notInTable", ht.get("notInTable")); // non-existent key
        System.out.println();

        // --- Test remove() ---
        System.out.println("Removing key 'apple'...");
        ht.remove("apple");
        System.out.println("Size after removing 'apple': " + ht.size());
        printArray("apple", ht.get("apple")); // should now be empty
        System.out.println();

        // --- Test remove non-existing key ---
        System.out.println("Removing key 'notHere' (should do nothing)...");
        ht.remove("notHere");
        System.out.println("Size still: " + ht.size());
        System.out.println();

        // --- Test isEmpty() after all removals ---
        System.out.println("Removing remaining keys...");
        ht.remove("banana");
        ht.remove("cherry");
        ht.remove("melon");
        System.out.println("Size after clearing: " + ht.size());
        System.out.println("isEmpty(): " + ht.isEmpty());
    }

    // Helper method to print arrays
    private static void printArray(String key, String[] arr) {
        System.out.print("get(" + key + ") : ");
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}