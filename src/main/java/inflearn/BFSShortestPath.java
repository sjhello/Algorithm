package inflearn;


import java.util.LinkedList;
import java.util.Queue;

/*
* BFS 말단노드까지의 가장 짧은 경로 탐색(최단경로 탐색)
* */
public class BFSShortestPath {
    static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
        }
    }

    public int BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node current = q.poll();
                if (current.lt == null && current.rt == null) {
                    return level;
                }

                if (current.lt != null) {
                    q.offer(current.lt);
                }

                if (current.rt != null) {
                    q.offer(current.rt);
                }
            }
            level++;
        }

        return -1;
    }

    Node root;

    public static void main(String[] args) {
        BFSShortestPath bfsShortestPath = new BFSShortestPath();
        bfsShortestPath.root = new Node(1);
        bfsShortestPath.root.lt = new Node(2);
        bfsShortestPath.root.rt = new Node(3);
        bfsShortestPath.root.lt.lt = new Node(4);
        bfsShortestPath.root.lt.rt = new Node(5);

        int result = bfsShortestPath.BFS(bfsShortestPath.root);
        System.out.println(result);
    }

}
