import java.util.concurrent.ThreadLocalRandom;

public class PercolationStats {
    int n, trials;
    double meanValue, stdDeviation;
    Percolation percolation;

    public PercolationStats(int n, int trials){
        this.n = n;
        this.trials = trials;
    }

    public double mean(){

        double meanResult = 0;
        double result;

        for (int i=0; i<trials; i++){
            percolation = new Percolation(n);
            double m = 0.0f;
            boolean p = false;
            double openSites = 0.0f;
            while (p == false){
                int r1 = ThreadLocalRandom.current().nextInt(0, n);
                int r2 = ThreadLocalRandom.current().nextInt(0, n);
                percolation.open(r1, r2);
                p = percolation.percolates();
            }
    
            openSites = percolation.numberOfOpenSites();
    
            m = openSites/(n*n);
            meanResult += m;
        }

        result = meanResult/trials;
        meanValue = result;
        return result;
    }

    public double stddev(){
        double meanRes = mean();
        double meanTemp=0;
        double stdDev=0.0;

        for (int i=0; i<trials; i++){
            percolation = new Percolation(n);
            double m = 0.0f;
            boolean p = false;
            double openSites = 0.0f;
            while (p == false){
                int r1 = ThreadLocalRandom.current().nextInt(0, n);
                int r2 = ThreadLocalRandom.current().nextInt(0, n);
                percolation.open(r1, r2);
                p = percolation.percolates();
            }

            openSites = percolation.numberOfOpenSites();
    
            m = openSites/(n*n);

            meanTemp += Math.pow((m - meanRes), 2);
        }

        stdDev = Math.sqrt(meanTemp / (trials - 1));
        stdDeviation = stdDev;
        return stdDev;

    }

    public double confidenceLo(){
        return meanValue - ((1.96f * stdDeviation)/Math.sqrt(trials));
    }

    public double confidenceHi(){
        return meanValue + ((1.96f * stdDeviation)/Math.sqrt(trials));
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        if(n < 1 || T < 1){
            System.out.println("N or T cannot be less than 1");
            return;
        } 

        PercolationStats ps = new PercolationStats(n, T);

        System.out.println("mean =  " + ps.mean());
        System.out.println("stddev =  " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}