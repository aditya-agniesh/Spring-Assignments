package com.assignment.SpringFramework.looseCoupling;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JioSavan implements MusicPlayer {
    public void display(){
        System.out.println("JioSavan");
    }
}
