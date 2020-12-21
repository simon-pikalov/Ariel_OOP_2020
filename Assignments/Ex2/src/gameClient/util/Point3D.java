/**
 * This class represents a 3D point in space.
 */
package gameClient.util;

import api.geo_location;

import java.io.Serializable;

public class Point3D implements geo_location, Serializable{
	private static final long serialVersionUID = 1L;
	/**
     * Simple set of constants - should be defined in a different class (say class Constants).*/
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    /**
     * This field represents the origin point:[0,0,0]
     */
    public static final Point3D ORIGIN = new Point3D(0,0,0);
    private double _x,_y,_z;
    public Point3D(double x, double y, double z) {
        _x=x;
        _y=y;
        _z=z;
    }

    public Point3D(Point3D p) {
       this(p.x(), p.y(), p.z());
    }
    public Point3D(double x, double y) {this(x,y,0);}
    public Point3D(String s) { try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
            _z = Double.parseDouble(a[2]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for POint3D init, got:"+s+"  should be of format: x,y,x");
            throw(e);
        }
    }
    @Override
    public double x() {return _x;}
    @Override
    public double y() {return _y;}
    @Override
    public double z() {return _z;}


    public String toString() { return _x+","+_y+","+_z; }
    @Override
    public double distance(geo_location p2) {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double dz = this.z() - p2.z();
        double t = (dx*dx+dy*dy+dz*dz);
        return Math.sqrt(t);
    }

    public boolean equals(Object p) {
        if(p==null || !(p instanceof geo_location)) {return false;}
        Point3D p2 = (Point3D)p;
        return ( (_x==p2._x) && (_y==p2._y) && (_z==p2._z) );
    }
    public boolean close2equals(geo_location p2) {
        return ( this.distance(p2) < EPS ); }
    public boolean equalsXY (Point3D p)
    {return p._x == _x && p._y == _y;}

     public String toString(boolean all) {
        if(all) return "[" + _x + "," +_y+","+_z+"]";
        else return "[" + (int)_x + "," + (int)_y+","+(int)_z+"]";
    }
}

