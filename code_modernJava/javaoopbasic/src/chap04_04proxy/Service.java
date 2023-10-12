package chap04_04proxy;

// 본래 구현체
public class Service implements SomeInterface{
    @Override
    public void someMethod() {
        System.out.println("구현 객체의 someMethod()를 실행함");
    }
}
