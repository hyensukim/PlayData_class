package chap03_01lsp;

public class LspExampleMain {
    public static void main(String[] args) {
        Client client = new Client();
        Parent parent = new Parent();
        Child child = new Child();

        /*
            Child로 바꾸게 된다면, 클라이언트측에서 음수를 매개변수로 넘겨주던 부분을 양수로 고쳐줘야만 정상 동작하게 되므로,
            결국 양 쪽 모두를 고쳐야만 개선이 가능하다.
         */
        client.someClientMethod(child);
    }
}
