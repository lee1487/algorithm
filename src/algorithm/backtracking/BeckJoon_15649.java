package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeckJoon_15649 {

	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		//m개를 나열할 수 있는 배열을 생성
		arr = new int[m];
		//이미 사용한 숫자에 대해 중복을 허용하지 않기 위해서
		visit = new boolean[n];
        //깊이 우선 탐색을 적용할 것이다.
		dfs(n,m,0);
		System.out.println(sb);
	}

	public static void dfs(int n, int m, int depth) {
        //마지막 깊이에 해당하면 해당 arr을 StringBuilder에 저장하고 줄바꿈 하고 return
		if (depth == m) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i=0; i< n; i++) {
            //해당 숫자를 사용하지 않았으면
			if (!visit[i]) {
                //숫자 사용한다고 저장하고
				visit[i] = true;
				arr[depth] = i+1;
                //재귀함수를 적용
				dfs(n,m, depth + 1);
                // 해당 깊이에서 사용하고 흔적을 지워 이전 깊이에서 사용할 수 있도록 하기 위해서 false해줘야됨
				visit[i] = false;
			}
		}
	}

}
