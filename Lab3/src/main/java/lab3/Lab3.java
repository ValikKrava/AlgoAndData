package lab3;

public class Lab3 {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int n = 5;
        int factRec = factorial.recursionExecute(n);
        int factCycle = factorial.cycleExecute(n);

        assert factRec == factCycle : "different values";
        System.out.println("Факторіал числа " + n + " використовуючи рекурсію: " + factRec);
        System.out.println("Факторіал числа " + n + " використовуючи цикл: " + factCycle);

        Fibonacci fibonacci = new Fibonacci();
        n = 6;
        int fibRec = fibonacci.recursionExecute(n);
        int fibCycle = fibonacci.cycleExecute(n);

        assert fibRec == fibCycle : "different values";
        System.out.println("Число Фібоначчі від числа " + n + " використовуючи рекурсію: " + fibRec);
        System.out.println("Число Фібоначчі від числа " + n + " використовуючи цикл: " + fibCycle);

        DigitSum digitSum = new DigitSum();
        n = 123456;
        int sum = digitSum.execute(n);
        System.out.println("Сума цифр числа " + n + ": " + sum);

        SumWithoutPlus sumWithoutPlus = new SumWithoutPlus();
        int a = 15;
        int b = 27;
        int sumWithoutPlusResult = sumWithoutPlus.execute(a, b);
        System.out.println("Сума" + a + " та " + b + " без оператора додавання: " + sumWithoutPlusResult);
    }
}
