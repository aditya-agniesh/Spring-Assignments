package looseCoupling;

public class Main {
    public static void main(String[] args) {

        Music music1 = new Music(new Spotify());
        music1.play();

        Music music2 = new Music(new JioSavan());
        music2.play();
    }
}
