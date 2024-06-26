package org.calculater.operator;

/**
 * 0으로 나누면 예외 발생 상황 처리
 * 응집도가 높기 때문에, DivisionOperator 클래스만 수정하면 됨
 * 다른 operator에는 영향 없음
 */

public class DivisionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if(operand2 == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }
        return operand1 / operand2;
    }
}
