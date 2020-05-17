public class UnionFind{

    private int N;
    private int sz[];
    private int id[];

    private int noOfComponents;

    public UnionFind(int N){
        if(N < 2) N = 2;

        this.N = noOfComponents = N;

        sz = new int[N];
        id = new int[N];

        for (int i=0; i<N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p){
        int root = p;

        while (root != id[root]){ 
            id[root] = id[id[root]];
            root = id[root];
        }

        return root;
    }

    public boolean connected(int p , int q){
        return find(p) == find(q);
    }

    public int components(){
        return noOfComponents;
    }

    public int componentSize(int p){
        return sz[find(p)];
    }

    public void unify(int p, int q){
        if(connected(p, q)) return;

        int rootP = find(p);
        int rootQ = find(q);

        if(sz[rootP] < sz[rootQ]){
            sz[rootQ] += sz[rootP];
            id[rootP] = rootQ;

            for (int i=0; i<N; i++){
                if(id[i] == rootP) id[i] = rootQ;
            }
        } else{
            sz[rootP] += sz[rootQ];
            id[rootQ] = rootP;
            for (int i=0; i<N; i++){
                if(id[i] == rootQ) id[i] = rootP;
            }
        }

        noOfComponents--;
        System.out.println(" ");
        printArr();
    }

    public void printArr(){
        for (int i = 0; i < N; i++){
            System.out.print(id[i] + " ");
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        uf.printArr(); 
        uf.unify(1, 6);
        uf.unify(2, 3);
        uf.unify(6, 3);
    }
}