package chap04_01adapter;

public class Mp4 implements MediaLibrary {

    @Override
    public void playFile(String fileName) {
        System.out.println("Mp4 파일 실행 : "+fileName);
    }
}
