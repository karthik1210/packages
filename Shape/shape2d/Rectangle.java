package shape2d;
public class Rectangle implements Twod
{
public double length,breath;
public Rectangle(double length,double breath)
{
this.length = length;
this.breath = breath;
}
public double area()
{
return(length * breath);
}
public double perimeter()
{
return(2 * (length + breath));
}
}
