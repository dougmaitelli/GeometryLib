package geography;

/**
 * Planet enum
 * 
 * @author Douglas Maitelli
 */
public enum Planet {
    MERCURY(2440000.0),
    VENUS(6051000.0),
    EARTH(6371007.2),
    MOON(1738000.0),
    MARS(3397000.0),
    JUPITER(71492000.0),
    SATURN(60268000.0),
    URANUS(25559000.0),
    NEPTUNE(24764000.0),
    PLUTO(1160000.0);

    /**
     * Planet radius
     */
    private Double radius;

    /**
     * Creates a new Planet from the radius
     * 
     * @param radius
     */
    Planet(Double radius) {
        this.radius = radius;
    }

    /**
     * Gets the Planet radius
     * 
     * @return Double
     */
    public Double getRadius() {
        return radius;
    }

    public Double getDiameter() {
        return radius * 2;
    }
}
