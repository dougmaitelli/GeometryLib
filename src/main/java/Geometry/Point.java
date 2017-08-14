package Geometry;


/**
 *
 * @author Douglas Maitelli
 */
public final class Point {

    private Double x;
    private Double y;

    public Point(Number x, Number y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * @return the x
     */
    public Double getX() {
        return this.x;
    }

    /**
     * @param x the x to set
     */
    public void setX(Number x) {
        this.x = x.doubleValue();
    }

    /**
     * @return the y
     */
    public Double getY() {
        return this.y;
    }

    /**
     * @param y the y to set
     */
    public void setY(Number y) {
        this.y = y.doubleValue();
    }

    public Double distanceFromPoint(Point p) {
        return Point.distanceBetweenPoints(this, p);
    }

    public Point middleFromPoint(Point p) {
        return Point.middleBetweenPoints(this, p);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.getX(), this.getY());
    }
    
    public Boolean equals(Point p) {
        return this.getX().equals(p.getX()) && this.getY().equals(p.getY());
    }

    public static Double distanceBetweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    public static Point middleBetweenPoints(Point p1, Point p2) {
        return new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

}
