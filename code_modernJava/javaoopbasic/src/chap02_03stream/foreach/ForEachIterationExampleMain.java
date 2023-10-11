package chap02_03stream.foreach;

import java.util.ArrayList;
import java.util.List;

public class ForEachIterationExampleMain {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        
        for(int i = 10; i < 80; i+=10){
            integerList.add(i);
        }
        
        /*
            익명함수를 내부에서 받는 반복문
            integer 변수는 매 바퀴마다 10,20,30 번갈아 가면서 대입됨
         */
        integerList.stream().forEach(integer->{
            System.out.println(integer);
        });
    }
}
