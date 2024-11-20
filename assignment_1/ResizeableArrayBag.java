public class ResizeableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    public ResizeableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }
    
    public ResizeableArrayBag(int capacity){
        numberOfEntries = 0;
        bag = (T[])new Object[capacity];
    }

    //returns the union of 2 bags
    public ResizeableArrayBag<T> union(BagInterface<T> otherBag)
    {
        //create a bag that will be returned
        ResizeableArrayBag<T> rBag = new ResizeableArrayBag<T>();
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
    public ResizeableArrayBag<T> intersection(BagInterface<T> otherBag)
    {
        //create a bag that will be returned
        ResizeableArrayBag<T> rBag = new ResizeableArrayBag<T>();
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
    public ResizeableArrayBag<T> difference(BagInterface<T> otherBag)
    {
        //create a bag that will be returned
        ResizeableArrayBag<T> rBag = new ResizeableArrayBag<T>();
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
        if(numberOfEntries == bag.length){
            T[] newBag = (T[]) new Object[bag.length*2];
            for(int i=0;i<bag.length;i++){
                newBag[i] = bag[i];
            }
            bag = newBag;
        }
        bag[numberOfEntries++] = newEntry;
        return true;
    }

    //removes the last entry in the bag
    public boolean remove(){
        if(numberOfEntries == 0){
            return false;
        }
        numberOfEntries--;
        return true;
    }

    //removes the first occurrence of an entry
    public boolean remove(T anEntry){
        if(getFrequencyOf(anEntry)==0){
            return false;
        }
        int i=0;
        while(!bag[i].equals(anEntry)){
            i++;
        }
        numberOfEntries--;
        bag[i] = bag[numberOfEntries];
        return true;
    }

    //clears all entries from the bag
    public void clear(){
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
        for(int i=0;i<numberOfEntries;i++){
            bagArray[i] = bag[i];
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
