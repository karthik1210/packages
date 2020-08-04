package shape3d;
import shape2d.*;
public class Cuboid extends Rectangle implements Threed
{
public double height;
public Cuboid(double length,double breath,double height)
{
super(length,breath);
this.height = height;
}
public double volume()
{
return(length * breath * height);
}
public double surfaceArea()
{
return((2 * length * breath) + (2 * length * height) + (2 * height * breath));
}
}
