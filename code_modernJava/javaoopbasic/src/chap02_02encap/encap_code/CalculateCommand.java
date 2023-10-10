package chap02_02encap.encap_code;

public class CalculateCommand {
    private CalculateType calculateType; // 이 필드에는 ADD, MINUS, MULTIPLY, DIVIDE 넷 중 하나만 대입 가능
    private int num1; // 이 필드에는 정수이기만 하면 숫자가 몇이건 범위 내에서 다 대입 가능
    private int num2;

    /*
        CalculateCommand 객체에 실제적인 연산에 필요한 모든 자료가 저자외므로
        연산에 필요한 정보를 생성하는 단계에서 검사까지 해버리면 된다.

        생성자 주입 후 필드 값을 수정하지 않기 위해 setter를 정의하지 않는다.
     */
    public CalculateCommand(CalculateType calculateType, int num1, int num2) {
        // 생성단계에서 검증에 실패한 경우, unchecked exception을 사용하는 것이 더 좋음.
        /* 클라이언트 사이드에서 if문을 최소로 해준다. - S*/
        if(calculateType == null) throw new RuntimeException("CalculateType은 필수 값이다.");
        if(calculateType == CalculateType.DIVIDE && num2 == 0) throw new RuntimeException("0으로 나눌 수 없다.");
        /* 클라이언트 사이드에서 if문을 최소로 해준다. - E*/
        this.calculateType = calculateType;
        this.num1 = num1;
        this.num2 = num2;
    }

    /*
        코드의 응집도가 올라가게 된다.
        기존 getter 들을 모두 노출 시킬 필요가 없기 때문에 아래와 같이 정의
        그러나 어쨋든 연산 결과를 반환 해줘야 하기 때문에
    */
    public int getCalculateResult(){
        CalculateType calculateType = this.calculateType;
        int num1 = this.num1;
        int num2 = this.num2;

        //생성자에서 이미 유효성 검사가 완료 되었고, setter 가 없기 때문에 값이 변하지 않는 다는 것까지 보장 되므로 바로 연산 해준다.
        int result = calculateType.calculate(num1,num2);
        return result;
    }
}