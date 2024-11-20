public class LinkedBagTest
{
    public static void main(String[] args){
        //uses test case from PDF
        BagInterface<String> bag1 = new LinkedBag<String>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        
        BagInterface<String> bag2 = new LinkedBag<String>();
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        
        BagInterface<String> everything = bag1.union(bag2);
        System.out.println("\nEverything: ");
        Object[] eArray = everything.toArray();
        for(Object o:eArray){
            System.out.print(o + " ");
        }
        
        BagInterface<String> commonItems = bag1.intersection(bag2);
        System.out.println("\nCommon Items: ");
        Object[] cArray = commonItems.toArray();
        for(Object o:cArray){
            System.out.print(o + " ");
        }
        
        BagInterface<String> leftOver1 = bag1.difference(bag2);
        System.out.println("\nLeft Over 1: ");
        Object[] lArray1 = leftOver1.toArray();
        for(Object o:lArray1){
            System.out.print(o + " ");
        }
        
        BagInterface<String> leftOver2 = bag2.difference(bag1);
        System.out.println("\nLeft Over 2: ");
        Object[] lArray2 = leftOver2.toArray();
        for(Object o:lArray2){
            System.out.print(o + " ");
        }
    }
}
