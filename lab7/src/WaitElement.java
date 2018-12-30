package rozetka.elements;

public class WaitElement {

    public static void driverWait(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
