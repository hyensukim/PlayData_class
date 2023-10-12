package chap04_02facade;

public class SendMessageFacade {
    private static MessageSender[] senderList = {new KakaoSender(), new EmailSender(), new SmsSender()};
    private static SendMessageRepository sendMsRepo = new SendMessageRepository();

    public void sendSave(){

        for(MessageSender ms : senderList){
            ms.send();
        }
    }
}
