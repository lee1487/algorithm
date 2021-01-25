package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeckJoon_15652 {

		public static int[] arr;
		public static int n, m;
		public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];

		dfs(1,0);
		System.out.println(sb);

	}

	public static void dfs(int at, int depth) {
		if (m == depth) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i=at; i<=n; i++) {
			arr[depth] = i;
			dfs(i, depth+1);	//중복허용해서 비내림차순이므로 그냥 i를 넘김
		}

	}
}
