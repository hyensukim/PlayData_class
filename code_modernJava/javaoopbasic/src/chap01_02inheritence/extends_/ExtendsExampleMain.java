package chap01_02inheritence.extends_;

public class ExtendsExampleMain {
    public static void main(String[] args) {
        Parent parent = new Parent(); // 부모 타입 변수 부모 타입 객체 대입
        Parent parentTypeChild = new Child(); // 부모 타입 변수 자식 타입 객체 대입
        Child child = new Child();//자식 타입 변수 자식 타입 객체 대입

        int a;

        parent.someMethod();
        a=10;
        System.out.println("------------");
        parentTypeChild.someMethod();
//        parentTypeChild.anotherMethod(); // Child 타입의 객체 내부 요소는 Parent 타입 변수로 호출이 불가능.
        System.out.println("------------");
        child.someMethod();
        child.anotherMethod();
    }
}
