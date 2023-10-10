package chap01_05exception.checked_exception;

public class CheckedExceptionExampleMain {
    public static void main(String[] args) {
        Client client  = new Client();

        /*
        해당 메서드가 throws를 통해 호출하는 곳으로 예외 전가를 한 상태이므로
        현재 호출하는 곳에서 예외를 처리해줘야 한다.
        */
        try {
            client.throwsCheckedExceptionMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 이미 메서드를 정의한 곳에서 예외를 처리한 경우 호출하는 곳에서 처리할 필요가 없다.
        client.tryCatchCheckedExceptionMethod();
    }
}
