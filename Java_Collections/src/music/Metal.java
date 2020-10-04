package music;

public class Metal extends Music{

    public Metal(int duration, String name, String band) {
        super(duration, name, band);
    }

    public void play(){
        System.out.println(getBand() + "-" + getName() + " : " + getDuration()/60 + " m. " + getDuration()%60 + " s. " + " (Metal)");
    }
}
