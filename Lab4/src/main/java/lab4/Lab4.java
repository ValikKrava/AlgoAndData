package lab4;

import java.util.*;

class Lab4 {

    static Random rand = new Random();

    public static void main(String[] args) {
        final int max = 20;
        final int N = 6;
        final int maxN = N + max;
        BSTNode bst = new BSTNode();

        //	1. Створити Map із 20 елементів для зберігання тестових даних ключами служать цілі цифри від вашого номера у списку групи N до N+20,
        //	структура має бути НЕ ВІДСОРТОВАНА за ключами. Тобто вставлятися дані мають у випадковому порядку.
        ArrayList<Node> map = GetDataMap(N);

        for (Node node : map) {
            bst.insert(node.key, node.value);
        }

        bst.traverse();

        //  2. З даних у структурі створити дерево BSTNode, обійти дерево і перевірити, що кількість вузлів дорівнює 20
        assert bst.size() == max : "tree elements count != " + max;

        //Знайти кілька існуючих елементів за ключами, вивести їх значення.
        System.out.println("Elems from tree:");
        System.out.println("Elem " + (N + 2) + " " + bst.get(N + 2));
        System.out.println("Elem " + (N + 4) + " " + bst.get(N + 4));

        //Спробувати знайти неіснуючий елемент, переконатися, що структура повертає Null.
        assert bst.get(maxN + 1) == null : "index undefined";

        //	4. Створити дерево з п. 1., попередньо викинувши з нього один із ключів у середині.
        //	Тобто в отриманому дереві повинен бути відсутнім один елемент порівняно з Map, краще, якщо це значення з середини діапазону.
        int removableIndex = maxN / 2;
        bst.remove(removableIndex);

        //Вставити новий елемент із цим пропущеним ключем.
        bst.insert(removableIndex, "new_value_" + removableIndex);

        //Провести пошук по цьому ключу, переконатися, що елемент присутній у дереві
        assert bst.get(removableIndex).equals("new_value_" + removableIndex) : "element is`nt in tree";

        //Вставити елемент із вже існуючим ключем, але іншим значенням рядка
        int replaceRemovableIndex = N + 1;
        bst.insert(replaceRemovableIndex, "new_value_" + replaceRemovableIndex);

        //провести обхід дерева, перевірити, що кількість вузлів дорівнює 20
        assert bst.size() == 20  : "tree elements count != " + max;

        //Провести пошук по цьому ключу і переконатися, що значення оновилося
        assert bst
                .get(replaceRemovableIndex)
                .equals("new_value_" + replaceRemovableIndex)  : "new value is undefined";

        //5. Видалити елемент із ключем із середини списку.
        bst.remove(removableIndex);

        //провести обхід дерева, перевірити, що кількість вузлів дорівнює 19
        assert bst.size() == 19 : "tree elements count != 19";

        //Провести пошук по цьому ключу, переконатися, що елемент відсутній, і метод повертає null
        assert bst.get(removableIndex) == null : "deleted element is still in tree";
    }

    public static ArrayList<Node> GetDataMap(int N) {
        ArrayList<Node> map = new ArrayList<Node>();

        for (int i = 0; i < 20; i++) {
            map.add(new Node(N + i, "value_" + rand.nextInt(100000)));
        }

        return map;
    }
}
