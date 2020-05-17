import java.util.concurrent.ThreadLocalRandom;

public class Percolation {

    int[][] grid;
    int[][] id;
    int size;

    public Percolation (int n) {
        size = n;

        grid = new int[n][n];
        id = new int[n+1][n+1];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                grid[i][j] = 0;
            }
        }

        int temp=0;

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                id[i][j] = temp++;
            }
        }

        printArr();
    }

    public void openSite(int row, int col){
        if(grid[row][col] == 0){
            grid[row][col] = 1;
            printArr();
        }
    }

    public int find(int row, int col){
        int root = (size*row) + col;
        int r = (root-col)/size;
        int c = root-(size*row);

        while (root != id[r][c]){ 
            root = id[r][c];
            r = (root - c)/size;
            c = root - (size*r);
        }

        return root;
    }

    public boolean connected(int[] rc1, int[] rc2){
        int row1 = rc1[0];
        int col1 = rc1[1];
        int row2 = rc2[0];
        int col2 = rc2[1];

        return find(row1, col1) == find(row2, col2);
    }

    public void unify(int[] rc1, int[] rc2){
        if(connected(rc1, rc2)) return;

        int row1 = rc1[0];
        int col1 = rc1[1];
        int row2 = rc2[0];
        int col2 = rc2[1];

        int root1 = find(row1,col1);
        int root2 = find(row2,col2);

        if(root1 == 0){
            id[row2][col2] = 0;
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if(id[i][j] == root2) id[i][j] = 0;
                }
            }
        }
        else if(root2 == 0){
            id[row1][col1] = 0;
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if(id[i][j] == root1) id[i][j] = 0;
                }
            }
        } 
        else if(root1 == 24){
            id[row1][col1] = 24;
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if(id[i][j] == root1) id[i][j] = 24;
                }
            }
        }
        else if(root2 == 24){
            id[row1][col1] = 24;
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if(id[i][j] == root1) id[i][j] = 24;
                }
            }
        }
        else{
            id[row2][col2] = root1;
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if(id[i][j] == root2) id[i][j] = root1;
                }
            }
        }

        System.out.println(" ");
        printArr();
    }

    public void printArr(){
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                System.out.print(id[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        int N = 5;

        //UnionFind uf = new UnionFind(10);

        Percolation per = new Percolation(N);

        int[] base = new int[] {0,1};

        int[] t = new int[] {0,2};
        int[] t1 = new int[] {1,2};

        per.unify(base, t1);
        per.unify(t, t1);

        per.unify(new int[]{4,2}, new int[] {3,0});
        per.unify(new int[]{4,2}, new int[] {3,2});
        per.unify(new int[]{0,1}, new int[]{3,0});
      

        /**for (int i=0; i<5; i++){
            int r1 = ThreadLocalRandom.current().nextInt(0, N);
            int r2 = ThreadLocalRandom.current().nextInt(0, N);
            per.openSite(r1, r2);
        }**/
    }
}