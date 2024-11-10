import java.util.*;

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class ClosestPair {
    public static double bruteForce(Point[] p, int start, int end) {
        double min = Double.MAX_VALUE;
        double distance;
        for (int i = start; i < end - 1; i++) {
            for (int j = start + 1; j < end; j++) {
                double dx = (p[j].getX() - p[i].getX()) * (p[j].getX() - p[i].getX());
                double dy = (p[j].getY() - p[i].getY()) * (p[j].getY() - p[i].getY());
                distance = Math.sqrt(dx + dy);
                if (min > distance) {
                    min = distance;
                }
            }
        }
        return min;
    }

    public static double closestPairDivide(Point[] p, int start, int end) {
        if (end - start <= 1) {
            return bruteForce(p, start, end); // Handle cases with less than 2 points
        }

        int mid = (start + end) / 2;
        double leftDist = closestPairDivide(p, start, mid);
        double rightDist = closestPairDivide(p, mid + 1, end);
        double d = Math.min(leftDist, rightDist);

        // Find points within distance d of the median point
        int k = 0;
        for (int i = start; i <= end; i++) {
            if (Math.abs(p[i].getX() - p[mid].getX()) < d) {
                // No need for a temporary array here
                d = Math.min(d, bruteForce(p, k, i - start + 1)); // Call bruteForce directly on a portion of p
                k++;
            }
        }

        return d;
    }

    public static void main(String[] args) {
        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of points");
        int n = sc.nextInt();
        Point[] p = new Point[n];
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            p[i] = new Point(x, y);
        }

        double d = closestPairDivide(p, 0, n - 1);
        System.out.println(d);
        sc.close();
    }
}

    

