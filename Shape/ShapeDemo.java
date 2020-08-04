import shape2d.*;
import shape3d.*;
import java.util.*;
class ShapeDemo
{
public static void main(String arg[])
{
Scanner sc = new Scanner(System.in);
int ch,ch1;
do
{
System.out.println("1 ---> Square");
System.out.println("2 ---> Rectangle");
System.out.println("3 ---> Circle");
System.out.println("4 ---> Cube");
System.out.println("5 ---> Cuboid");
System.out.println("6 ---> Sphere");
System.out.println("7 ---> Exit");
System.out.println("Enter choice :");
ch = sc.nextInt();
switch(ch)
{
case 1:
System.out.println("Enter a side :");
double side = sc.nextDouble();
Square s = new Square(side);
System.out.println("1 ---> Area");
System.out.println("2 ---> Perimeter");
System.out.println("Enter choice :");
ch1 = sc.nextInt();
if(ch1 == 1)
System.out.println("Area of Square = "+s.area());
else if(ch1 == 2)
System.out.println("Perimeter of Square = "+s.perimeter());
else
System.out.println("Invalid Selection");
break;
case 2:
System.out.println("Enter Length and Breath :");
double length = sc.nextDouble();
double breath = sc.nextDouble();
Rectangle r = new Rectangle(length,breath);
System.out.println("1 ---> Area");
System.out.println("2 ---> Perimeter");
System.out.println("Enter choice :");
ch1 = sc.nextInt();
if(ch1 == 1)
System.out.println("Area of Rectangle = "+r.area());
else if(ch1 == 2)
System.out.println("Perimeter of Rectangle = "+r.perimeter());
else
System.out.println("Invalid Selection");
break;
case 3:
System.out.println("Enter radius :");
double radius = sc.nextDouble();
Circle cir = new Circle(radius);
System.out.println("1 ---> Area");
System.out.println("2 ---> Perimeter");
System.out.println("Enter choice :");
ch1 = sc.nextInt();
if(ch1 == 1)
System.out.println("Area of Circle = "+cir.area());
else if(ch1 == 2)
System.out.println("Perimeter of Circle = "+cir.perimeter());
else
System.out.println("Invalid Selection");
break;
case 4:
System.out.println("Enter a side :");
side = sc.nextDouble();
Cube c = new Cube(side);
System.out.println("1 ---> Volume");
System.out.println("2 ---> Surface Area");
System.out.println("Enter choice :");
ch1 = sc.nextInt();
if(ch1 == 1)
System.out.println("Volume of Cube = "+c.volume());
else if(ch1 == 2)
System.out.println("SurfaceArea of Cube = "+c.surfaceArea());
else
System.out.println("Invalid Selection");
break;
case 5:
System.out.println("Enter Length,Breath and Height :");
length = sc.nextDouble();
breath = sc.nextDouble();
double height = sc.nextDouble();
Cuboid cu = new Cuboid(length,breath,height);
System.out.println("1 ---> Volume");
System.out.println("2 ---> Surface Area");
System.out.println("Enter choice :");
ch1 = sc.nextInt();
if(ch1 == 1)
System.out.println("Volume of Cuboid = "+cu.volume());
else if(ch1 == 2)
System.out.println("SurfaceArea of Cuboid = "+cu.surfaceArea());
else
System.out.println("Invalid Selection");
break;
case 6:
System.out.println("Enter radius :");
radius = sc.nextDouble();
Sphere sp = new Sphere(radius);
System.out.println("1 ---> Volume");
System.out.println("2 ---> Surface Area");
System.out.println("Enter choice :");
ch1 = sc.nextInt();
if(ch1 == 1)
System.out.println("Volume of Sphere = "+sp.volume());
else if(ch1 == 2)
System.out.println("SurfaceArea of Sphere = "+sp.surfaceArea());
else
System.out.println("Invalid Selection");
break;
case 7:
break;
default:
System.out.println("Invalid Selection");
}
}while(ch < 7);
}
}