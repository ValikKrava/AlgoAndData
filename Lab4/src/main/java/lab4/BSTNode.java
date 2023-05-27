package lab4;


class BSTNode {

    private Node root;
    private int size = 0;

    public void insert(int key, String value) {
        root = insertHelper(root, key, value);
    }

    private Node insertHelper(Node node, int key, String value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key < node.key) {
            node.left = insertHelper(node.left, key, value);
        } else if (key > node.key) {
            node.right = insertHelper(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    private Node removeHelper(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = removeHelper(node.left, key);
        } else if (key > node.key) {
            node.right = removeHelper(node.right, key);
        } else {
            size--;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node minNode = findMin(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = removeHelper(node.right, node.key);
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public String get(int key) {
        return getHelper(root, key);
    }

    private String getHelper(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            return getHelper(node.left, key);
        } else if (key > node.key) {
            return getHelper(node.right, key);
        } else {
            return node.value;
        }
    }

    public void traverse() {
        traverseHelper(root);
    }

    private void traverseHelper(Node node) {
        if (node != null) {
            traverseHelper(node.left);
            System.out.println(node.key + ": " + node.value);
            traverseHelper(node.right);
        }
    }

    public int size() {
        return size;
    }
}

