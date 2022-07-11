package views;


import javax.swing.*;


public class MainFrame extends JFrame {

    private final MapLabel mapLabel;
    private static final ImageIcon LOGO = new ImageIcon("./img/iss.png");

    private boolean running = true;


    public MainFrame() {

        super.setTitle("ISS-Locator");
        super.setIconImage(LOGO.getImage());

        super.setSize(1038,515);
        super.setResizable(false);

        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mapLabel = new MapLabel(this);
        super.add(mapLabel);

        super.setVisible(true);

    }


    public void updateIndicator() {
        this.mapLabel.getIndicator().repaint();
    }


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }


    @Override
    public void setTitle(String text) {
        super.setTitle("ISS-Locator  |  " + text);
    }

}
