package chap04_02facade;

// 발송된 메시지 내역을 DB에 적재하는 레포지토리 클래스
public class SendMessageRepository {
    public void save(){
        System.out.println("발송된 모든 메시지 내역은 디비에 저장되었습니다.");
    }
}
