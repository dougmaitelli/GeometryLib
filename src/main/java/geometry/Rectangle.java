package geometry;

/**
 *
 * @author Douglas Maitelli
 */
public class Rectangle {

    private Point a;
    private Point b;

    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    /**
     * @return the a
     */
    public Point getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Point a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public Point getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Point b) {
        this.b = b;
    }

    public Point getCenter() {
        return new Point(a.getX() + Math.abs(b.getX() - a.getX()) / 2, a.getY() + Math.abs(b.getY() - a.getY()) / 2);
    }

    public Double getArea() {
        return (b.getX() - a.getX()) * (b.getY() - a.getY());
    }

    public Position getLinePosition(Line s) {
        return getPointPosition(s.getClosestPoint(getCenter()));
    }

    public boolean isLineInside(Line s) {
        return this.getLinePosition(s) == Position.INSIDE;
    }

    public boolean isLineOutside(Line s) {
        return this.getLinePosition(s) == Position.OUTSIDE;
    }

    public boolean isLineBelong(Line s) {
        return this.getLinePosition(s) == Position.BELONG;
    }

    public boolean hasLine(Line s) {
        return isLineInside(s) || isLineBelong(s);
    }

    public Position getPointPosition(Point p) {
        if (p.getX() > a.getX() && p.getY() > a.getY() && p.getX() < b.getX() && p.getY() < b.getY()) {
            return Position.INSIDE;
        } else if (p.getX() < a.getX() || p.getY() < a.getY() || p.getX() > b.getX() || p.getY() > b.getY()) {
            return Position.OUTSIDE;
        } else {
            return Position.BELONG;
        }
    }

    public boolean isPointInside(Point p) {
        return getPointPosition(p) == Position.INSIDE;
    }

    public boolean isPointOutside(Point p) {
        return getPointPosition(p) == Position.OUTSIDE;
    }

    public boolean isPointBelong(Point p) {
        return getPointPosition(p) == Position.BELONG;
    }

    public boolean hasPoint(Point p) {
        return isPointOutside(p) || isPointBelong(p);
    }

}
