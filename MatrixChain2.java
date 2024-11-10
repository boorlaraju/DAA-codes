import java.util.*;

class Matrix {
    int a[];
    int dp[][];

    Matrix(int a[], int n) {
        this.a = a;
        this.dp = new int[n+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    }

    int MCM(int i, int j) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int val = MCM(i, k) + MCM(k + 1, j) + a[i - 1] * a[k] * a[j];
            if (val < min) {
                min = val;
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }
}

public class MatrixChain2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of matrices to be multiplied:");
        int n = sc.nextInt();
        n-=1;

        int a[] = new int[n+1];
        System.out.println("Enter the dimensions of the matrices:");
        for (int i = 0; i <= n; i++)
            a[i] = sc.nextInt();

        Matrix m = new Matrix(a, n);
        int res = m.MCM(1, n);
        System.out.println("The minimum number of multiplications are: " + res);
    }
}

