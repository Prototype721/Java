package my.pocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            CustomStack<Integer> stack = new CustomStack<>(10);
            logger.info("Стек успешно создан с емкостью 10");

            stack.push(1);
            stack.push(2);
            logger.debug("Добавили элементы: 1, 2");

            logger.info("Извлечен элемент: {}", stack.pop());
            logger.info("Верхний элемент: {}", stack.peek());

            String json = mapper.writeValueAsString(stack);
            logger.info("Стек сериализован в JSON: {}", json);

            CustomStack<Integer> deserializedStack = mapper.readValue(json, CustomStack.class);
            logger.info("Стек успешно десериализован в данные: {}", deserializedStack.getData());
            logger.info("Размер стека: {}", deserializedStack.getSize());

        } catch (Exception e) {
            logger.error("Произошла ошибка: ", e);
        }
    }
}




// clean install exec:java
// dependency:tree