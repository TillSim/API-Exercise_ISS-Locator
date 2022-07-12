import views.MainFrame;


public class Main {

    private static final MainFrame MAIN_FRAME = new MainFrame();
    private static final int TICK_RATE = 5000;


    public static void main(String[] args) {
        while (MAIN_FRAME.isRunning()) {
            MAIN_FRAME.updateIndicator();
            try {Thread.sleep(TICK_RATE);
            } catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }

}
