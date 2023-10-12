package chap04_04proxy;

public class ProxyExampleMain {
    public static void main(String[] args) {
        SomeInterface someInterface = new Proxy();
        Client client = new Client(someInterface);
        client.someClientMethod();
    }
}
