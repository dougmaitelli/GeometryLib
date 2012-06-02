package Geometry;

/**
 *
 * @author DougM
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
        return new Point(Math.abs(b.getX() - a.getX()) / 2, Math.abs(b.getY() - a.getY()) / 2);
    }

    public Position getLinePosition(Line s) {
        return getPointPosition(s.getClosestPoint(getCenter()));
    }

    public Boolean isLineInside(Line s) {
        return this.getLinePosition(s) == Position.INSIDE;
    }

    public Boolean isLineOutside(Line s) {
        return this.getLinePosition(s) == Position.OUTSIDE;
    }

    public Boolean isLineBelong(Line s) {
        return this.getLinePosition(s) == Position.BELONG;
    }

    public Boolean hasLine(Line s) {
        return isLineInside(s) || isLineBelong(s);
    }

    public Position getLineSegmentPosition(LineSegment s) {
        return getPointPosition(s.getClosestPoint(getCenter()));
    }

    public Boolean isLineSegmentInside(LineSegment s) {
        return getLineSegmentPosition(s) == Position.INSIDE;
    }

    public Boolean isLineSegmentOutside(LineSegment s) {
        return getLineSegmentPosition(s) == Position.OUTSIDE;
    }

    public Boolean isLineSegmentBelong(LineSegment s) {
        return getLineSegmentPosition(s) == Position.BELONG;
    }

    public Boolean hasLineSegment(LineSegment s) {
        return isLineSegmentInside(s) || isLineSegmentBelong(s);
    }

    public Position getPointPosition(Point p) {
        Position position = null;

        if (p.getX() >  < r) {
            position = Position.INSIDE;
        }

        if (c.distanceFromPoint(p) > r) {
            position = Position.OUTSIDE;
        }

        if (c.distanceFromPoint(p).equals(r)) {
            position = Position.BELONG;
        }

        return position;
    }

    public Boolean isPointInside(Point p) {
        return getPointPosition(p) == Position.INSIDE;
    }

    public Boolean isPointOutside(Point p) {
        return getPointPosition(p) == Position.OUTSIDE;
    }

    public Boolean isPointBelong(Point p) {
        return getPointPosition(p) == Position.BELONG;
    }

    public Boolean hasPoint(Point p) {
        return c.distanceFromPoint(p) <= r;
    }

}
