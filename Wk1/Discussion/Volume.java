package Wk1.Discussion;

/* This is a peer's code example
*  It needed a few changes to compile 
*  and run as intended. There was also
*  a driver, but thats easy to make
*/

public class Volume{

    public static int MIN_VOL = 0;
    public static int MAX_VOL = 100;

    // rename for clarity
    static int vol;

    // needed access modifier and return type
    // added static so could be used in main class
    public static void volumeUp() {
        vol++;
    }

    public static void volumeDow() {
        vol--;

    }

    public static void SetVolume(int Volume) {
        vol = Volume;
        if (vol > MAX_VOL) {
            vol = MAX_VOL;
        }
        if (vol < MIN_VOL) {
           vol = MIN_VOL;
       } 
    }

    public static int getVol(){
        return vol; 
    }
}