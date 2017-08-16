package Geometry;

/**
 *
 * @author Douglas Maitelli
 */
public class LineSegment extends Line {

    private Point p1;
    private Point p2;

    public LineSegment(Point p1, Point p2) {
        super(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * @return the p1
     */
    public Point getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public Point getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Line toLine() {
        return new Line(p1, p2);
    }

    @Override
    public boolean hasPoint(Point p) {
        Double y = getY(p.getX());

        if (y == null) {
            return false;
        }

        return Math.abs(y - p.getY()) < 0.0000001;
    }

    @Override
    public Double getX(Number y) {
        if (y.doubleValue() < Math.min(p1.getY(), p2.getY()) || y.doubleValue() > Math.max(p1.getY(), p2.getY())) {
            return null;
        }

        return super.getX(y);
    }

    @Override
    public Double getY(Number x) {
        if (x.doubleValue() < Math.min(p1.getX(), p2.getX()) || x.doubleValue() > Math.max(p1.getX(), p2.getX())) {
            return null;
        }

        return super.getY(x);
    }

    @Override
    public Point getPointFromX(Number x) {
        Double y = getY(x);

        if (y == null) {
            return null;
        }

        return new Point(x, y);
    }

    @Override
    public Point getPointFromY(Number y) {
        Double x = getX(y);

        if (x == null) {
            return null;
        }

        return new Point(x, y);
    }
    
    @Override
    public Double distanceFromPoint(Point p) {
        return p.distanceFromPoint(getClosestPoint(p));
    }

    @Override
    public Point getIntersectionPoint(Line ls) {
    	Point p = super.getIntersectionPoint(ls);
    	
        if (p != null && ls.hasPoint(p)) {
            return p;
        }

        return null;
    }

    @Override
    public Point getClosestPoint(Point p) {
        Double min;
        Double max;
        if (isConstant()) {
        	min = Math.min(p1.getX(), p2.getX());
        	max = Math.max(p1.getX(), p2.getX());
        } else {
	        Line l1 = getPerpendicularFromPoint(p1);
	        Line l2 = getPerpendicularFromPoint(p2);
	
	        min = Math.min(l1.getX(p.getY()), l2.getX(p.getY()));
	        max = Math.max(l1.getX(p.getY()), l2.getX(p.getY()));
        }
        
        if (p.getX() < min) {
        	return p1;
        } else if (p.getX() > max) {
        	return p2;
        } else {
        	if (isConstant()) {
        		return new Point(p.getX(), getB());
        	} else {
        		return super.getClosestPoint(p);
        	}
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " from " + p1.toString() + " to " + p2.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
    	LineSegment ls = (LineSegment) obj;
    	
        return super.equals(obj) && p1.equals(ls.getP1()) && p2.equals(ls.getP2());
    }

}
