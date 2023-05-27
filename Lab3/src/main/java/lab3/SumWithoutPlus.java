package lab3;

class SumWithoutPlus {

    public int execute(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return execute(a ^ b, (a & b) << 1);
        }
    }
}
