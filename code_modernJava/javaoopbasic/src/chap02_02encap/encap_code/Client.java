package chap02_02encap.encap_code;

public class Client {
    public int someMethod(CalculateCommand calculateCommand){
        /*
            클라이언트는 연산 결과만 요청하면 된다.
            결합도가 낮아졌다. -> 외부 클래스에 대한 호출 구문 갯수가 줄어듦
         */
        int result = calculateCommand.getCalculateResult(); //객체지향적으로 정리된 메서드
        return result;
    }
}
