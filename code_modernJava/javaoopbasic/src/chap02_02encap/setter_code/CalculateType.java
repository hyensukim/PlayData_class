package chap02_02encap.setter_code;

import java.util.function.BiFunction;

public enum CalculateType {
    /*
        제어 자료와 실제로 제어 되었을 때 실행할 구문까지 함께 저장함.
        이는, 응집도가 높아짐을 의미한다.(관련된 로직끼리 하나의 파일에 잘 구성)
     */
    ADD ((num1, num2) -> num1 + num2),
    MINUS ((num1, num2) -> num1 - num2),
    MULTIPLY ((num1, num2) -> num1 * num2),
    DIVIDE ((num1, num2) -> num1 / num2);

    // 생성자
    CalculateType(BiFunction<Integer, Integer, Integer> expression) {
        this.expression = expression;
    }

    // expression은 각 이넘 자료에 매칭된 함수이므로
    // 선언 자료형은 BiFunction<input1, input2, return>
    private BiFunction<Integer, Integer, Integer> expression;

    // 멤버 메서드를 통해 calculate를 수행하는데 이 과정에서
    // 어떤 이넘 타입(ADD, MINUS, MULTIPLY, DIVIDE)냐에 따라 실행되는게 다름.
    public int calculate(int num1, int num2) {
        return this.expression.apply(num1, num2);
    }
}

