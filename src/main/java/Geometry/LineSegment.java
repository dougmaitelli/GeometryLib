package Geometry;

/**
 *
 * @author dougmaitelli
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

    public Boolean hasPoint(Point p) {
        Double y = getY(p.getX());

        if (y == null) {
            return null;
        }

        return y.equals(p.getY());
    }

    public Double getX(Number y) {
        if (y.doubleValue() < Math.min(p1.getY(), p2.getY()) || y.doubleValue() > Math.max(p1.getY(), p2.getY())) {
            return null;
        }

        return toLine().getX(y);
    }

    public Double getY(Number x) {
        if (x.doubleValue() < Math.min(p1.getX(), p2.getX()) || x.doubleValue() > Math.max(p1.getX(), p2.getX())) {
            return null;
        }

        return toLine().getY(x);
    }

    public Point getPointFromX(Number x) {
        Double y = getY(x);

        if (y == null) {
            return null;
        }

        return new Point(x, y);
    }

    public Point getPointFromY(Number y) {
        Double x = getX(y);

        if (x == null) {
            return null;
        }

        return new Point(x, y);
    }

    public Double getInverseAngularCoeficient() {
        return toLine().getInverseAngularCoeficient();
    }

    public Boolean isAscendant() {
        return toLine().isAscendant();
    }

    public Boolean isDescendant() {
        return toLine().isDescendant();
    }

    public Boolean isConstant() {
        return toLine().isConstant();
    }

    public Boolean isParallel(LineSegment ls) {
        return toLine().isParallel(ls.toLine());
    }

    public Boolean isPerpendicular(LineSegment ls) {
        return toLine().isPerpendicular(ls.toLine());
    }

    public Boolean isConcurrent(LineSegment ls) {
        return toLine().isConcurrent(ls.toLine());
    }

    public Point intersectionPoint(LineSegment ls) {
        return LineSegment.intersectionPointBetweenLineSegments(this, ls);
    }

    public Double distanceFromPoint(Point p) {
        return LineSegment.distanceBetweenLineSegmentAndPoint(this, p);
    }

    public Point getClosestPoint(Point p) {
        return LineSegment.closestPointOnLineSegment(this, p);
    }

    public static Double distanceBetweenLineSegmentAndPoint(LineSegment ls, Point p) {
        return p.distanceFromPoint(ls.getClosestPoint(p));
    }

    public static Point closestPointOnLineSegment(LineSegment ls, Point p) {
        Line line = new Line(ls.getP1(), ls.getP2());

        Line l1 = line.getPerpendicularFromPoint(ls.getP1());
        Line l2 = line.getPerpendicularFromPoint(ls.getP2());

        Double max = Math.max(l1.getY(p.getX()), l2.getY(p.getX()));
        Double min = Math.min(l1.getY(p.getX()), l2.getY(p.getX()));

        Point cp;

        if (p.getY() >= min && p.getY() <= max) {
            cp = line.getIntersectionPoint(line.getParallelFromPoint(p));
        } else {
            if (p.distanceFromPoint(ls.getP1()) <= p.distanceFromPoint(ls.p2)) {
                cp = ls.getP1();
            } else {
                cp = ls.getP2();
            }
        }

        return cp;
    }

    public static Point intersectionPointBetweenLineSegments(LineSegment l1, LineSegment l2) {
        if (l1.isParallel(l2)) {
            return null;
        }

        Point p = l1.toLine().getIntersectionPoint(l2.toLine());

        if (l1.hasPoint(p)) {
            return p;
        }

        return null;
    }
}
