package main;

public class Solution {
	public static void main(String args[]) {
		Solution test = new Solution();
		for (int i = 1; i <= 12; i++) {
			for (int j = i; j <= 12; j++) {
				test.printTable(j, i);
				System.out.println();
			}
		}
	}
	
	public void printTable(int num1, int num2) {
		int result = num1 * num2;
		int spaceCount = 5; // define the Right boundary of the display
		int rightSpaceCount = 0;
		if (num1 < num2) {	// larger one appear in the first line is look better
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		// display first number
		for (int i = 0; i < spaceCount - (num1 >= 10 ? 2 : 1); i++) {
			System.out.print(" ");
		}
		System.out.println(num1);
		
		// display second number
		System.out.print("*");
		for (int i = 1; i < spaceCount - (num2 >= 10 ? 2 : 1); i++) {
			System.out.print(" ");
		}
		System.out.println(num2);
		System.out.println("-----");
		int num2Copy = num2;
		
		// display the process of multiplication
		while (num2 > 0) {
			int pop = num2 % 10;
			num2 = num2 / 10;
			if (num2 == 0 && num2Copy >= 10 && num1 >= 10) {
				System.out.print("+");
			}
			for (int i = 0; i < spaceCount - (pop * num1 >= 10 ? 2 : 1) - (pop * num1 >= 100 ? 1 : 0)
					- rightSpaceCount - ((num2 == 0 && num2Copy >= 10 && num1 >= 10) ? 1 : 0); i++) {
				System.out.print(" ");
			}
			System.out.print(pop * num1);
			for (int i = 0; i < rightSpaceCount; i++) {
				System.out.print(" ");
			}
			System.out.println();
			rightSpaceCount++;
		}
		
		// since the range is up to 12 * 12, final result can be easily displayed
		if (rightSpaceCount > 1) {
			System.out.println("-----");
			for (int i = 0; i < spaceCount - 3; i++) {
				System.out.print(" ");
			}
			System.out.println(result);
		}
	}
}
