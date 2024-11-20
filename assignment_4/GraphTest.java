public class GraphTest{
    public static void main(String[] args){
        //create a graph
        Graph g = new Graph(9);
        //set the label names
        g.setLabel(0,'A');
        g.setLabel(1,'B');
        g.setLabel(2,'C');
        g.setLabel(3,'D');
        g.setLabel(4,'E');
        g.setLabel(5,'F');
        g.setLabel(6,'G');
        g.setLabel(7,'H');
        g.setLabel(8,'I');
        //add edges of graph
        g.addEdge(0,1); //A->B
        g.addEdge(0,3); //A->D
        g.addEdge(0,4); //A->E
        g.addEdge(1,4); //B->E
        g.addEdge(2,1); //C->B
        g.addEdge(3,6); //D->G
        g.addEdge(4,5); //E->F
        g.addEdge(4,7); //E->H
        g.addEdge(5,2); //F->C
        g.addEdge(5,7); //F->H
        g.addEdge(6,7); //G->H
        g.addEdge(7,8); //H->I
        g.addEdge(8,5); //I->F
        
        //obtain the neighbors of the vertex E
        char[] neighbors = g.getNeighbors('E');
        //print out
        String s = "";
        for(char c:neighbors){
            s+=""+c+" ";
        }
        System.out.println("Neighbors of E: "+s);
    }
}