package pkcustomer;
import pkaccount.sb.*;	
import pkaccount.fd.*;
import java.util.*;
public class Customer
{
public int cust_id;
public String name;
public String address;
SBAccount sb;
FDAccount fd;
static int sbacc = 100;
static int fdacc = 500;
public Customer(int cust_id,String name,String address)
{
this.cust_id = cust_id;
this.name = name;
this.address = address;
}
public void createAccount(int type)
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter Initial Deposit Amount :");
double amount = sc.nextDouble();
if(type == 1)
{
sb = new SBAccount(++sbacc,amount);
System.out.println("SB Account created with acc number : "+sbacc+" with balance of Rs."+amount+" for the customer id : "+cust_id);
}
else if(type == 2)
{
System.out.println("Enter period :");
int period = sc.nextInt();
fd = new FDAccount(++fdacc,period,amount);
System.out.println("FD Account created with acc number : "+fdacc+" with balance of Rs."+amount+" for the customer id : "+cust_id);
}
else 
System.err.println("Invalid Choice ");
}
public void transaction(int type)
{
Scanner sc = new Scanner(System.in);
if(type == 1)
{
System.out.println("Enter amount for Deposit :");
double amount = sc.nextInt();
sb.deposit(amount);
}
else if(type == 2)
{
System.out.println("Enter amount for Withdraw :");
double amount = sc.nextInt();
sb.withdraw(amount);
}
else if(type == 3)
sb.calc_interest();
else if(type == 4)
fd.close();
else 
System.err.println("Invalid Choice");
}
}

