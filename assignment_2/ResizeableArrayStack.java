import java.util.EmptyStackException;
import java.util.Arrays;
public class ResizeableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 25;

    public ResizeableArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArrayStack(int capacity){
        topIndex = -1;
        stack = (T[])new Object[capacity];
    }
    //adds entry newEntry to the stack
    public void push(T newEntry){
        topIndex++;
        if(topIndex==stack.length){
            stack = Arrays.copyOf(stack, stack.length*2);
        }
        stack[topIndex] = newEntry;
    }
    //returns and removes the top most entry
    public T pop(){
        T data = peek();
        topIndex--;
        return data;
    }
    //returns the top most entry
    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[topIndex];
    }
    //returns true if there are no entries
    public boolean isEmpty(){
        return topIndex == -1;
    }
    //deletes all entries
    public void clear(){
        topIndex = -1;
    }
}
