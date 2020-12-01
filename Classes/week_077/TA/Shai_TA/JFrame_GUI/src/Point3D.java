/**
 * This class represents a 3D point in space, with several methods
 * for 2D including Point-Line test.
 */


import java.io.Serializable;

public class Point3D implements Serializable
{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Simple set of constants - should be defined in a different class (say class Constants).*/
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    /**
     * This field represents the origin point:[0,0,0]
     */
    public static final Point3D ORIGIN = new Point3D(0,0,0);
    ////////////////////////////////////////////
    //////////////    fields     ///////////////
    ////////////////////////////////////////////
    private double _x,_y,_z;


    /////////////////////////////////////////////////////////////////
    ///////////////////     Constructor     /////////////////////////
    /////////////////////////////////////////////////////////////////
    public Point3D(double x,double y,double z)
    {
        _x=x;
        _y=y;
        _z=z;
    }

    public Point3D(Point3D p)
    {
       this(p.x(), p.y(), p.z());
    }
    public Point3D(double x,double y)
    {this(x,y,0);}
    public Point3D(String s) {
        try {
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
    ///////////////////////////////////////////////////////////////////////////
    ////////////////////////////       methods        /////////////////////////
    ///////////////////////////////////////////////////////////////////////////


    public double x() {return _x;}
    public double y() {return _y;}
    public double z() {return _z;}
    public void setX(double x){_x = x;}
    public void setY(double y){_y = y;}
    public void setZ(double z){_z = z;}
    public int ix() {return (int)_x;}
    public int iy() {return (int)_y;}
    public int iz() {return (int)_z;}

    public void add(Point3D p) { add(p._x,p._y,p._z);}

    public void add(double dx, double dy, double dz) {
        _x+=dx;_y+=dy;_z+=dz;
    }

    /**
     * Multiplication of this point by scalar (d)
     * @param d
     */
    public void factor(double d){
        _x *= d;
        _y *= d;
        _z *= d;
    }

    public String toString()
    {
        return _x+","+_y+","+_z;
    }

    public double distance3D(Point3D p2)
    {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double dz = this.z() - p2.z();
        double t = (dx*dx+dy*dy+dz*dz);
        return Math.sqrt(t);
    }
    public double distance3D()
    {
        return this.distance3D(ORIGIN);
    }
    public double distance2D(Point3D p2)
    {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }


    public boolean equals(Object p)
    {
        if(p==null || !(p instanceof Point3D)) {return false;}
        Point3D p2 = (Point3D)p;
        return ( (_x==p2._x) && (_y==p2._y) && (_z==p2._z) );
    }
    public boolean close2equals(Point3D p2)
    {
        return ( this.distance3D(p2) < EPS );
    }
    public boolean equalsXY (Point3D p)
    {return p._x == _x && p._y == _y;}

    //  public String toString() {return "[" + (int)_x + "," + (int)_y+","+_z+"]";}
    public String toString(boolean all) {
        if(all) return "[" + _x + "," +_y+","+_z+"]";
        else return "[" + (int)_x + "," + (int)_y+","+(int)_z+"]";
    }
    public String toFile()  {return _x+" "+_y+" "+_z+" ";}

    public String toFile1()  {return "Point3D "+_x+" "+_y+" "+_z;}

    ////////////////////////////////////////////////////////////////////////////////////////

    public final static int ONSEGMENT = 0,  LEFT = 1, RIGHT = 2, INFRONTOFA = 3, BEHINDB = 4, ERROR = 5;
    public final static int DOWN = 6, UP = 7;

    /** return up iff this point is above the SEGMENT (not the line) */
    public int pointLineTest2(Point3D a, Point3D b) {
        int flag = this.pointLineTest(a,b);
        if(a._x < b._x ) {
            if(a._x<=_x && b._x>_x) {
                if (flag == LEFT) return DOWN;
                if (flag == RIGHT) return UP;
            }
        }
        else
        if(a._x > b._x ) {
            if(b._x<=_x && a._x>_x) {
                if (flag == RIGHT) return DOWN;
                if (flag == LEFT) return UP;
            }
        }
        return flag;
    }


    /** pointLineTest <br>
     test the following location of a point regards a line segment - all in 2D projection.<br><br>

     ONSEGMENT:  �����a----+----b������                              <br> <br>

     +       +        +                              <br>
     LEFT:	 �����a---------b������                              <br> <br>


     RIGHT:	 �����a---------b������                              <br>
     +      +        +                              <br> <br>

     INFRONTOFA:  ��+��a---------b������                              <br>
     BEHINDB:  �����a---------b����+�                              <br>
     ERROR: a==b || a==null || b == null;                               <br>
     */

    public int pointLineTest(Point3D a, Point3D b) {

        if(a== null || b==null || a.equalsXY(b)) return ERROR;

        double dx = b._x-a._x;
        double dy = b._y-a._y;
        double res = dy*(_x-a._x)-dx*(_y-a._y);

        if (res < 0) return LEFT;
        if (res > 0) return RIGHT;

        if (dx > 0) {
            if (_x < a._x) return INFRONTOFA;
            if (b._x < _x) return BEHINDB;
            return ONSEGMENT;
        }
        if (dx < 0) {
            if (_x > a._x) return INFRONTOFA;
            if (b._x > _x) return BEHINDB;
            return ONSEGMENT;
        }
        if (dy > 0) {
            if (_y < a._y) return INFRONTOFA;
            if (b._y < _y) return BEHINDB;
            return ONSEGMENT;
        }
        if (dy < 0) {
            if (_y > a._y) return INFRONTOFA;
            if (b._y > _y) return BEHINDB;
            return ONSEGMENT;
        }
        return ERROR;
    }


    ///////////////////////////// NEW METHODS ///////////////////////////////////
    public void rescale(Point3D center, Point3D vec) {
        if(center!=null && vec != null)
            rescale(center,vec.x(),vec.y(),vec.z());
    }

    public void rescale(Point3D center, double size) {
        if(center!=null && size>0)
            rescale(center,size,size,size);
    }
    private void rescale(Point3D center, double sizeX,double sizeY, double sizeZ) {
        _x = center._x + ((_x - center._x) * sizeX);
        _y = center._y + ((_y - center._y) * sizeY);
        _z = center._z + ((_z - center._z) * sizeZ);
    }

    public void rotate2D(Point3D center, double angle) {
        // angle -1/2PI .. 1/2Piregular degrees.
        _x = _x - center.x();
        _y = _y - center.y();
        double a = Math.atan2(_y,_x);
        //	System.out.println("Angle: "+a);
        double radius = Math.sqrt((_x*_x) + (_y*_y));
        _x = (center.x() +  radius * Math.cos(a+angle));
        _y = (center.y() +  radius * Math.sin(a+angle));
    }
}

