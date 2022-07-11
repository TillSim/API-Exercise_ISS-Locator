package views;

import javax.swing.*;
import java.awt.*;

public class MapLabel extends JComponent {

    private static final ImageIcon MAP_ICON = new ImageIcon("./img/map.png");
    private final LocationIndicator indicator;
    public MainFrame parentFrame;


    public MapLabel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;

        super.setBounds(0,0,parentFrame.getWidth(),parentFrame.getHeight());

        this.indicator = new LocationIndicator(this);
        super.add(indicator);
    }


    public LocationIndicator getIndicator() {
        return indicator;
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        MAP_ICON.paintIcon(this, graphics,0, 0);
    }

}
