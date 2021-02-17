package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_9663 {

	public static int[] arr;		// index열의 몇번째 행인지 값을 입력
	public static int n;			// 체스 판의 크기
	public static int count = 0;	// 경우의 수


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		nQueen(0);
		System.out.println(count);
	}

	public static void nQueen(int col) {
		// 행을 다 채우면 카운트를 1 증가시키고 리턴한다.
		if (n == col) {
			count++;
			return;
		}

		for (int i=0; i<n; i++) {
			arr[col] = i;			// col 열의 i행 값을 arr에 입력
			// 놓을 수 있는 위치일 경우 재귀 호출 (해당 열에 놓을 수 있으면 다음 열 에 놓을 행 값 으로 재귀)
			if (Possibility(col)) {
				nQueen(col + 1);
			}
		}

	}

	public static boolean  Possibility(int col) {

		for (int i=0; i<col; i++) {
			// 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재할 경우)
			if (arr[col] == arr[i]) {
				return false;
			}

			/* 열을 기준으로 1열 -> 2열 -> 3열 에 놓을 것만 찾으면 되기 때문에 '/'대각선만 체크하면 됨
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 */
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}

		return true;
	}

}
