package inflearn;

import java.util.LinkedList;
import java.util.Queue;

/*
* 넓이우선탐색(레벨 탐색)
* */

class Node {
	int data;
	Node lt;
	Node rt;

	public Node(int val) {
		data = val;
		lt = null;
		rt = null;
	}
}

public class BFSMain {
	Node root;

	public void BFS(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);		// add()와 같다
		int level = 0;

		while(!q.isEmpty()) {
			int length = q.size();

			System.out.print(level + " : ");

			for (int i = 0; i < length; i++) {
				Node current = q.poll();
				System.out.print(current.data + " ");

				if (current.lt != null) {
					q.offer(current.lt);
				}

				if (current.rt != null) {
					q.offer(current.rt);
				}
			}

			level++;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BFSMain bfsMain = new BFSMain();
		bfsMain.root = new Node(1);
		bfsMain.root.lt = new Node(2);
		bfsMain.root.rt = new Node(3);
		bfsMain.root.lt.lt = new Node(4);
		bfsMain.root.lt.rt = new Node(5);
		bfsMain.root.rt.lt = new Node(6);
		bfsMain.root.rt.rt = new Node(7);

		bfsMain.BFS(bfsMain.root);
	}
}
