package edu.handong.analysis.datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
	private String studentId;
	private ArrayList<Course> coursesTaken; // List of courses student has taken
	private HashMap<String,Integer> semestersByYearAndSemester; 

	
	public Student(String studentId) {
		this.studentId = studentId;
		coursesTaken = new ArrayList<Course>();
		semestersByYearAndSemester = new HashMap<String, Integer>();
	}
	
	public void addCourse(Course newRecord) {
		coursesTaken.add(newRecord);
	}
	public HashMap<String,Integer> getSemestersByYearAndSemester(){
		int year, semesterCourse = 0;
		String yearSemester;
		int numCourse = coursesTaken.size();
		
		Course getCourse = coursesTaken.get(numCourse - 1);
		year = getCourse.getYearTaken();
		semesterCourse = getCourse.getSemesterCourseTaken();
		yearSemester = String.valueOf(year) + "-" + String.valueOf(semesterCourse);
		
		semestersByYearAndSemester.put(yearSemester, semestersByYearAndSemester.size()+1);
		
		return semestersByYearAndSemester;
		
	}
	public int getNumCourseInNthSementer(int semester) {
		int year, semesterCourse, numCourseInNthSementer = 0;
		String yearSemester;
		
		for (Course course : coursesTaken) {
			year = course.getYearTaken();
			semesterCourse = course.getSemesterCourseTaken();
			yearSemester = String.valueOf(year) + "-" + String.valueOf(semesterCourse);
			
			if (semester == semestersByYearAndSemester.get(yearSemester)) {
				numCourseInNthSementer++;
			}
		}
		return numCourseInNthSementer;
		
	}
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public ArrayList<Course> getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(ArrayList<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

}
