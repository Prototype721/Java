package Lab_8;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Demoversion {
    public static void main(String[] args) throws IOException {
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new Transform());
        dataManager.registerDataProcessor(new Filter());
        dataManager.registerDataProcessor(new Aggregate());

        dataManager.loadData("File.txt");
        dataManager.processData();
        dataManager.saveData("Answer.txt");
    }
}


class Transform {
    @DataProcessor
    public List<String> transformData(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}

class Filter {
    @DataProcessor
    public List<String> filterData(List<String> data) {
        return data.stream()
                .filter(s -> s.startsWith("I"))
                .collect(Collectors.toList());
    }
}

class Aggregate {
    @DataProcessor
    public List<String> aggregateData(List<String> data) {
        return data.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}



