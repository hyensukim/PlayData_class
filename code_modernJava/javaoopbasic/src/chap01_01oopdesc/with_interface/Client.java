package chap01_01oopdesc.with_interface;

public class Client {
    public void someMethod(){
        // 메시지 보내기 전에 사전 서버 연결 등
        // 코드...

        //사전 작업 후 메시지 밠ㅇ 코드
        //인터페이스를 구현한 구현 객체는 모두 MessageSender 타입 변수에 담을 수 있다.(다형성)
        MessageSender messageSender = new FakeMessageSender();
        messageSender.send();
    }
}
