package geography;

import geometry.Point;

/**
 * LatLng class
 * @author Douglas Maitelli
 */
public final class LatLng {

    /**
     * The latitude
     */
    private Double latitude;
    /**
     * The longitude
     */
    private Double longitude;

    /**
     * Creates a LatLng object from the given latitude and longitude
     * @param latitude
     * @param longitude
     */
    public LatLng(Number latitude, Number longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
    }

    /**
     * Gets the latitude
     * @return The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude
     * @param latitude The latitude to set
     */
    public void setLatitude(Number latitude) {
        this.latitude = latitude.doubleValue();
    }

    /**
     * Gets the longitude
     * @return The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude
     * @param longitude The longitude to set
     */
    public void setLongitude(Number longitude) {
        this.longitude = longitude.doubleValue();
    }

    /**
     * Converts the LatLng to Point in Planet EARTH
     * @return Point
     */
    public Point toPoint() {
        return toPoint(Planet.EARTH);
    }

    /**
     * Converts the LatLng to Point in Planet specified
     * @param planet Planet to use for conversion
     * @return Point
     */
    public Point toPoint(Planet planet) {
        double v = Math.PI * planet.getRadius() / 180;

        double x = v * longitude;
        double y = v * latitude;

        return new Point(x, y);
    }

    /**
     * Converts the LatLng to String
     * @return String
     */
    @Override
    public String toString() {
        return String.format("(%.5f, %.5f)", getLatitude(), getLongitude());
    }

    /**
     * Compares two LatLng
     * @param p LatLng to compare
     * @return boolean
     */
    public boolean equals(LatLng p) {
        return getLatitude().equals(p.getLatitude()) && getLongitude().equals(p.getLongitude());
    }

    /**
     * Return distance between two given LatLng in Planet EARTH
     * @param p1 LatLng 1
     * @param p2 LatLng 2
     * @return Double
     */
    public static Double distanceBetweenPoints(LatLng p1, LatLng p2) {
        return LatLng.distanceBetweenPoints(p1, p2, Planet.EARTH);
    }

    /**
     * Return distance between two given LatLng in Planet specified
     * @param p1 LatLng 1
     * @param p2 LatLng 2
     * @param planet Planet to use for conversion
     * @return Double
     */
    public static Double distanceBetweenPoints(LatLng p1, LatLng p2, Planet planet) {
        double dLat = (p2.getLatitude() - p1.getLatitude()) * Math.PI / 180;
        double dLon = (p2.getLongitude() - p1.getLongitude()) * Math.PI / 180;

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(p1.getLatitude() * Math.PI / 180) * Math.cos(p2.getLatitude() * Math.PI / 180) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return planet.getRadius() * c;
    }

    /**
     * Return LatLng for the given Point in Planet EARTH
     * @param p Point for convert to LatLng
     * @return LatLng
     */
    public static LatLng fromPoint(Point p) {
        return LatLng.fromPoint(p, Planet.EARTH);
    }

    /**
     * Return LatLng for the given Point in Planet specified
     * @param p Point for convert to LatLng
     * @param planet Planet to use for conversion
     * @return LatLng
     */
    public static LatLng fromPoint(Point p, Planet planet) {
        double v = Math.PI * planet.getRadius() / 180;

        double lat = p.getY() / v;
        double lng = p.getX() / v;

        return new LatLng(lat, lng);
    }
}
