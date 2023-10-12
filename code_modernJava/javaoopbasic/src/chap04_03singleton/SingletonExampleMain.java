package chap04_03singleton;

public class SingletonExampleMain {
    public static void main(String[] args) {
//        Singleton s0 = new Singleton(); // 생성자 메서드 외부에서 호출 불가능.

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println("s1 reference address" + s1);
        System.out.println("s2 reference address" + s2);
        System.out.println("s3 reference address" + s3);
    }
}
