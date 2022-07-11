package views;

import models.ISS_Position;

import javax.swing.*;
import java.awt.*;

public class LocationIndicator extends JComponent {

    private ISS_Position position;
    private MapLabel mapLabel;
    private boolean firstPainting = true;


    public LocationIndicator(MapLabel mapLabel) {
        this.mapLabel = mapLabel;
        this.position = new ISS_Position();
        super.setBounds(0,0, mapLabel.getWidth(), mapLabel.getHeight());
    }


    /**
     * updates MainFrame title coordinates
     */
    private void updateTitle() {
        String longitude, latitude;

        if (this.position.getLongitude() > 0) {
            longitude = this.position.getLongitude() + "° EAST";
        } else {
            longitude = -this.position.getLongitude() + "° WEST";
        }

        if (this.position.getLatitude() > 0) {
            latitude = this.position.getLatitude() + "° NORTH";
        } else {
            latitude = -this.position.getLatitude() + "° SOUTH";
        }

        mapLabel.parentFrame.setTitle(longitude + "  " + latitude);
    }


    @Override
    public void paintComponent(Graphics graphics) {
        this.position.updatePosition();

        if (position.getMessage().equals("success")) {
            updateTitle();
            graphics.setColor(Color.RED);
            graphics.fillOval(position.getMapLocationX(), position.getMapLocationY(), 10, 10);
        } else if (!firstPainting) {
            mapLabel.parentFrame.setRunning(false);
            JOptionPane.showMessageDialog(null, "Error: unable to fetch position data");
            System.exit(0);
        }
        firstPainting = false;
    }

}
