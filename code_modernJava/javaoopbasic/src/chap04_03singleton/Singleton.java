package chap04_03singleton;

public class Singleton {
    /*
        1. 싱글톤 클래스는 자기 자신 타입을 멤버변수로 가지게 한다.
        static을 설정해서 공용변수로 만들어야 여러 경우에 참조(메모리 상의 참조 주소) 를 받아갈 수 있다.
     */
    private static Singleton instance;

    /*
        2. 생성자를 private으로 제한하여 외부에서 인스턴스를 새로히 생성하는 것을 막는다.
        이러면 아래와 같이 자기 클래스 내부에서만 생성자 호출이 가능하다.
     */
    private Singleton(){
        System.out.println("하나의 객체 생성 완료!");
    }

    /*
        3. getInstanc()와 같이, 이미 생성된 instance 멤버변수를 반환해주는 메서드 추가
        static으로 선언하여 객체가 생성되어 있지 않아도 호출이 가능하도록 함.
        이 때, instance가 생성된 적이 없다면, 생성자를 호출해서 instance에 대입해주는 로직을 추가함.
     */
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
