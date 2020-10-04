package music;

public abstract class Music extends Audio {
    private String band;

    public Music(int duration, String name, String band){
        super(duration, name);
        this.band = band;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public abstract void play();
}
