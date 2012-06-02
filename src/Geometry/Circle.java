package Geometry;


/**
 *
 * @author DougM
 */
public final class Circle {

    private Point c;
    private Double r;

    public Circle(Point c, Number r) {
        this.c = c;
        this.r = r.doubleValue();
    }

    /**
     * @return the c
     */
    public Point getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Point c) {
        this.c = c;
    }

    /**
     * @return the r
     */
    public Double getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Number r) {
        this.r = r.doubleValue();
    }

    public Double getDiameter() {
        return 2 * r;
    }

    public Double getArea() {
        return Math.PI * Math.pow(r, 2);
    }

    public Double getPerimeter() {
        return 2 * Math.PI * r;
    }

    public Rope getRope(Line s) {
        return new Rope(this, s);
    }

    public Position getLinePosition(Line s) {
        Position position = null;

        Double distance = s.distanceFromPoint(c);

        if (distance < r) {
            position = Position.INSIDE;
        }

        if (distance > r) {
            position = Position.OUTSIDE;
        }

        if (distance.equals(r)) {
            position = Position.BELONG;
        }

        return position;
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
        return s.distanceFromPoint(c) <= r;
    }

    public Position getLineSegmentPosition(LineSegment s) {
        Position position = null;

        Double distance = s.distanceFromPoint(c);

        if (distance < r) {
            position = Position.INSIDE;
        }

        if (distance > r) {
            position = Position.OUTSIDE;
        }

        if (distance.equals(r)) {
            position = Position.BELONG;
        }

        return position;
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
        return s.distanceFromPoint(c) <= r;
    }

    public Position getPointPosition(Point p) {
        Position position = null;

        if (c.distanceFromPoint(p) < r) {
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
