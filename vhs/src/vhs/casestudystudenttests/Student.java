package vhs.casestudystudenttests;

//Case Study 10.1: Student class

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Student {

	private String name;
	private List<Integer> tests;

	// Default: Name is "" and 3 scores are 0
	public Student() {
		this("");
	}

	// Name is nm and 3 scores are 0
	public Student(String nm) {
		this(nm, 3);
	}

	// Name is nm and n scores are 0
	public Student(String nm, int n) {
		name = nm;
		tests = new ArrayList<Integer>();
		// For some reason Collections.fill() doesn't work
		for (; n > 0; n--) {
			tests.add(0);
		}
	}

	// Name is nm and scores are in t
	public Student(String nm, int[] t) {
		name = nm;
		//      int[] -> Integer[] -> List<Integer>
		tests = Arrays.stream(t).boxed().collect(Collectors.toList());
	}

	public Student(String nm, List<Integer> t) {
		name = nm;
		tests = new ArrayList<Integer>(t);
	}

	// Builds a copy of s
	public Student(Student s) {
		this(s.name, s.tests);
	}

	public int getNumberOfTests() {
		return tests.size();
	}

	public void setName(String nm) {
		name = nm;
	}

	public String getName() {
		return name;
	}

	public void setScore(int i, int score) {
		tests.set(i, score);
	}

	public int getScore(int i) {
		return tests.get(i);
	}

	public int getAverage() {
		return (int) tests.stream().mapToInt(Integer::valueOf).average()
				.getAsDouble();
	}

	public int getHighScore() {
		//     List<Integer> -> IntStream -> max value in IntStream
		return tests.stream().mapToInt(Integer::intValue).max().getAsInt();
	}

	public String toString() {
		String str = "Name:    " + name + "\n";
		for (int i = 0; i < tests.size(); i++)
			str += "test " + i + ":  " + tests.get(i) + "\n";
		str += "Average: " + getAverage();
		return str;
	}

	// Returns null if there are no errors else returns
	// an appropriate error message.
	// ... Should these not be exceptions?
	public String validateData() {
		if (name.equals(""))
			return "SORRY: name required";
		for (int score : tests) {
			if (score < 0 || score > 100) {
				String str = "SORRY: must have " + 0 + " <= test score <= "
						+ 100;
				return str;
			}
		}
		return null;
	}
}
