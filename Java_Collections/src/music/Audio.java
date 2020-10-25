package music;

public class Audio {
    private int duration;
    private String name;

    public Audio(int duration, String name) {
        this.duration = duration;
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void play(){
        System.out.println("Audio " + name + " is playing now; duration of track is " + duration);
    }
}
