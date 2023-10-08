package chap01_04enum.basic;

/**
 * 덧셈 뺄셈 곱셈 나눗셈 중 하나의 연산을 수행하라는 명령에 대한 정보를 묶어서 저장 중인 클래스
 */
public class CalculateCommand {
    private CalculateType calculateType;
    private int num1;
    private int num2;

    public CalculateCommand(CalculateType calculateType, int  num1, int num2){
        this.calculateType = calculateType;
        this.num1 = num1;
        this.num2 = num2;
    }

    public CalculateType getCalculateType(){
        return calculateType;
    }
    public int getNum1(){
        return num1;
    }
    public int getNum2(){
        return num2;
    }
}
