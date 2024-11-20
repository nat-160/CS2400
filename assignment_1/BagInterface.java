public interface BagInterface<T>
{
    //returns the union of 2 bags
    BagInterface<T> union(BagInterface<T> otherBag);
    
    //returns the intersection of 2 bags
    BagInterface<T> intersection(BagInterface<T> otherBag);
    
    //returns the difference of 2 bags
    BagInterface<T> difference(BagInterface<T> otherBag);
    
    //adds a new entry to the bag
    boolean add(T newEntry);
    
    //removes the an entry in the bag
    boolean remove();
    
    //removes the first occurrence of an entry
    boolean remove(T anEntry);
    
    //clears all entries from the bag
    void clear();
    
    //returns the number of times an entry appears
    int getFrequencyOf(T anEntry);
    
    //returns if the bag contains at least 1 of an entry
    boolean contains(T anEntry);
    
    //returns a java array representation of the bag
    T[] toArray();
    
    //returns the number of entries in the bag
    int getCurrentSize();
    
    //returns true if the bag has no entries
    boolean isEmpty();
}
