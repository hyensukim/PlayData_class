package chap03_01lsp;

public class Child extends Parent{
    @Override
    public void someMethod(int input) {
        if(input <=0){
            throw new RuntimeException("양수만 받을 수 있다.");
        }
        System.out.println("Child 정상적으로 호출됨");
    }
}
