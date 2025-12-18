package Lab_8;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {

    private List<Object> processors = new CopyOnWriteArrayList<>();
    private List<String> data;

    public void loadData(String source) throws IOException {
        Path path = Paths.get(source);
        String content = Files.readString(path, StandardCharsets.UTF_8);
        data = Arrays.asList(content.split("\\s"));
    }

    public void processData() {
        for (Object processor : processors) {
            Arrays.stream(processor.getClass().getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(DataProcessor.class))
                    .forEach(method -> {
                        try {
                            System.out.println("Применяется обработчик: " + method.getName());
                            data = (List<String>) method.invoke(processor, data);
                            System.out.println("Результат: " + data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void saveData(String destination) throws IOException {
        Path path = Paths.get(destination);
        Files.write(path, data, StandardOpenOption.CREATE);
    }

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

}