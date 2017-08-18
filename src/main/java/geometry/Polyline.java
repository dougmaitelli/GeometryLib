package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas Maitelli
 */
public class Polyline {

    private ArrayList<Point> points = new ArrayList<Point>();

    public Polyline() {
    }

    public Polyline(ArrayList<Point> points) {
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

    public int size() {
        return points.size();
    }

    public double getTotalLength() {
        double distance = 0;

        for (LineSegment ls : getLineSegments()) {
            distance += ls.getTotalLength();
        }

        return distance;
    }

    public List<LineSegment> getLineSegments() {
        List<LineSegment> lines = new ArrayList<>();

        for (int i = 0; i < size() - 1; i++) {
            Point pp1 = getPoint(i);
            Point pp2 = getPoint(i + 1);

            lines.add(new LineSegment(pp1, pp2));
        }

        return lines;
    }

    public double distanceFromStart(Point p) {
        double distance = 0;

        for (LineSegment ls : getLineSegments()) {
            if (ls.hasPoint(p)) {
                distance += ls.getP1().distanceFromPoint(p);

                break;
            }

            distance += ls.getP1().distanceFromPoint(ls.getP2());
        }

        return distance;
    }

    public double distanceBetweenPoints(Point p1, Point p2) {
        return Math.abs(distanceFromStart(p1) - distanceFromStart(p2));
    }

    public Point getClosestPoint(Point p) {
        Double distance = Double.MAX_VALUE;

        Point cp = null;

        for (LineSegment ls : getLineSegments()) {
            Double d = ls.distanceFromPoint(p);

            if (d < distance) {
                distance = d;

                cp = ls.getClosestPoint(p);
            }
        }

        return cp;
    }

}
