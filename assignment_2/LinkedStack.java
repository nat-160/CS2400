import java.util.EmptyStackException;
public class LinkedStack<T> implements StackInterface<T>
{
    //instance variables
    private Node<T> topNode;
    //constructor
    public LinkedStack(){
        topNode = null;
    }

    //adds entry newEntry to the stack
    public void push(T newEntry){
        topNode = new Node<T>(newEntry, topNode);
    }
    //returns and removes the top most entry
    public T pop(){
        T data = peek();
        topNode = topNode.getPrev();
        return data;
    }
    //returns the top most entry
    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return topNode.getData();
    }
    //returns true if there are no entries
    public boolean isEmpty(){
        return topNode == null;
    }
    //deletes all entries
    public void clear(){
        topNode = null;
    }
}

class Node<T>
{
    private T data;
    private Node<T> prevNode;

    public Node(T data, Node<T> prevNode){
        this.data = data;
        this.prevNode = prevNode;
    }

    public T getData(){
        return data;
    }

    public Node<T> getPrev(){
        return prevNode;
    }
}