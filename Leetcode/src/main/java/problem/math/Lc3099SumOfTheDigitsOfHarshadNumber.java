package problem.math;

public class Lc3099SumOfTheDigitsOfHarshadNumber {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int harshad = 0;
        int remain = x;
        while (remain > 0) {
            harshad += remain % 10;
            remain /= 10;
        }
        return x % harshad == 0 ? harshad : -1;
    }
}
