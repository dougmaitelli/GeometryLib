package Geometry;


import java.util.ArrayList;

/**
 *
 * @author Douglas Maitelli
 */
public final class Polyline {

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
    
    public Double distanceBetweenPoints(Point p1, Point p2) {
        return inlineDistanceBetweenPoints(this, p1, p2);
    }

    public Integer size() {
        return points.size();
    }

    public static Double inlineDistanceBetweenPoints(Polyline polyline, Point p1, Point p2) {
        Double distance = null;

        for (int i = 0; i < polyline.size() - 1; i++) {
            Point pp1 = polyline.getPoint(i);
            Point pp2 = polyline.getPoint(i + 1);

            Line line = new Line(pp1, pp2);

            if (distance == null && line.hasPoint(p1) && line.hasPoint(p2)) {
                distance = p1.distanceFromPoint(p2);

                break;
            }

            if (line.hasPoint(p1)) {
                if (distance == null) {
                    distance = p1.distanceFromPoint(pp2);

                    continue;
                } else {
                    distance += pp1.distanceFromPoint(p1);

                    break;
                }
            }

            if (line.hasPoint(p2)) {
                if (distance == null) {
                    distance = p2.distanceFromPoint(pp2);

                    continue;
                } else {
                    distance += pp1.distanceFromPoint(p2);

                    break;
                }
            }

            if (distance != null) {
                distance += pp1.distanceFromPoint(pp2);
            }
        }

        return distance;
    }
}
