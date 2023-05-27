package lab3;

class Fibonacci {

    public int recursionExecute(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return recursionExecute(n - 1) + recursionExecute(n - 2);
        }
    }

    public int cycleExecute(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int c = 0;

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
