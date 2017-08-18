package geometry;

/**
 *
 * @author Douglas Maitelli
 */
public class Ellipse {

	private Point center;
    private Double radiusX;
    private Double radiusY;
    
    public Ellipse(Point center, Number radiusX, Number radiusY) {
    	this.center = center;
        this.radiusX = radiusX.doubleValue();
        this.radiusY = radiusY.doubleValue();
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
     * @return the radiusX
     */
    public Double getRadiusX() {
        return radiusX;
    }

    /**
     * @param radiusX the radiusX to set
     */
    public void setRadiusX(Number radiusX) {
        this.radiusX = radiusX.doubleValue();
    }
    
    /**
     * @return the radiusY
     */
    public Double getRadiusY() {
        return radiusY;
    }

    /**
     * @param radiusY the radiusY to set
     */
    public void setRadiusY(Number radiusY) {
        this.radiusY = radiusY.doubleValue();
    }
    
    public Double getArea() {
        return Math.PI * radiusX * radiusY;
    }

    public Position getLinePosition(Line s) {
    	return getPointPosition(s.getClosestPoint(center));
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
        Double inequality = Math.pow(p.getX() - center.getX(), 2) / Math.pow(radiusX, 2) + Math.pow(p.getY() - center.getY(), 2) / Math.pow(radiusY, 2);

        if (inequality < 1) {
            return Position.INSIDE;
        } else if (inequality > 1) {
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
        return isPointInside(p) || isPointBelong(p);
    }
	
}
