package chap02_02encap.prev_code;

public class PreviousCodeExampleMain {
    public static void main(String[] args) {
        CalculateCommand calculateCommand
                = new CalculateCommand(CalculateType.DIVIDE,1,0);

        Client client = new Client();
        int result = client.someMethod(calculateCommand);
    }
}
