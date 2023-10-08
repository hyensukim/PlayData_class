package chap01_02inheritence.extends_;

public class Child extends Parent{
    //Parent 자원은 private 요소를 제외한 나머지 모두 가진다.
    //Child 쪽에서 새롭게 정의하는 메서드
    public void anotherMethod(){
        System.out.println("Child anotherMethod()");

        this.parentPublicInt = 0;
        this.parentProtectedInt = 0;
        //private 요소는 상속관계에서도 호출이 불가능하다.(접근 제한)
        //this.parentPrivateInt = 0;
    }
}
