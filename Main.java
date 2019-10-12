import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int n = 2;
		// result [[1,2], [1,3], [2,3]]

		
		for (int[] r : new Solution().solution(n)) {
			System.out.print(Arrays.toString(r) + " ");
		}
	}

}

class Solution {
	int[][] result;
	int idx = 0;
	public int[][] solution(int n) {
		result = new int[(int) Math.pow(2, n) - 1][2];
		simulateHanoi(1, 3, 2, n);
		return result;
	}
	
	private void simulateHanoi(int start, int dest, int temp, int n) {
		if (n >= 1) {
			simulateHanoi(start, temp, dest, n-1);
			result[idx][0] = start;
			result[idx][1] = dest;
			idx++;
			simulateHanoi(temp, dest, start, n-1);
		}
	}

}