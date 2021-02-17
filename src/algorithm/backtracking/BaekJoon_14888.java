package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_14888 {

	public static int max = Integer.MIN_VALUE;	// 최댓값
	public static int min = Integer.MAX_VALUE;	// 최솟값
	public static int[] operator = new int[4];	// 연산자 갯수
	public static int[] number;					// 숫자
	public static int n;						// 숫자 갯수

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		number = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(number[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int num, int idx) {
		if (idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i=0; i<4; i++) {
			// 연산자 갯수가 1개 이상인 경우
			if (operator[i] > 0) {

				// 해당 연산자를 사용하기 위해 1 감소
				operator[i]--;

				switch (i) {
					case 0: dfs(num + number[idx], idx + 1); break;
					case 1: dfs(num - number[idx], idx + 1); break;
					case 2: dfs(num * number[idx], idx + 1); break;
					case 3: dfs(num / number[idx], idx + 1); break;
				}
				// 재귀 호출이 종료되면 다시 해당 연산자 개수를 복구 한다
				operator[i]++;
			}
		}

	}

}
