package chap01_04enum.adv;

// 고객
public class Client {
    public int someMethod(CalculateCommand calculateCommand){
        CalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum2();

        /*
        Enum 안에 함수형 객체로 정의하여, CalculateType의 값 종류에 따른 연산이 내부적으로 이뤄지도록 하여,
        사용자 입장에서는 별도로 연산이 어떻게 이뤄지는지 알필요가 없어지도록 구현되었다.
         */
        return calculateType.calculate(num1,num2);
    };

    public int someMethod(CalculateType calculateType,int num1,int num2){
        return calculateType.calculate(num1,num2);
    }
}
