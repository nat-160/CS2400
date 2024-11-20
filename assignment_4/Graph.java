public class Graph{
    //instance variables
    public boolean[][] edges;
    private char[] labels;
    //constructors
    public Graph(int n){
        edges = new boolean[n][n]; //edges default to false
        labels = new char[n]; //labels default to null
    }
    //returns whether or not an edge exists between source and target
    public boolean isEdge(int source, int target){
        return edges[source][target];
    }
    //sets the edge of source and target to true
    public void addEdge(int source, int target){
        edges[source][target]=true;
    }
    //returns the label associated with vertex index
    public char getLabel(int vertex){
        return labels[vertex];
    }
    //returns an array of indexes for nodes considered neighbors of a vertex given by index
    public int[] neighbors(int vertex){
        int i,count=0;
        int[] answer;
        for(i=0;i<labels.length;i++){
            if(edges[vertex][i]){
                count++;
            }
        }
        answer=new int[count];
        count=0;
        for(i=0;i<labels.length;i++){
            if(edges[vertex][i]){
                answer[count++]=i;
            }
        }
        return answer;
    }
    //sets an edge to false between source and target
    public void removeEdge(int source, int target){
        edges[source][target]=false;
    }
    //sets the label for a vertex given its index
    public void setLabel(int vertex, char newLabel){
        labels[vertex] = newLabel;
    }
    //returns the number of labels [even those still null]
    public int size(){
        return labels.length;
    }
    
    //returns a list of labels of neighbors for a vertex
    public char[] getNeighbors(int vertex){
        int[] vertices = neighbors(vertex);
        char[] neighbors = new char[vertices.length];
        for(int i=0;i<vertices.length;i++){
            neighbors[i]=getLabel(vertices[i]);
        }
        return neighbors;
    }
    //returns a list of labels of neighbors for a label
    public char[] getNeighbors(char c){
        int index = -1;
        for(int i=0;i<labels.length;i++){
            if(c==labels[i]){
                index = i;
            }
        }
        return (index!=-1) ? getNeighbors(index) : null;
    }
}