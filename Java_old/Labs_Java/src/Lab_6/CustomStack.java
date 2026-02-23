package Lab_6;


public class CustomStack{
    public static void main(String[] args){

        Stack< Integer> stack = new Stack<> (10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
    }
}

class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push (T element){
        data[size] = element;
        size++;
    }
    public T pop() {
        if (size <= 0) return null;
        T element = (T) data[size-1];
        size--;
        return element;
    }
    public T peek() {
        if (size <= 0) return null;
        return (T) data[size-1];
    }

}