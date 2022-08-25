package inflearn;

public class Fibo {

	static int[] fibo;

	public int DFS(int n) {
		if (n == 1) return fibo[n] = 1;
		if (n == 2) return fibo[n] = 1;
		else if (fibo[n] != 0) return fibo[n];
		else return fibo[n] = DFS(n - 2) + DFS(n - 1);
	}

	public static void main(String[] args) {
		int n = 45;
		fibo = new int[n + 1];

		Fibo t = new Fibo();
		t.DFS(n);

		for (int i = 1; i <= n; i++) {
			System.out.println(fibo[i]);
		}
	}
}
