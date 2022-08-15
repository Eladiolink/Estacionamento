package src.Helper;

public class TimerSleep {
    public static void Sleep(int second){
        try { Thread.sleep (second*1000); } catch (InterruptedException ex) {}
    }
}
