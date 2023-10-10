package chap02_01lessif.many_if;

public class CalculateCommand {
    private CalculateType calculateType; // 이 필드에는 ADD, MINUS, MULTIPLY, DIVIDE 넷 중 하나만 대입 가능
    private int num1; // 이 필드에는 정수이기만 하면 숫자가 몇이건 범위 내에서 다 대입 가능
    private int num2;

    public CalculateCommand(CalculateType calculateType, int num1, int num2) {
        this.calculateType = calculateType;
        this.num1 = num1;
        this.num2 = num2;
    }

    public CalculateType getCalculateType() {
        return calculateType;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}