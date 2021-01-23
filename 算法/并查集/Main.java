public class Main {

    private static int node_num = 5;
//    private static int[][] edges = {{0,1}, {1,2}, {1,4}, {2,3}, {3,4}}; // cycle
    private static int[][] edges = {{0,1}, {1,2}, {1,4}, {2,3}}; // no cycle

    public static void main(String[] args) {
//        print_output(new QuickUnionUF(node_num));
//        print_output(new QuickFindUF(node_num));
        print_output(new WeightedQuickUnionUF(node_num));
    }

    private static void print_output(UF uf) {
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if (uf.union(x,y) == false) {
                System.out.println("Cycle detects");
                System.exit(0);
            }
        }
        System.out.println("No cycle detects");
    }
}
