package org.grade;

import java.util.List;


public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 요구사항
     * 평균 학점 계산 방법 = (학점수 * 교과목 평점)의 합계 / 수강신청 총 학점 수
     * 일급 컬렉션 사용
     */


    public double calculateGrade() {
//      (학점수 * 교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = 0;
        /**
         *  Course 객체에서 학점과 교과목 평점을 가지고와서 GradeCalculator에서 계산함
         *  만약 밑의 for문 -> (학점수 * 교과목 평점)의 합계 를 구하는 로직이 바뀌면?
         *  이런식으로 코드를 짜면 이 로직을 사용하는 곳 모두 수정을 해야함
         *  즉, 응집도가 약하다.
         *
         *  근데 만약 Course 객체 내부에서 계산을 다 해준다면?
         *  정보를 가진 객체에게 메시지를 전달하여 해당 객체에서 작업을 수행하면 정보를 가진 객체만 수정하면 됨
         *  응집도가 높아져 변화가 발생했을 때 한 곳만 수정하면 된다는 이점이 발생
         */
        for (Course course : courses) {
//          getter를 쓰는게 아니라 메시지를 전달해 해당 객체에게 작업을 위임하는 방식으로 변경
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

//      수강신청 총 학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

//      평균 학점 계산 방법 = (학점수 * 교과목 평점)의 합계 / 수강신청 총 학점 수
        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }


}
