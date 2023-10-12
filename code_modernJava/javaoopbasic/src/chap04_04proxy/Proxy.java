package chap04_04proxy;

// 대리 구현체
public class Proxy implements SomeInterface{

    // 대리자 객체는 본체의 기능을 호출해주면서 거기에 더해 본인의 실행 메서드를 추가해야 한다.
    private Service service;

    // 대리자 객체 생성 시 본체 타입 Service가 자동으로 주입되도록 생성자 설정
    public Proxy(){
        this.service = new Service();
    }

    @Override
    public void someMethod() {
        //본체 위임 메서드 실행 전
        System.out.println("대리자 객체가 본체 메서드 호출 전에 사전 실행 코드를 수행.");
        //본체로부터 호출 위임(Delegate)
        service.someMethod();
        //본체 위임 메서드 실행 후
        System.out.println("대리자 객체가 본체 메서드 호출 후에 사후 실행 코드를 수행.");
    }
}
