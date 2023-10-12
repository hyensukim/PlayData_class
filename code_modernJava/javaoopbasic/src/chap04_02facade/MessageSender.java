package chap04_02facade;

// 알림 메시지를 발송하는 모든 매체는 이 클래스를 구현해야 한다.
public interface MessageSender {
    public void send();
}
