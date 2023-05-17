package lab1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static java.lang.System.currentTimeMillis;

public class lab1 {
    public static void main (String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        //int size = 10000;
        fill (arrayList, 100000, "arrayList");
        fill (linkedList, 100000, "linkedList");
        RandomAccess(arrayList, 10000, "arrayList");
        RandomAccess(linkedList, 10000, "linkedList");
        SequentialAccess (arrayList, "arrayList");
        SequentialAccess(linkedList, "linkedList");
        BeginInsert(arrayList,10000, "arrayList");
        BeginInsert(linkedList, 10000, "linkedList");
        MiddleInsert(arrayList,10000, "arrayList");
        MiddleInsert(linkedList, 10000, "linkedList");
        EndInsert(arrayList,10000, "arrayList");
        EndInsert(linkedList, 10000, "linkedList");
    }
    private static void fill (List<Integer> list, int count, String listType){
        long time = currentTimeMillis();
        int element = 0;
            for (int i = 0; i < count; i++){
                element = (int) (Math.random() * 1001);
                list.add(element);
            }
        System.out.printf("Fill %s: %s\n", listType,  currentTimeMillis() - time);
    }

    private static void RandomAccess (List<Integer> list, int index, String listType) {
        long time = currentTimeMillis();
        for (int i = 0; i < index; i++) {
            list.get(i);
        }
        System.out.printf("Random Access %s: %s\n", listType,  currentTimeMillis() - time);
    }
    private static void SequentialAccess (List<Integer> list, String listType) {
        long time = currentTimeMillis();
        ListIterator<Integer> Itr = list.listIterator();
        while (Itr.hasNext()) {
            Itr.next();
        }
        System.out.printf("Sequential Access %s: %s\n", listType,  currentTimeMillis() - time);
    }
    private static void BeginInsert(List<Integer> list, int count, String listType){
        long time = currentTimeMillis();
        for (int i = 0; i < count; i++){
            list.add (0, 0);
        }
        System.out.printf("Insert in the begin of %s: %s\n", listType,  currentTimeMillis() - time);
    }
    private static void MiddleInsert(List<Integer> list, int count, String listType){
        long time = currentTimeMillis();
        for (int i = 0; i < count; i++){
            list.add (list.size()/2, 0);
        }
        System.out.printf("Insert in the middle of %s: %s\n", listType,  currentTimeMillis() - time);
    }
    private static void EndInsert(List<Integer> list, int count, String listType){
        long time = currentTimeMillis();
        for (int i = 0; i < count; i++){
            list.add(0);
        }
        System.out.printf("Insert in the end of %s: %s\n", listType,  currentTimeMillis() - time);
    }
}
