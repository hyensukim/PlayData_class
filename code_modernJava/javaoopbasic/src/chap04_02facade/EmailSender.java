package chap04_02facade;

public class EmailSender implements MessageSender{
    @Override
    public void send(){
        System.out.println("이메일 발송");
    }
}
