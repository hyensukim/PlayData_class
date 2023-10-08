package chap01_01oopdesc.with_interface;

public class RealMessageSender implements MessageSender{
    @Override
    public void send() {
        System.out.println("RealMessageSender, 실제로 고객에게 메시지를 전송.");
    }
}
