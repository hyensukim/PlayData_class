package chap04_01adapter;

public class Mkv implements MediaLibrary {

    @Override
    public void playFile(String fileName) {
        System.out.println("Mkv 파일 실행 : "+fileName);
    }
}
