package chap04_04proxy;

public class ProxyExampleMain {
    public static void main(String[] args) {
        SomeInterface someInterface = new Service();
        Client client = new Client(someInterface);
        client.someClientMethod();

        System.out.println();

        someInterface = new Proxy();
        client = new Client(someInterface);
        client.someClientMethod();
    }
}
