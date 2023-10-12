package chap04_02facade;

public class KakaoSender implements MessageSender{
    @Override
    public void send(){
        System.out.println("카카오톡 알림 메시지 발송");
    }
}
