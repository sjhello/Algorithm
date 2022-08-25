package inflearn;

import java.util.*;
import java.io.*;

public class BinaryNumber {

	public void DFS(int n) {
		if (n == 0) {
			return ;
		} else {
			DFS(n / 2);
			System.out.println(n % 2 + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		BinaryNumber binaryNumber = new BinaryNumber();
		binaryNumber.DFS(n);
	}
}
