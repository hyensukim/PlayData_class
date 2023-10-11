package chap02_03stream.map;

import java.util.ArrayList;
import java.util.List;

public class MapExampleMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i < 5; i++){
            list.add(i);
        }

        List<Integer> x10List = list.stream().map(integer -> integer*10).toList();
        System.out.println(x10List);
    }
}
