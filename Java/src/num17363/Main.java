package num17363;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = 7;
		int n = 14;

		String arr[][] = new String[n][m];

		HashMap<String, String> myMap = new HashMap();

		myMap.put(".", ".");
		myMap.put("O", "O");
		myMap.put("-", "|");
		myMap.put("|", "-");
		myMap.put("/", "\\");
		myMap.put("\\", "/");
		myMap.put("^", "<");
		myMap.put("<", "v");
		myMap.put("v", ">");
		myMap.put(">", "^");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scanner.next();
			}
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				System.out.print(myMap.get(arr[j][i]));
			}
			System.out.println();
		}

	}

}
