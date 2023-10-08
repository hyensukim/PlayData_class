package chap01_02inheritence.overloading;

public class OverloadingExampleMain {
    public static void main(String[] args) {
        AddCalculator addCalculator = new AddCalculator();

        int intResult = addCalculator.add(10,20);
        long longResult = addCalculator.add(30L,40L);
        double doubleResult = addCalculator.add(50.0,60.0);
        String stringResult = addCalculator.add("70","80");

        System.out.println(intResult);
        System.out.println(longResult);
        System.out.println(doubleResult);
        System.out.println(stringResult);
    }
}
