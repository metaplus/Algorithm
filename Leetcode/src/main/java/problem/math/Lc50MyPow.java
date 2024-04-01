package problem.math;

public class Lc50MyPow {

    public double myPow(double x, int n) {
        if (n >= 0) {
            return pow(x, n);
        }
        return 1.0 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double mul = pow(x, n / 2);
        if (n % 2 == 0) {
            return mul * mul;
        }
        return mul * mul * x;
    }
}
