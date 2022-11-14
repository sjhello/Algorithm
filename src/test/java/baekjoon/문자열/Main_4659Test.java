package baekjoon.문자열;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Main_4659Test {

	@DisplayName("문자열이 정규표현식에 적합한 문자인지 테스트 한다")
	@ParameterizedTest
	@ValueSource(strings = {"aeiou", "smith"})
	void regExTest(String str) {

		/*
		 * 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
		 * 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
		 * 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
		 * */
		String regex = "^[^aeiou]+$|[aeiou]{3,}|[^aeiou]{3,}|([^eo])\\1+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		assertThat(matcher.find()).isFalse();
	}
}
