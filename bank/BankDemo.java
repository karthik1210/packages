import pkcustomer.*;
import java.util.*;
public class BankDemo
{
static int i;
public static void main(String arg[])
{
Scanner sc = new Scanner(System.in);
Customer c[] = new Customer[5];
int ch,ch1,ch2;
do
{
System.out.println("1 -----> Create a new Account ");
System.out.println("2 -----> Making a Transaction");
System.out.println("3 -----> Exit");
System.out.println("Enter choice :");
ch = sc.nextInt();
switch(ch)
{
case 1:
try
{
System.out.println("Enter Name and Address ");
String name = sc.nextLine();
sc.nextLine();
String address = sc.nextLine();
c[i] = new Customer(++i,name,address);
System.out.println("1 -----> SB Account");
System.out.println("2 -----> FD Account");
System.out.println("Enter choice :");
ch1 = sc.nextInt();
c[i-1].createAccount(ch1);
}catch(Exception e)
{
System.out.println("Account Limit Exhausted");
}
break;
case 2:
try
{
System.out.println("Enter Customer Id :");
int cusid = sc.nextInt();
System.out.println("1 -----> Deposit on SB Account");
System.out.println("2 -----> Withdraw from SB Account");
System.out.println("3 -----> Calculate interest for SB Account");
System.out.println("4 -----> Close FD Account with interest");
System.out.println("Enter choice :");
ch2 = sc.nextInt();
if(ch2 == 1 || ch2 == 2 || ch2 == 3)
c[cusid-1].transaction(ch2);
else if(ch2 == 4)
{
c[cusid-1].transaction(ch2);
c[cusid-1] = null;
}
break;
}catch(Exception e)
{
System.out.println("You do not have this type account");
}
case 3:
break;
default:
System.out.println("Invalid Selection");
}
}while(ch != 3);
}
}
