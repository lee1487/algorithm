package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_15651 {

	public static int[] arr;
	// m을 전역변수로 해서 dfs 파라미터를 줄임
	public static int n, m;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// m개를 뽑을 수 있는 배열 을 만들어줌
		arr = new int[m];
		// 깊이 우선탐색 적용
		dfs(n,0);
		System.out.println(sb);
	}

	public static void dfs(int n, int depth) {
		if (m == depth) {	// 깊이가 같아지면 저장
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append("\n");
			return;
		}

		// 중복을 허용하기 때문에 별다른 조건 없음
		for (int i=0; i<n; i++) {
			arr[depth] = i+1;
			dfs(n, depth + 1);
		}

	}
}
