package lab2;

import java.util.ArrayList;

class QuickSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arr) {
        ArrayList<Integer> array = new ArrayList<>(arr);
        quickSort(array, 0, array.size() - 1);
        return array;
    }

    private void quickSort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array.get(j) <= pivot) {
                i++;
                // Swap elements
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }

        // Swap pivot with the element at (i + 1)
        int temp = array.get(i + 1);
        array.set(i + 1, array.get(high));
        array.set(high, temp);

        return i + 1;
    }
}
