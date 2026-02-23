package Lab_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> {

    public static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int numIndexes;
    private int elemCounts;
    protected LinkedList<Entry<K, V>>[] table;


    public HashTable(int numIndexes) {
        this.numIndexes = numIndexes;
        this.elemCounts = 0;
        table = new LinkedList[numIndexes];
        for (int i = 0; i < this.numIndexes; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public HashTable() {
        this(8);
    }

    public boolean isEmpty() {
        return elemCounts == 0;
    }

    public int size() {
        return elemCounts;
    }

    public int hash(K key) {
        return Math.abs(key.hashCode()) % this.numIndexes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        HashTable<?, ?> other = (HashTable<?, ?>) obj;
        return this.elemCounts == other.elemCounts;
    }

    public List<V> get(K key) {
        int index = hash(key);
        List<V> values = new ArrayList<>();

        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                values.add(e.value);
            }
        }

        if (values.isEmpty()) {
            System.out.println("Can't get " + key + ", no matches in table");
        }

        return values;
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        this.elemCounts++;
    }

    public void remove(K key) {
        int index = hash(key);
        int before = table[index].size();
        table[index].removeIf(e -> e.key.equals(key));
        elemCounts -= (before - table[index].size());
    }
}



























//@SuppressWarnings("unchecked")