package org.grade;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {

        return courses.stream() // courses를 전부 돌면서
                .mapToDouble(Course::multiplyCreditAndCourseGrade) // course안의 multiplayCreditAndCourseGrade 함수를 다 실행한 값을 가지고
                .sum(); // 다 더한다
    }

    public int calculateTotalCompletedCredit() {
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return totalCompletedCredit;
    }
}
