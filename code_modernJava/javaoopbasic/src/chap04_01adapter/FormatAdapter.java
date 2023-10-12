package chap04_01adapter;

// MediaPackage 인터페이스 mediaPlayer 자료형인것처럼 동작하도록 만들어주는 어댑터 클래스
public class FormatAdapter implements MediaPlayer {
    private MediaLibrary media;

    public FormatAdapter(MediaLibrary media){
        this.media = media;
    }

    @Override
    public void play(String fileName) {
        System.out.println("어댑터를 사용해서 library를 player처럼 변환");
        media.playFile(fileName);
    }
}
