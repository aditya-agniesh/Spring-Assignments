package looseCoupling;

public class Music {

    MusicPlayer musicPlayer;

    Music(MusicPlayer musicPlayer){
        this.musicPlayer = musicPlayer;
    }

    public void play(){
        System.out.println("Music played on: ");
        musicPlayer.display();
    }
}
