package chap02_03stream.map;

import java.util.ArrayList;
import java.util.List;

public class ForMapExampleMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i < 5; i++){
            list.add(i);
        }

        List<Integer> x10List = new ArrayList<>();

        for(int i =0; i < list.size(); i++){
            x10List.add(list.get(i)*10);
        }
        System.out.println(x10List);
    }
}
