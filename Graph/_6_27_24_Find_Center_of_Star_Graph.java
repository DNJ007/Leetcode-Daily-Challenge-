public class _6_27_24_Find_Center_of_Star_Graph {
    public static int findCenter(int[][] edges) {
        int u = edges[0][0];
        int v = edges[0][1];
        int x = edges[1][0];
        int y = edges[1][1];
        return (u==x|| u==y?u:v);
     }
    public static void main(String[] args) {
        int edges[][] = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(edges));
    }
}
