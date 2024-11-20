public class LinkedBag<T> implements BagInterface<T>
{
    private Node<T> firstNode;
    private int numberOfEntries;
    
    public LinkedBag()
    {
        numberOfEntries = 0;
    }

    //returns the union of 2 bags
    public LinkedBag<T> union(BagInterface<T> otherBag)
    {
        //create a bag that will be returned
        LinkedBag<T> rBag = new LinkedBag<T>();
        //iterate through this bag
        for(T t:toArray()){
            //add each item in this bag
            rBag.add(t);
        }
        //iterate through the parameter bag
        for(T t:otherBag.toArray()){
            //add each item from the input bag
            rBag.add(t);
        }
        //return resulting bag
        return rBag;
    }
    
    //returns the intersection of 2 bags
    public LinkedBag<T> intersection(BagInterface<T> otherBag)
    {
        //create a bag that will be returned
        LinkedBag<T> rBag = new LinkedBag<T>();
        //iterate through this bag
        for(T t:toArray()){
            //check if item exists in parameter bag
            if(otherBag.contains(t)){
                //add intersecting item
                rBag.add(t);
            }
        }
        //return resulting bag
        return rBag;
    }
    
    //returns the difference of 2 bags
    public LinkedBag<T> difference(BagInterface<T> otherBag)
    {
        //create a bag that will be returned
        LinkedBag<T> rBag = new LinkedBag<T>();
        //iterate through this bag
        for(T t:toArray()){
            //add all items
            rBag.add(t);
        }
        //iterate through parameter bag
        for(T t:otherBag.toArray()){
            //attempt to remove all items
            rBag.remove(t);
        }
        //return resulting bag
        return rBag;
    }
    
    //adds a new entry to the bag
    public boolean add(T newEntry){
        if(numberOfEntries == 0){
            firstNode = new Node(newEntry);
        }
        else{
            Node n = firstNode;
            while(n.getNext()!=null){
                n = n.getNext();
            }
            n.setNext(new Node(newEntry));
        }
        numberOfEntries++;
        return true;
    }
    
    //removes the first entry in the bag
    public boolean remove(){
        if(numberOfEntries == 0){
            return false;
        }
        firstNode = firstNode.getNext();
        numberOfEntries--;
        return true;
    }
    
    //removes the first occurrence of an entry
    public boolean remove(T anEntry){
        if(firstNode.getData().equals(anEntry)){
            firstNode = firstNode.getNext();
            numberOfEntries--;
            return true;
        }
        Node n = firstNode;
        Node m = n.getNext();
        while(m!=null){
            if(m.getData().equals(anEntry)){
                n.setNext(m.getNext());
                numberOfEntries--;
                return true;
            }
            m = m.getNext();
            n = n.getNext();
        }
        return false;
    }
    
    //clears all entries from the bag
    public void clear(){
        firstNode = null;
        numberOfEntries = 0;
    }
    
    //returns the number of times an entry appears
    public int getFrequencyOf(T anEntry){
        int count = 0;
        for(T t:toArray()){
            if(t.equals(anEntry)){
                count++;
            }
        }
        return count;
    }
    
    //returns if the bag contains at least 1 of an entry
    public boolean contains(T anEntry){
        for(T t:toArray()){
            if(t.equals(anEntry)){
                return true;
            }
        }
        return false;
    }
    
    //returns a java array representation of the bag
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] bagArray = (T[])new Object[numberOfEntries];
        Node n = firstNode;
        int i = 0;
        while(n!=null){
            bagArray[i] = (T) n.getData();
            n = n.getNext();
            i++;
        }
        return bagArray;
    }
    
    //returns the number of entries in the bag
    public int getCurrentSize(){
        return numberOfEntries;
    }
    
    //returns true if the bag has no entries
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }
}

class Node<T>{
    private T data;
    private Node<T> nextNode;
    
    public Node(){
        data = null;
        nextNode = null;
    }
    
    public Node(T newData){
        data = newData;
        nextNode = null;
    }
    
    public Node(T newData, Node newNode){
        data = newData;
        nextNode = null;
    }
    
    public T getData(){
        return data;
    }
    
    public void setData(T newData){
        data = newData;
    }
    
    public Node getNext(){
        return nextNode;
    }
    
    public void setNext(Node newNode){
        nextNode = newNode;
    }
}
