package shape3d;
import shape2d.*;
public class Sphere extends Circle implements Threed
{
public Sphere(double radius)
{
super(radius);
}
public double volume()
{
return(4 * Math.PI * radius * radius * radius / 3);
}
public double surfaceArea()
{
return(4 * Math.PI * radius * radius);
}
}