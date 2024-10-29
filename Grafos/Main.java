
 public class Main {
 
    public static void main(String[] args) {
        GrafoMatriz gf=new GrafoMatriz(4);

        gf.addEdge(1,2);
        gf.addEdge(2,3);
        gf.addEdge(1,0);

       System.out.println(gf);
    }

    
}