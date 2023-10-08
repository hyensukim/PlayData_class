package chap01_04enum.adv;

import chap01_04enum.adv.CalculateType;
import chap01_04enum.adv.Client;

public class AdvEnumExampleMain {
    public static void main(String[] args) {
        Client client = new Client();
        int result = client.someMethod(CalculateType.ADD,100,20);
        System.out.println(result);
    }
}
