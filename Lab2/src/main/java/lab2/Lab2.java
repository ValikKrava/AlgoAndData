package lab2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.System.currentTimeMillis;

public class Lab2 {
    public static void main(String[] args) {
        int[] sizes = {10, 1000, 10000, 100000};

        for (int count : sizes) {
            System.out.println("Кількість елементів: " + count);

            ArrayList<Integer> input = createArray(count);
            System.out.println("Згенерований масив: " + FirstFifty(input));

            for (SortingType type : SortingType.values()) {
                System.out.println("Тип сортування: " + type);

                Sorter sorter = getSorter(type);
                ArrayList<Integer> sortedArray = SortingTime(input, sorter);

                System.out.println("Відсортований масив: " + FirstFifty(sortedArray));
            }
        }
    }
    private static ArrayList<Integer> createArray(int count) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            array.add(random.nextInt(count + 1));
        }

        return array;
    }

    private static Sorter getSorter(SortingType type) {
        switch (type) {
            case BUBBLE:
                return new BubbleSorter();
            case SHELL:
                return new ShellSorter();
            case MERGE:
                return new MergeSorter();
            case QUICK:
                return new QuickSorter();
            default:
                throw new IllegalArgumentException("Невірний тип сортування");
        }
    }

    private static ArrayList<Integer> SortingTime(ArrayList<Integer> array, Sorter sorter) {
        ArrayList<Integer> copy = new ArrayList<>(array);
        long time = currentTimeMillis();
        ArrayList<Integer> sortedArray = sorter.sort(copy);

        System.out.println("Час сортування: " + (currentTimeMillis() - time) + " ms");

        return sortedArray;
    }

    private static String FirstFifty(List<Integer> array) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < Math.min(50, array.size()); i++) {
            builder.append(array.get(i));
            if (i != array.size() - 1) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }
}
