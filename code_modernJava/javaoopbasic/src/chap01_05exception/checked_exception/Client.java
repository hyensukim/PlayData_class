package chap01_05exception.checked_exception;

public class Client {
    // 예외를 발생시키려면 반드시 try~catch 구문을 써서 처리해줘야 한다.
    public void tryCatchCheckedExceptionMethod(){
        // checked exception의 경우 발생 구문이 호출되면 무조건 예외처리가 동반되어야 한다.
        try{
            throw new CheckedException();
        }catch(Exception e){
            // 예외 처리 코드
            e.printStackTrace();
        }
    }

    // 예외 처리를 호출하는 곳에서 처리하도록 떠넘기고 싶은 경우, throws를 사용하여 호출부로 예외를 전가한다.
    public void throwsCheckedExceptionMethod() throws Exception {
        throw new Exception();
    }
}
