import java.util.*;

class Matrix {
    int a[];
    int dp[][];

    Matrix(int a[]) {
        this.a = a;
        int n = a.length;
        this.dp = new int[n][n];
    }

    int MCM(int n) {
        // Initialize the dp table with 0s for single matrix chain multiplication costs
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // l is the chain length
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int val = dp[i][k] + dp[k + 1][j] + a[i - 1] * a[k] * a[j];
                    if (val < min) {
                        min = val;
                    }
                }
                dp[i][j] = min; // Store the calculated minimum value
            }
        }
        return dp[1][n-1];
    }
}

public class MatrixChain3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of matrices to be multiplied:");
        int n = sc.nextInt();

        int a[] = new int[n + 1];
        System.out.println("Enter the dimensions of the matrices:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Matrix m = new Matrix(a);
        int res = m.MCM(n); // n + 1 because a.length is n + 1
        System.out.println("The minimum number of multiplications are: " + res);
    }
}

