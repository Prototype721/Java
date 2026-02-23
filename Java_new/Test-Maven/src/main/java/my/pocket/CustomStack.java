package my.pocket;

public class CustomStack<T> {
    private T[] data;
    private int size;

    public CustomStack() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public CustomStack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size < data.length) {
            data[size++] = element;
        }
    }

    public T pop() {
        if (size <= 0) return null;
        T element = data[--size];
        data[size] = null;
        return element;
    }

    public T peek() {
        return (size <= 0) ? null : data[size - 1];
    }

    public T[] getData() {
        return data.clone();
    }
    public int getSize() {
        return size;
    }
}
