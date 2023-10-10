package chap02_02encap.prev_code;

public class Client {
    public int someMethod(CalculateCommand calculateCommand){
        CalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum2();
        
        int result = calculateType.calculate(num1,num2); //객체지향적으로 정리된 메서드
        return result;
    }
}
