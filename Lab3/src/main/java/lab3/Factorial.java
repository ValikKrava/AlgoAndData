package lab3;

class Factorial {

    public int recursionExecute(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * recursionExecute(n - 1);
        }
    }

    public int cycleExecute(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}