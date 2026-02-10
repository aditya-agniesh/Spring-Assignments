package com.assignment.SpringFramework.looseCoupling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Music {

    MusicPlayer musicPlayer;

    @Autowired
    public Music(MusicPlayer musicPlayer){
        this.musicPlayer = musicPlayer;
    }

    public void play(){
        System.out.println("Music played on:");
        musicPlayer.display();
    }
}
