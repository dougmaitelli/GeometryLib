package Geometry;

import java.util.ArrayList;

/**
 *
 * @author Douglas Maitelli
 */
public final class Polygon {

    private ArrayList<Point> points = new ArrayList<Point>();

    public Polygon() {
    }

    public Polygon(ArrayList<Point> points) {
        this.setPoints(points);
    }

    /**
     * @return the points
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public Point getPoint(Integer i) {
        return points.get(i);
    }

    public void add(Point p) {
        this.getPoints().add(p);
    }

    public Matrix toMatrix() {
        ArrayList<Double[]> m = new ArrayList<Double[]>();

        for (Point p : this.getPoints()) {
            Double[] row = {p.getX(), p.getY()};

            m.add(row);
        }

        return new Matrix(m.toArray(new Double[][]{}));
    }

    public Double getArea() {
        return Math.abs(toMatrix().getDeterminant()) / 2;
    }

    public Double distanceFromPoint(Point p) {
        return distanceBetweenPolygonAndPoint(this, p);
    }

    public Double distanceBetweenPoints(Point p1, Point p2) {
    	Double distance = null;

        for (int i = 0; i < size() * 2 - 1; i++) {
            Point pp1 = getPoint(i >= size() ? i - size() : i);
            Point pp2 = getPoint(i + 1 >= size() ? i + 1 - size() : i + 1);

            Line line = new Line(pp1, pp2);

            if (distance == null && line.hasPoint(p1) && line.hasPoint(p2)) {
                if (pp1.distanceFromPoint(p1) <= pp1.distanceFromPoint(p2)) {
                    distance = p1.distanceFromPoint(p2);

                    break;
                }
            }

            if (distance == null && line.hasPoint(p1)) {
                distance = p1.distanceFromPoint(pp2);

                continue;
            }

            if (distance != null && line.hasPoint(p2)) {
                distance += pp1.distanceFromPoint(p2);

                break;
            }

            if (distance != null) {
                distance += pp1.distanceFromPoint(pp2);
            }
        }

        return distance;
    }

    public Integer size() {
        return points.size();
    }

    public Point getClosestPoint(Point p) {
    	Double distance = Double.MAX_VALUE;

        Point cp = null;

        for (int i = 0; i < size() - 1; i++) {
            Point p1 = getPoint(i);
            Point p2 = getPoint(i + 1);

            LineSegment ls = new LineSegment(p1, p2);

            Double d = ls.distanceFromPoint(p);

            if (d < distance) {
                distance = d;

                cp = ls.getClosestPoint(p);
            }
        }

        return cp;
    }

    public Boolean isPointInside(Point p) {
        Boolean oddNodes = false;

        Double y = p.getY();

        for (int i = 0; i < size(); i++) {  
            Point p1 = getPoint(i);
            Point p2 = getPoint(i + 1 >= size() ? i + 1 - size() : i + 1);

            if ((p1.getY() < y && p2.getY() > y) || (p2.getY() < y && p1.getY() > y)) {
                oddNodes = !oddNodes;
            }
        }

        return oddNodes;
    }

    public Boolean isPointOutside(Point p) {
        return !containsPoint(p);
    }

    public Boolean isPointBelong(Point p) {
        for (int i = 0; i < size(); i++) {
            Point p1 = getPoint(i);
            Point p2 = getPoint(i + 1 >= size() ? i + 1 - size() : i + 1);

            LineSegment ls = new LineSegment(p1, p2);

            if (ls.hasPoint(p)) {
                return true;
            }
        }

        return false;
    }

    public Boolean containsPoint(Point p) {
        return isPointInside(p) || isPointBelong(p);
    }

    public static Double distanceBetweenPolygonAndPoint(Polygon polygon, Point p) {
        return p.distanceFromPoint(polygon.getClosestPoint(p));
    }

}
