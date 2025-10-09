package Lab_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;




public class HashTable {

    public static class Entry{
        String key;
        String value;

        Entry(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private int numIndexes;
    private int elemCounts;
    protected LinkedList<Entry>[] table;


    public HashTable(int numIndexes){
        this.numIndexes = numIndexes;
        this.elemCounts = 0;

        table = new LinkedList[numIndexes];
        for (int i = 0; i < this.numIndexes; i++){ // правильно создаём таблицу
            table[i] = new LinkedList<Entry>();
        }
    }

    public HashTable(){
        this(8);
    }


    public boolean isEmpty(){
        return elemCounts == 0;
    }
    public int size(){
        return elemCounts;
    }

    public int hash(String input){
        return Math.abs(input.hashCode()) % this.numIndexes;
    }



    public String[] get(String key){
        int index = hash(key);
        List<String> values = new ArrayList<>();

        for (Entry e: table[index]){
            if (e.key.equals(key)){
                values.add(e.value);
            }
        }
        if (values.isEmpty()) {
            System.out.println("Can't get " + key + ", no matches in table");
        }
        return values.toArray(new String[0]);

    }

    public void put(String key, String value){      // change string
        int index = hash(key);
        table[index].add(new Entry(key, value));
        this.elemCounts+=1;
    }

    public void remove(String key){
        int index = hash(key);
        int before = table[index].size();
        table[index].removeIf(e -> e.key.equals(key));
        elemCounts -= (before - table[index].size());
    }
}
