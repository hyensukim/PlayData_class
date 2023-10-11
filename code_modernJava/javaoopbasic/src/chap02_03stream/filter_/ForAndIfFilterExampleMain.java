package chap02_03stream.filter_;

import java.util.ArrayList;
import java.util.List;

public class ForAndIfFilterExampleMain {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for(int i = 10; i < 80; i+=10){
            integerList.add(i);
        }
        Integer findNumber = null;

        for(int i=0; i < integerList.size(); i++){
            System.out.println(integerList.get(i));
            if(integerList.get(i).equals(40)){
                findNumber = integerList.get(i);
                break;
            }
        }
        System.out.println("findNumber : " + findNumber);
    }
}
