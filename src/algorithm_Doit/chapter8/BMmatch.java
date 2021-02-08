package algorithm_Doit.chapter8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BMmatch {

	static int bmMatch(String txt, String pat) {
		int pt;	// txt커서
		int pp;	// pat커서
		int txtLen = txt.length();	// txt의 문자 개수
		int patLen = pat.length();	// pat의 문자 개수
		int[] skip = new int[Character.MAX_VALUE + 1];	//건너뛰기 표

		// 건너뛰기 표 만들기
		for (pt = 0; pt<=Character.MAX_VALUE; pt ++)
			skip[pt] = patLen;
		for (pt = 0; pt<patLen -1; pt++)
			skip[pat.charAt(pt)] = patLen - pt - 1; 		// pt == patLen - 1;

		//검색
		while (pt < txtLen) {
			pp = patLen - 1;	// pat의 끝 문자에 주목

			while (txt.charAt(pt) == pat.charAt(pp)) {
				if (pp == 0)
					return pt;	// 검색 성공
				pp--;
				pt--;
			}
			pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
		}
		return -1;
	}

	static int findBMmatch(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;

		if (m == 0) return 0;

		Map<Character, Integer> last = new HashMap<>();
		for (int i=0; i< n; i++)
			last.put(text[i], -1);
		for (int i=0; i<m; i++)
			last.put(pattern[i], i);

		int i = m - 1;
		int j = m - 1;
		while (i < n) {
			if (text[i] == pattern[j]) {
				if (j == 0) {
					System.out.println("\tFound match at index " + i);
					return i;
				}
				i--; j--;

			} else {
				i += m - Math.min(j, 1 + last.get(text[i]));
				j = m - 1;
			}
		}
		System.out.println("\nNo match found");
		return -1;
	}

	public static void main(String[] args) {
		/*Scanner stdIn = new Scanner(System.in);

		System.out.print("텍스트: ");
		String s1 = stdIn.next();

		System.out.print("패턴: ");
		String s2 = stdIn.next();

		int idx = bmMatch(s1,s2);

		if (idx == -1)
			System.out.println("텍스트에 패턴이 없습니다.");
		else {
			int len = 0;
			for (int i = 0; i < idx; i++)
				len += s1.substring(i, i + 1).getBytes().length;
			len += s2.length();

			System.out.println((idx + 1) + "번째 문자와 일치합니다.");
			System.out.println("텍스트：" + s1);
			System.out.printf(String.format("패턴：%%%ds\n", len), s2);
		}*/

		char [] text = "ABAAABCD".toCharArray();
		char [] pattern = "ABC".toCharArray();

		findBMmatch(text,pattern);
	}
}
