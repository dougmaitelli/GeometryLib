package Geometry;

/**
 *
 * @author Douglas Maitelli
 */
public final class Circle {

    private Point center;
    private Double radius;

    public Circle(Point center, Number radius) {
        this.center = center;
        this.radius = radius.doubleValue();
    }

    /**
     * @return the center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @param center the center to set
     */
    public void setC(Point center) {
        this.center = center;
    }

    /**
     * @return the radius
     */
    public Double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(Number radius) {
        this.radius = radius.doubleValue();
    }

    public Double getDiameter() {
        return 2 * radius;
    }

    public Double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public Double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public Position getLinePosition(Line s) {
        Double distance = s.distanceFromPoint(center);

        if (distance < radius) {
            return Position.INSIDE;
        } else  if (distance > radius) {
        	return Position.OUTSIDE;
        } else {
        	return Position.BELONG;
        }
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
        return s.distanceFromPoint(center) <= radius;
    }

    public Position getPointPosition(Point p) {
        Double distance = center.distanceFromPoint(p);

        if (distance < radius) {
            return Position.INSIDE;
        } else if (distance > radius) {
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
        return center.distanceFromPoint(p) <= radius;
    }

}
