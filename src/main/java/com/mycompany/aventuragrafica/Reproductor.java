/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aventuragrafica;

import jaco.mp3.player.MP3Player;
import java.io.File;

/**
 *
 * @author ayoub
 */
public class Reproductor {
    
    private static MP3Player player;

    public static void reproducir(String rutaMp3) {
        if (player != null && !player.isStopped()) {
            player.stop();
        }
        player = new MP3Player(new File(rutaMp3));
        player.play();
    }

    public static void parar() {
        if (player != null && !player.isStopped()) {
            player.stop();
        }
    }
}
