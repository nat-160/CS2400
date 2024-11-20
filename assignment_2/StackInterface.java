public interface StackInterface<T>
{
    //adds entry newEntry to the stack
    public void push(T newEntry);
    //returns and removes the top most entry
    public T pop();
    //returns the top most entry
    public T peek();
    //returns true if there are no entries
    public boolean isEmpty();
    //deletes all entries
    public void clear();
}
