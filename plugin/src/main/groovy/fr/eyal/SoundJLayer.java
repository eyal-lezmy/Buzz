package main.groovy.fr.eyal;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by eyal on 10/11/14.
 */
class SoundJLayer
{
    private String filePath;

    public SoundJLayer(String filePath)
    {
        this.filePath = filePath;
    }

    public void play(){


        try{
            URL url = getClass().getResource("/"+filePath);
            URLConnection urlCon = url.openConnection();
            urlCon.setUseCaches(false);
            InputStream inputStream = urlCon.getInputStream();

            Player playMP3 = new Player(inputStream);
            playMP3.play();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}