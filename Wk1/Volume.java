/* This is a peer's code example
*  It needed a few changes to compile 
*  and run as intended
*/

public class Volume{

    public int MIN_VOL = 0;
    public int MAX_VOL = 100 ; 

    static int Volume ;

    volumeUp() {
        main.Volume++;
    }

    VolumeDow(){
        main.Volume--;

    }

    SetVolume( final int Volume){
       main.Volume = Volume;
       if (main.Volume > MAX_VOL){
           main.Volume = MAX_VOL ; 
       }
       if(main.Volume < MIN_VOL){ 
           main.volume = MIN_VOL;
       } 
    }

    public int getVol(){
        return Volume; 
    }
}