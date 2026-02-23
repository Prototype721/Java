package Lab_6;

import java.util.*;

public class Var6 {
    public static void main(String[] args){
        List<Map.Entry<String, Integer>> products = new ArrayList<>(5);
        products.add(new AbstractMap.SimpleEntry<>("Banana", 200));
        products.add(new AbstractMap.SimpleEntry<>("Apple", 40));
        products.add(new AbstractMap.SimpleEntry<>("XLEB", 30));
        products.add(new AbstractMap.SimpleEntry<>("Ananas", 2000));
        products.add(new AbstractMap.SimpleEntry<>("Desert Eagle 50.cal", 10000));


        TradingTable myTable = new TradingTable(products);

        myTable.addProd("Banana");

        System.out.println(myTable.getSum());

        myTable.addProd("Banana");
        myTable.addProd("Banana");
        myTable.addProd("Banana");
        myTable.addProd("Desert Eagle 50.cal");
        myTable.addProd("XLEB");
        myTable.addProd("XLEB");

        System.out.println(myTable.getSum());
        System.out.println(myTable.getList().toString());
        System.out.println(myTable.getBestSeller());
    }

}

class TradingTable{

    private TreeMap<String, Integer> deals;
    private List<Map.Entry<String, Integer>> products;


    public TradingTable(List<Map.Entry<String, Integer>> products){
        deals = new TreeMap<String, Integer>();
        this.products = products;
    }

    public void addProd(String name){
        if (deals.containsKey(name)) deals.put(name, deals.get(name) + 1);
        else deals.put(name, 1);
    }

    public List<Map.Entry<String, Integer>> getList(){
        List<Map.Entry<String, Integer>> listOfBoughtProds = new ArrayList<>(deals.size());
        listOfBoughtProds.addAll(deals.entrySet());
        return listOfBoughtProds;
    }

    public int getSum(){
        int sum = 0;
        List<Map.Entry<String, Integer>> list = getList();
        for (Map.Entry<String, Integer> product : list){
            for (Map.Entry<String, Integer> prodEntry : products) {
                if (prodEntry.getKey().equals(product.getKey())) {
                    sum = sum + prodEntry.getValue() * product.getValue();
                    break;
                }
            }
        }
        return sum;
    }

    public Map.Entry<String, Integer> getBestSeller(){
        List<Map.Entry<String, Integer>> list = getList();
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (int) o2.getValue() - o1.getValue();
            }
        });
        return list.get(0);
    }
}
