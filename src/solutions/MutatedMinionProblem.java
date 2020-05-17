package solutions;

import java.util.Scanner;

public class MutatedMinionProblem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = Integer.parseInt(scanner.nextLine());

		while (numberOfTestCases > 0) {
			String[] input = scanner.nextLine().split(" ");

			int transaformationValue = Integer.parseInt(input[1]);

			String[] values = scanner.nextLine().split(" ");

			int[] data = new int[values.length];
			int i = 0;

			for (String s : values) {
				data[i] = Integer.parseInt(s);
				i++;
			}
			int result = 0;
			
			for (int j = 0; j < data.length; j++) {

				if ((data[j] + transaformationValue) % 7 == 0) {
					result++;
				}
			}

			System.out.println(result);
			
			numberOfTestCases--;
		}
	}

}
