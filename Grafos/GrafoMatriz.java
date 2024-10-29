
public class GrafoMatriz {
    int [][] adjMatrix;// matriz que vai representar o grafo
    private int nr_links; //numero de links
    private int nr_nodos;//numero de nodos

    public GrafoMatriz(int nodes){
      this.nr_nodos=nodes;
      this.nr_links=0;  
      this.adjMatrix=new int[nodes][nodes];// criamos uma matriz quadrada
    }

    public void addEdge(int node1,int node2){//supondo que o grafo e undirected
      adjMatrix[node1][node2]=1; //node1->row node2->column
      adjMatrix[node2][node1]=1;
      nr_links++;
    }

    public void removeEdge(int node1,int node2){
      adjMatrix[node1][node2]=0;
      adjMatrix[node2][node1]=0;
      nr_links--;
    }

    public String toString(){
      StringBuilder sb=new StringBuilder();
      sb.append(nr_nodos + " vertices " + nr_links + " links" + "\n");
      for(int i=0;i<nr_nodos;i++){
        sb.append(i + ": ");
        for(int w: adjMatrix[i]){
         sb.append(w+ " ");
        }
        sb.append("\n");
      }
      return sb.toString();
    }

    /*
    Ex:
     4 vertices 3 links
     0: 0 1 0 0 
     1: 1 0 1 0 
     2: 0 1 0 1 
     3: 0 0 1 0 
     */
}
