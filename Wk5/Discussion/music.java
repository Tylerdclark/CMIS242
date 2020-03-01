package wk5.discussion;

interface media {
    //play must be implemented by classes that implement media
    public void play();
    }
interface sound{
    //same goes for sound
    public void propagateNoise();
}    

//multiple interfaces can be implemented
public class music implements media, sound{

    @Override
    public void play(){
        System.out.println("I'm playing music");
    }
    @Override
    public void propagateNoise() {
        System.out.println("I'm vibrating air!");
    }

    public static void main(String[] args) {
        
        music m = new music();
        m.play();
        m.propagateNoise();
    }
}