package edu.virginia.cs.cs4720.heroesmobile;

/**
 * Basic class to hold server info and calculate distance between the user and a server
 * Created by Matt on 9/21/2015.
 */
public class BlizzardServer {

    private String serverName;
    private String serverCity;
    private double latitude;
    private double longitude;

    public BlizzardServer(String name, String city, double lat, double lon)
    {
        this.serverName = name;
        this.serverCity = city;
        this.latitude = lat;
        this.longitude = lon;
    }

    public String getServerName()
    {
        return this.serverName;
    }

    public String getServerCity() {
        return this.serverCity;
    }

    public double getLatitude()
    {
        return this.latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
    }

    public double calculateDistance(double currentLat, double currentLon)
    {
        double latDist, lonDist;
        latDist = Math.pow(currentLat - this.getLatitude(), 2);
        lonDist = Math.pow(currentLon - this.getLongitude(), 2);
        return Math.sqrt(latDist+lonDist);
    }

}
