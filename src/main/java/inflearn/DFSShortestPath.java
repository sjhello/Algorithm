package inflearn;


/*
* DFS 말단노드까지의 가장 짧은 경로 탐색(최단경로 탐색)
* */
public class DFSShortestPath {

    static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public static int DFS(int level, Node root) {
        if (root.lt == null && root.rt == null) {
            return level;
        } else {
            int smaller = Math.min(DFS(level + 1, root.lt), DFS(level + 1, root.rt));
            return smaller;
        }
    }

    public static void main(String[] args) {
        DFSShortestPath dfsShortestPath = new DFSShortestPath();

        dfsShortestPath.root = new Node(1);
        dfsShortestPath.root.lt = new Node(2);
        dfsShortestPath.root.rt = new Node(3);
        dfsShortestPath.root.lt.lt = new Node(4);
        dfsShortestPath.root.lt.rt = new Node(5);

        int result = DFSShortestPath.DFS(0, dfsShortestPath.root);
        System.out.println(result);
    }
}
