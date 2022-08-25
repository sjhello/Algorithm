package inflearn;

public class Factorial {
	public int DFS(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * DFS(n - 1);
		}
	}

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.DFS(5));
	}
}
