package chap04_01adapter;

public class AdapterExampleMain {
    public static void main(String[] args) {
        MediaPlayer player = new Mp3();
        player.play("NewJeans-SuperShy.mp3");

        player = new FormatAdapter(new Mp4());
        player.play("Le SSERAFIM-이프푸.mp4");

        player = new FormatAdapter(new Mkv());
        player.play("충주시홍보맨-ETA.mkv");
    }
}
