package chap04_02facade;

public class Client {
    // 늘어날수록 클라이언트 쪽 코드를 수정하여 객체를 추가해줘야 한다.
    private static MessageSender[] senderList = {new KakaoSender(), new EmailSender(), new SmsSender()};
    private static SendMessageRepository sendMsRepo = new SendMessageRepository();
    public void someMethod(){
        //복잡한 호출 로직은 모두 클라이언트 측에서 생략하고 파사드 클래스 하나만 생성
        SendMessageFacade sendMessageFacade = new SendMessageFacade();
        sendMessageFacade.sendSave();
    }
}


/*
        //매체별로 순차적으로 메시지 발송
        for(MessageSender ms : senderList){
            ms.send();
        }

        senderList[0].send();
        senderList[1].send();
        senderList[2].send();
        sendMsRepo.save();


 */