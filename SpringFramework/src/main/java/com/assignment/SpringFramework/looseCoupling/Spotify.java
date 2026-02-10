package com.assignment.SpringFramework.looseCoupling;

import org.springframework.stereotype.Component;

@Component
public class Spotify implements MusicPlayer {
    public void display(){
        System.out.println("Spotify");
    }
}
