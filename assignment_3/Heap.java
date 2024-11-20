import java.util.Arrays;
public class Heap{
    //instance variables
    private int[] heap;
    private int lastIndex, swaps;
    private static final int DEFAULT_CAPACITY = 101;

    public Heap(){
        this(DEFAULT_CAPACITY);
    }

    public Heap(int initialCapacity){
        //create a array representation with size >= 101
        heap = new int[
            (DEFAULT_CAPACITY<initialCapacity) 
            ? initialCapacity 
            : DEFAULT_CAPACITY];
        lastIndex = 0;
    }

    /**
     * Construct a max heap using a list of entries
     * 
     * @param data The array of integers that will be input
     * @param smart If true, the heap will be constructed using the optimized method
     */
    public Heap(int[] data, boolean smart){
        this(data.length+1);  //initialize the heap using other constructor
        swaps = 0;
        if(smart){
            for(int i=0;i<data.length;i++){
                heap[i+1]=data[i];
                lastIndex++;
            }
            for(int rootIndex=lastIndex/2;rootIndex>0;rootIndex--){
                swaps+=reheap(rootIndex);
            }
        }
        else{
            for(int i:data){
                swaps+=add(i);
            }   
        }
    }

    //adds a new entry and returns how many times data gets swapped
    public int add(int newEntry){
        int aSwaps = 0;
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while((parentIndex>0) && newEntry>heap[parentIndex]){
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
            aSwaps++;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        return aSwaps;
    }

    //removes the top most node then reheaps using the last node
    public int removeMax(){
        int root = Integer.MIN_VALUE;
        if(!isEmpty()){
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }

    //makes the heap a max heap starting from the root index
    private int reheap(int rootIndex){
        int swaps = 0;
        boolean done = false;
        int orphan = heap[rootIndex];
        int leftChildIndex = 2*rootIndex;
        while(!done && (leftChildIndex<=lastIndex)){
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex+1;
            if((rightChildIndex<=lastIndex)
            && heap[rightChildIndex] > heap[largerChildIndex]){
                largerChildIndex = rightChildIndex;
            }
            if(orphan<heap[largerChildIndex]){
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2*rootIndex;
                swaps++;
            }
            else{
                done=true;
            }
        }
        heap[rootIndex] = orphan;
        return swaps;
    }

    //returns max node, or null if array is empty
    public int getMax(){
        return (!isEmpty()) ? heap[1] : null;
    }

    //returns true if heap has no data
    public boolean isEmpty(){
        return lastIndex < 1;
    }

    //returns amount of entries in heap
    public int getSize(){
        return lastIndex;
    }

    //deletes all entries
    public void clear(){
        while(lastIndex>-1){
            heap[lastIndex] = Integer.MIN_VALUE;
            lastIndex--;
        }
        lastIndex = 0;
    }
    
    //returns the amount of times the program has swapped data when constructing the heap
    public int getSwaps(){
        return swaps;
    }

    //returns a string representation of the heap (10 elements trailed by ...)
    public String toString(){
        String s="";
        for(int i=1;i<11;i++){
            s+=heap[i]+",";
        }
        return s+"...";
    }
}