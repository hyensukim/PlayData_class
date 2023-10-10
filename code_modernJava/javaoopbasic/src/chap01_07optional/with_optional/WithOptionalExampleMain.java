package chap01_07optional.with_optional;

public class WithOptionalExampleMain {
    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();

        String string = mapRepository.getOptionalValue("NOT_EXIST_KEY")
                .orElseThrow(()->{throw new RuntimeException("없는 키입니다");});
        /*
            해당 키로 조회한 결과가 nul인데 옵셔널 반환을 받은 경우 예외가 발생함.
            내부에 람다식으로 () -> {throw new 발생할예외("메시지")}
            위와 같이 작성해 주시면 예외를 발생시킵니다.
         */
        System.out.println(string.toUpperCase());
    }
}
