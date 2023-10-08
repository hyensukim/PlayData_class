package chap01_03abstractlayer.interface_;

public class InterfaceExampleMain {
    public static void main(String[] args) {
        SomeInterface someInterface = new ImplementsClass();
        AnotherInterface anotherInterface = new ImplementsClass();

        someInterface.defaultMethod();
        someInterface.someMethod();
        anotherInterface.anotherMethod();

        /* 양쪽 모두를 호출 하는건 불가능함.
        someInterface.anotherMethod();
        anotherInterface.someMethod();
        anotherInterface.defaultMethod();
        */

        ImplementsClass implementsClass = new ImplementsClass();

        // ImplementsClass 구현체 타입으로 양쪽 모두 호출하는 것은 가능
        implementsClass.someMethod();
        implementsClass.anotherMethod();
        implementsClass.defaultMethod();
    }
}
