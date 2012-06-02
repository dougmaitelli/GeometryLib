package Geometry;


/**
 *
 * @author DougM
 */
public final class Line {

    private Double a;
    private Double b;

    public Line() {
    }

    public Line(Number a, Number b) {
        this.a = a.doubleValue();
        this.b = b.doubleValue();
    }

    public Line(Number a, Point p) {
        fromPoint(a, p);
    }

    public Line(Point p1, Point p2) {
        fromPoints(p1, p2);
    }

    /**
     * @return the a
     */
    public Double getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Number a) {
        this.a = a.doubleValue();
    }

    /**
     * @return the b
     */
    public Double getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Number b) {
        this.b = b.doubleValue();
    }

    public void fromPoint(Number a, Point p) {
        Line s = lineFromPoint(a, p);
        
        this.a = s.getA();
        b = s.getB();
    }

    public void fromPoints(Point p1, Point p2) {
        Line s = lineFromPoints(p1, p2);

        a = s.getA();
        b = s.getB();
    }

    public Boolean hasPoint(Point p) {
        return getY(p.getX()).equals(p.getY());
    }

    public Double getX(Number y) {
        return (y.doubleValue() - b) / a;
    }

    public Double getY(Number x) {
        return a * x.doubleValue() + b;
    }

    public Point getPointFromX(Number x) {
        return new Point(x, this.getY(x));
    }

    public Point getPointFromY(Number y) {
        return new Point(this.getX(y), y);
    }

    public Double getInverseAngularCoeficient() {
        return Math.pow(a, -1) * -1;
    }

    public Boolean isAscendant() {
        return a > 0;
    }

    public Boolean isDescendant() {
        return a < 0;
    }

    public Boolean isConstant() {
        return a == 0;
    }

    public Line getParallelFromPoint(Point p) {
        return new Line(a, p);
    }

    public Boolean isParallel(Line s) {
        return a.equals(s.getA());
    }

    public Line getPerpendicularFromPoint(Point p) {
        return new Line(getInverseAngularCoeficient(), p);
    }

    public Boolean isPerpendicular(Line s) {
        return getInverseAngularCoeficient().equals(s.getA());
    }

    public Boolean isConcurrent(Line s) {
        return !this.isParallel(s) && !this.isPerpendicular(s);
    }

    public Double distanceFromPoint(Point p) {
        return Line.distanceBetweenLineAndPoint(this, p);
    }

    @Override
    public String toString() {
        String aStr = a != 0 ? a + "x" : "";
        String bStr = b != 0 ? (b < 0 ? (Double)(b * -1) : b).toString() : "";

        String eqStr;
        eqStr = !aStr.isEmpty() && !bStr.isEmpty() ? aStr + (b > 0 ? " + " : " - ") + bStr : aStr + bStr;
        eqStr = eqStr.equals("") ? "0" : eqStr;
        return "f(x) = " + eqStr;
    }

    public Boolean equals(Line s) {
        return a.equals(s.getA()) && b.equals(s.getB());
    }

    public Point getIntersectionPoint(Line line) {
        return Line.intersectionPointBetweenLines(this, line);
    }

    public Point getClosestPoint(Point p) {
        return Line.closestPointOnLine(this, p);
    }

    public static Double distanceBetweenLines(Line s1, Line s2) {
        return Line.distanceBetweenLineAndPoint(s1, s2.getPointFromX(0)); //TODO
    }

    public static Double distanceBetweenLineAndPoint(Line s, Point p) {
        return (s.getA() * p.getX() + p.getY() * -1 + s.getB()) / Math.sqrt(Math.pow(s.getA(), 2) + 1);
    }

    public static Point intersectionPointBetweenLines(Line l1, Line l2) {
        if (l1.isParallel(l2)) {
            return null;
        }

        Double x = (l2.getB() - l1.getB()) / (l1.getA() - l2.getA());

        return l1.getPointFromX(x);
    }

    public static Point closestPointOnLine(Line s, Point p) {
        return s.getIntersectionPoint(s.getParallelFromPoint(p));
    }

    public static Line lineFromPoint(Number a, Point p) {
        Line s = new Line();

        s.setA(a);
        s.setB(a.doubleValue() * (p.getX() * -1) + p.getY());

        return s;
    }

    public static Line lineFromPoints(Point p1, Point p2) {
        Double a = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        return Line.lineFromPoint(a, p2);
    }

}
