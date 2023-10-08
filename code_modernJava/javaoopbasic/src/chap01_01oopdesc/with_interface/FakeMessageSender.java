package chap01_01oopdesc.with_interface;

public class FakeMessageSender implements MessageSender{

    @Override
    public void send() {
        System.out.println("FakeMessageSender, 실제로는 메시지를 발송하지 않습니다.");
    }
}
