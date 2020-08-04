package shape3d;
import shape2d.*;
public class Cube extends Square implements Threed
{
public Cube(double side)
{
super(side);
}
public double volume()
{
return(side * side * side);
}
public double surfaceArea()
{
return(6 * side * side);
}
}
