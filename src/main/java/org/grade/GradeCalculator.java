package org.grade;

import java.util.List;


public class GradeCalculator {
    private final Courses courses;


    public GradeCalculator(List<Course> courses) {
    /**
     *  List로 받더라도 일급컬렉션으로 전달
     *  이렇게 하면 courses에 대한 연산을 Courses에게 위임할 수 있음
     *
     *  일급 컬레션은 뭐냐??
     *  리스트 형태로 된 정보만 가진 객체 (다른게 있으면 안됨)
     *  멤버변수에 List<Course> courses; 하나만 있어야함
     *  위 List로 처리할 수 있는 책임들이 해당 일급컬렉션 밑으로 이동하게 된다.
     *
     */
        this.courses = new Courses(courses);
    }

    /**
     * 요구사항
     * 평균 학점 계산 방법 = (학점수 * 교과목 평점)의 합계 / 수강신청 총 학점 수
     * 일급 컬렉션 사용
     */


    public double calculateGrade() {
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

        /**
         * Course에 대한 로직 처리가 GradeCalculator 안에 있음
         * 일급 컬렉션을 사용해 처리
         */
//      (학점수 * 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();

//      수강신청 총 학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

//      평균 학점 계산 방법 = (학점수 * 교과목 평점)의 합계 / 수강신청 총 학점 수
        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }


}
