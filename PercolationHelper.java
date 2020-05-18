public class PercolationHelper {

    int size;
    int max;

    public PercolationHelper(int size, int max){
        this.size = size;
        this.max = max;
    }

    public void unifyAdjacent(int[][] id, int row, int col){

        try{
            if(Percolation.ins.isOpen(row, col-1))
                unify(id, new int[]{row, col}, new int[] {row, col-1});
        } catch (IndexOutOfBoundsException e){}

        try{
            if(Percolation.ins.isOpen(row-1, col))
                unify(id, new int[]{row, col}, new int[] {row-1, col});
        } catch (IndexOutOfBoundsException e){}

        try{
            if(Percolation.ins.isOpen(row, col+1))
                unify(id, new int[]{row, col}, new int[] {row, col+1});
        } catch (IndexOutOfBoundsException e){}

        try{
            if(Percolation.ins.isOpen(row+1, col))
            unify(id,new int[]{row, col}, new int[] {row+1, col});
        } catch (IndexOutOfBoundsException e){}
    }

    public int find(int[][] id, int row, int col){
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

    public boolean connected(int[][] id, int[] rc1, int[] rc2){
        int row1 = rc1[0];
        int col1 = rc1[1];
        int row2 = rc2[0];
        int col2 = rc2[1];

        return find(id, row1, col1) == find(id, row2, col2);
    }

    public void unify(int[][] id, int[] rc1, int[] rc2){
        if(connected(id, rc1, rc2)) return;

        int row1 = rc1[0];
        int col1 = rc1[1];
        int row2 = rc2[0];
        int col2 = rc2[1];

        int root1 = find(id, row1,col1);
        int root2 = find(id, row2,col2);

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
        else if(root1 == max){
            id[row2][col2] = max;
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if(id[i][j] == root2) id[i][j] = max;
                }
            }
        }
        else if(root2 == max){
            id[row1][col1] = max;
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if(id[i][j] == root1) id[i][j] = max;
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
    }

    public void printArr(int[][] array){
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}