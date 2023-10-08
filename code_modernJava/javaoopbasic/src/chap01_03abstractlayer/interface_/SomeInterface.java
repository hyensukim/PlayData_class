package chap01_03abstractlayer.interface_;

public interface SomeInterface {
    void someMethod();

    default void defaultMethod(){
        //default 키워드를 메서드에 붙이면 인터페이스 내부에서도 구현된 메서드를 가질 수 있다.
        this.someMethod();// 추상 클래스의 예시와 마찬가지로 추후 구현될 메서드를 미리 호출할 것으로 정의하는 것이 가능.
    }
}
