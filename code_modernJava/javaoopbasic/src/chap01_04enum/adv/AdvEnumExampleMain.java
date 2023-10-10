package chap01_04enum.adv;

public class AdvEnumExampleMain {
    public static void main(String[] args) {
        CalculateCommand calculateCommand = new CalculateCommand(
                CalculateType.ADD,
                100,3
        );//클라이언트가 요청할 때 준 데이터 사용
        
        Client client = new Client();
        int result = client.someMethod(calculateCommand);
        System.out.println(result);
    }
}
