package baekjoon;

import java.io.*;

public class Main_17478 {

	static int tokenNumber = -1;	// 마지막 출력이 token이 없어야 하기 때문에 -1부터 시작
	static String token = "";
	static String question = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	static String first = "\"재귀함수가 뭔가요?\"\n";
	static String recursionSentence = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
		+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
		+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String last = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String reply = "라고 답변하였지.\n";

	public static void recursion(int n, StringBuilder sb) {
		String line = "____";

		if (n == 0) {
			sb.append(token);
			sb.append(first);
			sb.append(token);
			sb.append(last);
			sb.append(token);
			sb.append(reply);

			return ;
		}

		sb.append(token);
		sb.append(first);

		String[] arr = recursionSentence.split("\n");
		for (int i = 0; i < arr.length; i++) {
			sb.append(token);
			sb.append(arr[i]);
			sb.append("\n");
		}

		token +=  line;
		tokenNumber++;
		recursion(n - 1 , sb);

		sb.append(line.repeat(tokenNumber));
		sb.append(reply);
		tokenNumber--;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(question);
		recursion(n, stringBuilder);
		System.out.println(stringBuilder.toString());
	}
}
