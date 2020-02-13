
interface media {
    //play must be implemented by classes that implement media
    public void play();
    }
interface sound{
    //same goes for sound
    public void propogateNoise();
}    

//multiple inteferfaces can be implemented
public class music implements media, sound{

    @Override
    public void play(){
        System.out.println("I'm playing music");
    }
    @Override
    public void propogateNoise() {
        System.out.println("I'm vibrating air!");
    }

    public static void main(String[] args) {
        
        music m = new music();
        m.play();
        m.propogateNoise();
    }
}