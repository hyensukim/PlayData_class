package chap02_03stream.filter_;

import java.util.ArrayList;
import java.util.List;

public class FilterExampleMain {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for(int i = 10; i < 80; i+=10){
            integerList.add(i);
        }

        Integer findNumber = integerList.stream().filter(integer ->{
            System.out.println(integer);

            if(integer.equals(40)){
                return true;
            }
            return false;
        }).findAny().get(); // findAny() : 전체 데이터를 Optional 에 담아서 반환
        
        System.out.println("findNumber : "+findNumber);
    }
}
