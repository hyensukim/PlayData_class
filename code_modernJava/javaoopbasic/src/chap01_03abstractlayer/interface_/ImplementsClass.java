package chap01_03abstractlayer.interface_;

public class ImplementsClass implements SomeInterface,AnotherInterface{
    // 디폴트 메서드는 완성된 형식으로 구현체에 전달됨.
    @Override
    public void anotherMethod() {
        System.out.println("ImplementsClass anotherMethod()");
    }

    @Override
    public void someMethod() {
        System.out.println("ImplementsClass someMethod()");
    }
}
