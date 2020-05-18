public class Percolation {

    public static Percolation ins;

    PercolationHelper pHelper;

    int[][] grid;
    int[][] id;
    int size;
    int max;

    public Percolation (int n) {

        if(n < 1){
            System.out.println("N cannot be less than 1");
            return;
        }

        ins = this;
        size = n;
        max = (size*size)-1;

        pHelper = new PercolationHelper(size, max);

        grid = new int[n][n];
        id = new int[n][n];

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
    }

    public void open(int row, int col){

        try{
            if(!isOpen(row, col)){
                if(row == 0){
                    pHelper.unify(id, new int[] {0,0}, new int[] {row, col});
                }
                else if(row == size-1){
                    pHelper.unify(id, new int[] {size-1, size-1}, new int[] {row,col});
                }

                grid[row][col] = 1;

                pHelper.unifyAdjacent(id, row, col);
            }
        } catch (IllegalArgumentException e){System.out.println("Out of Bounds");}
    }

    public boolean isOpen(int row, int col){
        try{
            if(grid[row][col] == 1)
                return true;
        } catch (IllegalArgumentException e){
            System.out.println("Out of Bounds");
        }

        return false;
    }

    public boolean isFull(int row, int col){
        try{
            if(id[row][col] == 0)
                return true;
        } catch (IllegalArgumentException e){
            System.out.println("Out of Bounds");
        }

        return false;
    }

    public int numberOfOpenSites(){
        int res = 0;

        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                if(grid[i][j] == 1) res++;
            }
        }

        return res;
    }

    public boolean percolates(){
        for (int i=0; i<size; i++){
            if(id[size-1][i] == 0) return true;
        }

        return false;
    }

    /**public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        if(N<0) {
            System.out.println("N cannot be less than 0");
            return;
        }

        Percolation per = new Percolation(N);

        boolean p = false;

        while (p == false){
            int r1 = ThreadLocalRandom.current().nextInt(0, N);
            int r2 = ThreadLocalRandom.current().nextInt(0, N);
            per.open(r1, r2);
            p = per.percolates();
        }

        per.pHelper.printArr(per.grid);
        per.pHelper.printArr(per.id);
        System.out.println(per.numberOfOpenSites());
    }**/
}