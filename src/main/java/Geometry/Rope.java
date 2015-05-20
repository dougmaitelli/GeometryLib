package Geometry;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DougM
 */
public final class Rope {

    private Point p1;
    private Point p2;

    public Rope(Point p1, Point p2) {
        this.setP1(p1);
        this.setP2(p2);
    }

    public Rope(Circle c, Line s) {
        /*float x0 = c.x;
	float y0 = c.y;
	float x1 = l.s.x;
	float y1 = l.s.y;
	float x2 = l.e.x;
	float y2 = l.e.y;
	float n = Math.abs((x2-x1)*(y1-y0)-(x1-x0)*(y2-y1));
	float d = sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	float dist = n/d;
	if(dist > c.getR())return false;
	float d1 = Math.sqrt((x0-x1)*(x0-x1)+(y0-y1)*(y0-y1));
	if((d1-c.getR()) > d)return false;
	float d2 = sqrt((x0-x2)*(x0-x2)+(y0-y2)*(y0-y2));
	if((d2-c.getR()) > d)return false;
	return true;*/
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

}
