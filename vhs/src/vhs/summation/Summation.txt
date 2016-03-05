package vhs.summation;

public class Summation {

	private static int low, high, result; // VARIABLES USED IN THIS CLASS.

	// CONSTRUCTOR METHOD 1

	public Summation() {

		low = 1;

		high = 10;

		result = sum(low, high);

	}

	// CONSTRUCTOR METHOD 2

	public Summation(int a, int b) {

		low = a;

		high = b;

		result = sum(low, high);

	}

	// STATIC METHOD FOR SUM

	private static int sum(int a, int b) {
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println();
		if (a >= b) return a;
		int result = a + sum(a + 1, b);
		System.out.println("returned: " + result);
		System.out.println();
		return result;
	}

	public String toString() {

		String a = "The recursive sum is: " + result;

		return a;

	}

}
