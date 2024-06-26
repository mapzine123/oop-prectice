package org.calculater;

public class Calculator {
    public static int calculate(int operand1, String operator, int operand2) {
//        --- 기존 방식
//        if("+".equals(operator)) {
//            return operand1 + operand2;
//        } else if("-".equals(operator)) {
//            return operand1 - operand2;
//        } else if("*".equals(operator)) {
//            return operand1 * operand2;
//        } else if("/".equals(operator)) {
//            return operand1 / operand2;
//        }

//        --- enum 사용
        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }
}
