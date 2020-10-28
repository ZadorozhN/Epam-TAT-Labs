package container;

import music.Audio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AudioDisk {

    ArrayList<Audio> audios;

    public AudioDisk(){
        audios = new ArrayList<>();
    }

    public AudioDisk(ArrayList<Audio> audios){
        this.audios = audios;
    }

    public void add(Audio audio){
        audios.add(audio);
    }

    public void clear(){
        audios.clear();
    }

    public void remove(Audio audio){
        audios.remove(audio);
    }

    public Audio getAudioByDuration(int from, int to){
        for(int i = 0; i < audios.size(); i++){
            if(audios.get(i).getDuration() >= from && audios.get(i).getDuration() <= to)
                return audios.get(i);
        }
        return null;
    }

    public void shuffle(){
        Random random = new Random();
        Audio buf;
        int randomNumber;
        for(int i = 0; i < audios.size(); i++){
            randomNumber = Math.abs(random.nextInt()) % audios.size();
            buf = audios.get(i);
            audios.set(i, audios.get(randomNumber));
            audios.set(randomNumber, buf);
        }
    }

    public void musicOfGenreToStart(Class cl){
        int j = 0;
        Audio buf;
        for(int i = 0; i < audios.size(); i++){
            if(audios.get(i).getClass().equals(cl)){
                buf = audios.get(i);
                audios.set(i, audios.get(j));
                audios.set(j, buf);
                j++;
            }
        }
    }

    public int totalDuration(){
        int total = 0;
        for(int i = 0; i < audios.size(); i++ ){
            total += audios.get(i).getDuration();
        }
        return total;
    }

    public void play(){
        for( int i = 0; i < audios.size(); i++){
            audios.get(i).play();
        }
    }

    public Audio getAudio(String name){
        for( int i = 0; i < audios.size(); i++){
            if(audios.get(i).getName() == name)
                return audios.get(i);
        }
        return null;
    }

    public ArrayList<Audio> getAudios(){
        return new ArrayList<>(audios);
    }

    public int numberOfAudios(){
        return audios.size();
    }
}