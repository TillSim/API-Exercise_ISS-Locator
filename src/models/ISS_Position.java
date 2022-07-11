package models;

import helpers.OpenNotifyAPI;
import org.json.JSONObject;

import java.sql.Timestamp;

public class ISS_Position {

    double longitude;
    double latitude;
    String message;
    Timestamp timestamp;


    public ISS_Position() {
        this.longitude = 0;
        this.latitude = 0;
    }

    public ISS_Position(double longitude, double latitude, Timestamp timestamp, String message) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.message = message;
        this.timestamp = timestamp;
    }


    public void updatePosition() {
        JSONObject apiData = new JSONObject(OpenNotifyAPI.fetchData());

        this.longitude = apiData.getJSONObject("iss_position").getDouble("longitude");
        this.latitude = apiData.getJSONObject("iss_position").getDouble("latitude");
        this.message = apiData.getString("message");
        this.timestamp = new Timestamp(apiData.getLong("timestamp")*1000);
    }


    public int getMapLocationX() {
        return (int) (508 + (longitude * (2.54)));
    }

    public int getMapLocationY() {
        return (int) (246 - (latitude * (2.54)));
    }


    public double getLongitude() {return longitude;}

    public double getLatitude() {return latitude;}

    public String getMessage() {return message;}


    @Override
    public String toString() {
        return "Lat:" + this.latitude + "\nLong:" + this.longitude + "\ntime:" + this.timestamp + "\nmessage:" + this.message;
    }

}
