package chap01_01oopdesc.without_interface;

public class Client {
    public void someMethod(){
        // 메시지 보내기 전에 사전 서버 연결 등
        // 코드...

        //사전 작업 후 메시지 밠ㅇ 코드
        FakeMessageSender messageSender = new FakeMessageSender();
        messageSender.send();
    }
}
