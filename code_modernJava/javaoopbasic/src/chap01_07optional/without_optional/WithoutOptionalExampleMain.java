package chap01_07optional.without_optional;

public class WithoutOptionalExampleMain {
    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        String string = mapRepository.getValue("NOT_EXIST_KEY"); // 존재하지 않는 키값으로 조회
        System.out.println("string = " + string);

        // 얻어온 value 값을 대문자로 바꾸어서 출력
        if(string != null) {
            System.out.println(string.toUpperCase());
        }

    }
    
}
