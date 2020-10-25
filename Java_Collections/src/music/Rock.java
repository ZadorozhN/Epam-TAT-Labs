package music;

public class Rock extends Music{
    public Rock(int duration, String name, String band) {
        super(duration, name, band);
    }

    public void play(){
        System.out.println(getBand() + "-" + getName() + " : " + getDuration()/60 + " m. " + getDuration()%60 + " s. " + " (Rock)");
    }
}
