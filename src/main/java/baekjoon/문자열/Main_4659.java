package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 비밀번호 발음하기
* 정규 표현식
* */
public class Main_4659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/*
		* 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
		* 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
		* 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
		* */
		String regex = "^[^aeiou]+$|[aeiou]{3,}|[^aeiou]{3,}|([^eo])\\1+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;

		String str;
		while (!"end".equals(str = br.readLine())) {
			matcher = pattern.matcher(str);
			String result = matcher.find() ? "not acceptable." : "acceptable.";
			bw.write("<" + str +"> is " + result + "\n");
		}

		bw.flush();
	}
}
