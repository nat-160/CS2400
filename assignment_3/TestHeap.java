import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class TestHeap{
    public static void main(String args[]){
        //initialize scanner and array that data will be stored in
        Scanner input;
        int[] data = new int[100];
        try{
            //try to read data.txt and write its contents to array
            input = new Scanner(new File("data.txt"));
            for(int i=0;i<100;i++){
                data[i] = input.nextInt();
            }
        }
        catch(Exception e){
            //catch all exceptions and output error message that is 99% accurate
            System.out.println("data.txt not found");
        }

        //string for outputting
        String out = "";
        
        //create a heap of the data, not using smart method
        Heap seqHeap = new Heap(data,false);
        int seqSwaps = seqHeap.getSwaps();
        
        //perform heap operations
        out+="Heap built using sequential insertions: "+seqHeap.toString()+"\n";
        out+="Number of swaps in the heap creation: "+seqSwaps+"\n";
        for(int i=0;i<10;i++){
            seqHeap.removeMax();
        }
        out+="Heap after 10 removals: "+seqHeap.toString()+"\n";
        
        out+="\n"; //add a new line. do not delete this line of code otherwise program breaks
        
        //create a heap of the data, using the smart method
        Heap smartHeap = new Heap(data,true);
        int smartSwaps = smartHeap.getSwaps();
        
        //perform heap operations
        out+="Heap built using optimal method: "+smartHeap.toString()+"\n";
        out+="Number of swaps in the heap creation: "+smartSwaps+"\n";
        for(int i=0;i<10;i++){
            smartHeap.removeMax();
        }
        out+="Heap after 10 removals: "+smartHeap.toString()+"\n";
        
        //System.out.println(out); //print the output to console. commented out for legal reasons
        
        //write the output to output.txt
        File outputFile = new File("output.txt");
        try{
            //make sure output.txt is blank
            FileWriter output = new FileWriter(outputFile, false);
            output.write(out);
            output.close();
        }
        catch(Exception e){
            //should basically never execute •_•
            System.out.println("•_•");
        }
    }
}