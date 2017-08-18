package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas Maitelli
 */
public class Polygon extends Polyline {

    public Polygon() {
    }

    public Polygon(ArrayList<Point> points) {
        super(points);
    }

    public Matrix toMatrix() {
        ArrayList<Double[]> m = new ArrayList<Double[]>();

        for (Point p : this.getPoints()) {
            Double[] row = {p.getX(), p.getY()};

            m.add(row);
        }

        return new Matrix(m.toArray(new Double[][]{}));
    }

    public double getArea() {
        return Math.abs(toMatrix().getDeterminant()) / 2;
    }

    @Override
    public List<LineSegment> getLineSegments() {
        List<LineSegment> lines = super.getLineSegments();
        lines.add(new LineSegment(getPoint(size() - 1), getPoint(0)));

        return lines;
    }

    public double distanceFromPoint(Point p) {
        return p.distanceFromPoint(getClosestPoint(p));
    }

    public boolean isPointInside(Point p) {
        Boolean oddNodes = false;

        Double y = p.getY();

        for (LineSegment ls : getLineSegments()) {
            Point p1 = ls.getP1();
            Point p2 = ls.getP2();

            if ((p1.getY() < y && p2.getY() > y) || (p2.getY() < y && p1.getY() > y)) {
                oddNodes = !oddNodes;
            }
        }

        return oddNodes;
    }

    public boolean isPointOutside(Point p) {
        return !containsPoint(p);
    }

    public boolean isPointBelong(Point p) {
        for (LineSegment ls : getLineSegments()) {
            if (ls.hasPoint(p)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsPoint(Point p) {
        return isPointInside(p) || isPointBelong(p);
    }

}
