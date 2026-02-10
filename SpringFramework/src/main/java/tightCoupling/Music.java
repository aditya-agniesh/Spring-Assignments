package tightCoupling;

public class Music {
    public void Play(){
//        Spotify spotify =new Spotify();
     JioSavan jioSavan=new JioSavan();

        // this is the example of hard coupling code
        // we are depend on concreate class
        System.out.println("Music Played on: ");
//        spotify.display();
      jioSavan.display();
    }
}
