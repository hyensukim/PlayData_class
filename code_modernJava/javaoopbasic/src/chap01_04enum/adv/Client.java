package chap01_04enum.adv;

public class Client {
    public int someMethod(CalculateType calculateType,int num1,int num2){
        return calculateType.calculate(num1,num2);
    }
}
