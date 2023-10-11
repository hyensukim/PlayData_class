package chap02_03stream.foreach;

import java.util.ArrayList;
import java.util.List;

public class ForIterationExampleMain {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for(int i=10; i < 80; i+= 10 ){
            integerList.add(i);
        }

        for(int i = 0; i < integerList.size(); i++){
            System.out.println(integerList.get(i));
            if(integerList.get(i) == 40){
                System.out.println("40 찾았다");
                break;
            }
        }
    }
}
