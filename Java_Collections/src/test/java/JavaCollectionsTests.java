import container.AudioDisk;
import music.Audio;
import music.Metal;
import music.Rock;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class JavaCollectionsTests {
    @Test
    void addMusicToAudioDiskTest(){
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        assertEquals(audioDisk.getAudio(metalMusic.getName()), metalMusic);
    }

    @Test
    void getDurationAudioDiskTest(){
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        int totalDuration = metalMusic.getDuration() + rockMusic.getDuration() + audio.getDuration();

        assertEquals(audioDisk.totalDuration(), totalDuration);
    }

    @Test
    void numberOfAudiosTest(){
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        assertEquals(audioDisk.numberOfAudios(), 3);
    }

    @Test
    void clearTest(){
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        audioDisk.clear();

        assertEquals(audioDisk.numberOfAudios(), 0);
    }

    @Test
    void shuffleTest(){
        ArrayList<Audio> audios = new ArrayList<>();
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audios.add(metalMusic);
        audios.add(rockMusic);
        audios.add(audio);

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        audioDisk.shuffle();

        assertNotEquals(audioDisk.getAudios(), audios);
    }

    @Test
    void getAudioByDurationTest(){
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        assertEquals(audioDisk.getAudioByDuration(110,130),rockMusic);
    }

    @Test
    void getAudiosTest(){
        ArrayList<Audio> audios = new ArrayList<>();
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audios.add(metalMusic);
        audios.add(rockMusic);
        audios.add(audio);

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        assertEquals(audioDisk.getAudios(), audios);
    }

    @Test
    void genreToStartTest(){
        ArrayList<Audio> audios = new ArrayList<>();
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audios.add(rockMusic);
        audios.add(metalMusic);
        audios.add(audio);

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        audioDisk.musicOfGenreToStart(rockMusic.getClass());

        assertEquals(audioDisk.getAudios(), audios);
    }

    @Test
    void removeTest(){
        AudioDisk audioDisk = new AudioDisk();

        Metal metalMusic = new Metal(400,"Master of puppets", "Metallica");
        Rock rockMusic = new Rock(120,"Big Gun", "AC/DC");
        Audio audio = new Audio(100,"talking to father phone record");

        audioDisk.add(metalMusic);
        audioDisk.add(rockMusic);
        audioDisk.add(audio);

        audioDisk.remove(metalMusic);

        assertEquals(audioDisk.getAudio("Master of puppets"), null);
    }

    @Test
    void getNameTest(){
        String name = "Highway to hell";
        Rock metalMusic = new Rock(400, name, "AC/DC");
        assertEquals(metalMusic.getName(), name);
    }

    @Test
    void getBandTest(){
        String band = "Metallica";
        Metal metalMusic = new Metal(400, "Master of puppets", band);
        assertEquals(metalMusic.getBand(), band);
    }

    @Test
    void getDurationTest(){
        int duration = 400;
        Metal metalMusic = new Metal(duration, "Master of puppets", "Metallica");
        assertEquals(metalMusic.getDuration(), duration);
    }

    @Test
    void setNameTest(){
        String name = "For whom the bell tools";
        Metal metalMusic = new Metal(400, "Master of puppets", "Metallica");
        metalMusic.setName(name);
        assertEquals(metalMusic.getName(), name);
    }

    @Test
    void setDurationTest(){
        int duration = 300;
        Metal metalMusic = new Metal(400, "Master of puppets", "Metallica");
        metalMusic.setDuration(duration);
        assertEquals(metalMusic.getDuration(), duration);
    }

    @Test
    void setBandTest(){
        String band = "Trivium";
        Metal metalMusic = new Metal(400, "Master of puppets", "Metallica");
        metalMusic.setBand(band);
        assertEquals(metalMusic.getBand(), band);
    }
}
