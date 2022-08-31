package inflearn;

public class DFS {

    static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public static void DFS(Node root) {
        if (root == null) {
            return ;
        } else {
            // 전위 순회
            DFS(root.lt);
            // 중위 순회
            DFS(root.rt);
            // 후위 순회
        }
    }

    public static void main(String[] args) {
        DFS tree = new DFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);
    }
}
