package num15956;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		String[] splitedInput = input.split("&&");

		Vector<String> leftEqualVector = new Vector<String>();
		Vector<String> rightEqualVector = new Vector<String>();

		Vector<String> leftNotEqualVector = new Vector<String>();
		Vector<String> rightNotEqualVector = new Vector<String>();

		for (int i = 0; i < splitedInput.length; i++) {
			System.out.println(splitedInput[i]);
		}

		for (int i = 0; i < splitedInput.length; i++) {

			String temp[] = splitedInput[i].split("==");

			if (temp.length == 2) {
				leftEqualVector.add(temp[0]);
				rightEqualVector.add(temp[1]);
			} else {
				String temp2[] = splitedInput[i].split("!=");
				leftNotEqualVector.add(temp2[0]);
				rightNotEqualVector.add(temp2[1]);
			}

		}

		System.out.println("=========================");
		for (int i = 0; i < leftEqualVector.size(); i++) {
			System.out.println(leftEqualVector.get(i));
		}
		System.out.println();
		for (int i = 0; i < rightEqualVector.size(); i++) {
			System.out.println(rightEqualVector.get(i));
		}
		System.out.println();
		for (int i = 0; i < leftNotEqualVector.size(); i++) {
			System.out.println(leftNotEqualVector.get(i));
		}
		System.out.println();
		for (int i = 0; i < rightNotEqualVector.size(); i++) {
			System.out.println(rightNotEqualVector.get(i));
		}
		System.out.println("=========================");

		// union find
		
		Vector<String> parent = new Vector<String>();
		Vector<String> child = new Vector<String>();
		
		
		
		
	}

}
