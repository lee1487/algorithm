package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2580 {

	public static int[][] arr = new int[9][9];	//스도쿠에 들어갈 값들을 2차원 배열을 활용

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 이차원 배열에 값을 대입
		for (int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sudoku(0,0);

	}

	public static void sudoku(int row, int col) {

		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}

		if (row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}

			System.out.println(sb);
			// 출력뒤에 시스템을 종료
			System.exit(0);
		}

		if (arr[row][col] == 0) {
			for (int i=1; i<=9; i++) {
				// i값이 중복되지 않는지 검사
				if (possible(row,col,i)) {
					arr[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}

		sudoku(row, col + 1);

	}

	public static boolean possible(int row, int col, int value) {

		//같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for (int i=0; i<9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}

		//같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for (int i=0; i<9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}

		// 3*3 칸에 중복되는 원소가 있는지 검사
		int set_row = (row / 3) * 3;
		int set_col = (col / 3) * 3;

		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}


		return true; 	// 중복되는 것이 없을 경우 true 반환


	}

}
