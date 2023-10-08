package chap01_01oopdesc.with_interface;

public interface MessageSender {
    // 인터페이스는 특정 객체가 가져야하는 기능의 명세를 작성함.
    // 인터페이스 내부에 작성한 메서드는 구현체가 반드시 구현해야 하는 메서드로 정의됨.

    void send();// MessageSender 라면 무조건 발송기능을 가지도록 설계(추상화).
}
