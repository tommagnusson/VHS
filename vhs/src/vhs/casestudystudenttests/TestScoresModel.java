package vhs.casestudystudenttests;

import java.util.ArrayList;
import java.util.List;

// Case Study 10.1: TestScoresModel class

public class TestScoresModel {

	private List<Student> students; // Array of students
	private int indexSelectedStudent; // Position of current student

	public TestScoresModel() {

		// Initialize the data
		indexSelectedStudent = -1;
		students = new ArrayList<Student>();
	}

	// Mutator methods for adding and replacing students

	public void add(Student s) {
		students.add(s);
		indexSelectedStudent = students.size();
	}

	public void replace(Student s) {
		checkIfNoStudents();
		students.set(indexSelectedStudent, s);
	}

	// Navigation methods

	public Student first() {
		Student s = null;
		checkIfNoStudents();
		indexSelectedStudent = 0;
		s = students.get(indexSelectedStudent);
		return s;
	}

	public Student previous() {
		Student s = null;
		if (students.size() == 0)
			indexSelectedStudent = -1;
		else {
			indexSelectedStudent = Math.max(0, indexSelectedStudent - 1);
			s = students.get(indexSelectedStudent);
		}
		return s;
	}

	public Student next() {
		Student s = null;
		checkIfNoStudents();
		indexSelectedStudent = Math.min(students.size() - 1,
				indexSelectedStudent + 1);
		s = students.get(indexSelectedStudent);
		return s;
	}

	public Student last() {
		Student s = null;
		checkIfNoStudents();
		indexSelectedStudent = students.size() - 1;
		s = students.get(indexSelectedStudent);
		return s;
	}

	// Accessors to observe data

	public Student currentStudent() {
		if(students.size() == 0) {
			return null;
		}
		return students.get(indexSelectedStudent);
	}

	public int size() {
		return students.size();
	}

	public int currentPosition() {
		return indexSelectedStudent;
	}

	public int getClassAverage() {
		checkIfNoStudents();
		// gets each student's average, then finds the average of that list
		return (int) students.stream().mapToInt(Student::getAverage).average()
				.getAsDouble();
	}

	public Student getHighScore() {
		checkIfNoStudents();
		return students.stream().reduce((s1, s2) -> {
			if (s1.getHighScore() > s2.getHighScore()) {
				return s1;
			}
			return s2;
		}).get();
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < students.size(); i++)
			result = result + students.get(i) + "\n";
		return result;
	}

	private void checkIfNoStudents() {
		if (students.size() == 0)
			throw new IllegalStateException("You must add students first.");
	}
}
