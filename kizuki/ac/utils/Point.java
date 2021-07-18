package kizuki.ac.utils;

public class Point implements Cloneable
{
    private double x;
    private double y;
    
    public Point() {
    }
    
    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setY(final double y) {
        this.y = y;
    }
    
    public void add(final Point point) {
        this.x += point.x;
        this.y += point.y;
    }
    
    public double angle(final Point point) {
        return Math.atan2(point.x - this.x, point.y - this.y);
    }
    
    @Override
    public String toString() {
        return "Point{p1=" + this.x + ", p2=" + this.y + '}';
    }
    
    protected Point clone2() {
        return new Point(this.x, this.y);
    }
}
