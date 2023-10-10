package chap02_01lessif.check_in_cons;

public class CheckInConsMain {
    public static void main(String[] args) {
        CalculateCommand calculateCommand
                = new CalculateCommand(CalculateType.DIVIDE,1,0);

        Client client = new Client();
        int result = client.someMethod(calculateCommand);
    }
}
