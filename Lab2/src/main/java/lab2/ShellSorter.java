package lab2;

import java.util.ArrayList;

class ShellSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arr) {
        ArrayList<Integer> array = new ArrayList<>(arr);
        int n = array.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = array.get(i);
                int j;
                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) array.set(j, array.get(j - gap));

                array.set(j, temp);
            }
        }
        return array;
    }
}
