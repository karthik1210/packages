import java.util.*;
class Account
{
protected int accnumber;
protected double balance;
Account()
{
}
Account(int accnumber,double balance)
{
this.accnumber = accnumber;
this.balance = balance;
}
}
class SBAccount extends Account
{
SBAccount(int accountnumber,double init_balance)
{
super(accountnumber,init_balance);
}
void deposit(double amount,String name)
{
if(amount > 0)
{
balance += amount;
System.out.println("New Balance of "+name+" is :"+balance);
}
else 
System.err.println("Invalid Amount");
}
void withdraw(double amount,String name)
{
if(balance - amount >= 1000)
{
balance -= amount;
System.out.println("New Balance of "+name+" is :"+balance);
}
else 
System.err.println("OOPS!! Operation not possible due to Low Balance");
}
void calc_interest(String name)
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter period in years :");
int period = sc.nextInt();
balance = balance + balance * 4 * period / 100;
System.out.println("New Balance of "+name+" is :"+balance);
}
}
class FDAccount extends Account
{
int period;
FDAccount(int accno,int period,double deposit)
{
super(accno,deposit);
this.period = period;
}
void disp(String name)
{
System.out.println("New Balance of "+name+" is :"+balance);
} 
double calc_interest()
{
return(balance * 8.25 * period / 100);
}
void close(String name)
{
balance += calc_interest();
System.out.println("Matured Amount of "+name+" is :"+balance);
}
}
class Customer
{
int cust_id;
String name,address;
SBAccount sb;
FDAccount fd;
static int sbacc = 100, fdacc = 500;
Customer(int cust_id,String name,String address)
{
this.cust_id = cust_id;
this.name = name;
this.address = address;
}
void createAccount(int type)
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter Initial Deposit Amount :");
double balance = sc.nextDouble();
if(balance >= 1000)
{
if(type == 1)
{
sb = new SBAccount(++sbacc,balance);
System.out.println("SB Account created with Account number of "+sb.accnumber+" with balance of "+sb.balance+" for customer "+name+" with customer id : "+cust_id);
}
if(type == 2)
{
System.out.println("Enter period in years :");
int period = sc.nextInt();
fd = new FDAccount(++fdacc,period,balance);
System.out.println("FD Account created with Account number of "+fd.accnumber+" with balance of "+fd.balance+" for customer "+name+" with customer id : "+cust_id);
}
}
else
{
System.out.println("Initial Deposit must be Rs.1000 or more !!");
createAccount(type);
}
}
void transaction(int type)
{
Scanner sc = new Scanner(System.in);
if(type == 1)
{
System.out.println("Enter Amount for Deposit :");
double amount = sc.nextDouble();
sb.deposit(amount,name);
}
else if(type == 2)
{
System.out.println("Enter Amount for Withdraw :");
double amount = sc.nextDouble();
if(sb.balance > 1000)
{
if(sb.balance - amount >= 1000)
sb.withdraw(amount,name);
else
{
System.out.println("Minimum balance should be Rs.1000/- ");
transaction(type);
}
}
else
System.out.println("Balance Rs.1000/-, since Minimum balance Rs.1000/-, withdraw not possible!!");
}
else if(type == 3)
sb.calc_interest(name);
else if(type == 4)
fd.close(name);
else if(type == 5)
fd.disp(name);
else
System.err.println("Invalid Operation");
}
}
class BankDem
{
static int ct;
public static void main(String arg[])
{
Scanner sc = new Scanner(System.in);
int n = 5;
Customer c[] = new Customer[n];
for(int i=0;i<n;i++)
c[i] = null;
int type,type1 = 0,type2,cusid = 0,cid = 0,x = 0,count = 0,cust_id = 0;
do
{
System.out.println("Enter Choice");
System.out.println("Create Account ---> 1");
System.out.println("Making a Transaction ---> 2");
System.out.println("Exit ---> 3");
type = sc.nextInt();
switch(type)
{
case 1:
System.out.println("Enter name and Address :");
String name = sc.next();
String address = sc.next();
try
{
if(type == 1)
{
int f = 0;
for(int i=0;i<n;i++)
if(c[i] == null)
{
cust_id = i;
f = 1;
break;
}
if(f == 0)
cid = 5;
for(int i=cust_id;i<n;i++)
{
if(c[i] == null)
{
c[i] = new Customer(++cust_id,name,address);
break;
}
}
if(f == 0 && cid == 5)
cust_id = 6;
System.out.println("Select type of Account");
System.out.println("SB Account ---> 1");
System.out.println("FD Account ---> 2");
type1 = sc.nextInt();
if(type1 == 1 || type1 == 2)
{
if((cust_id) <= n)
{
for(int i=(cust_id-1);i<n;i++)
if(c[i] != null)
{
c[i].createAccount(type1);
count++;
break;
}
}
else
System.out.println("Account limit exhausted");
}
else 
System.err.println("Invalid Selection of Choice ");
}
}catch(Exception e)
{
System.out.println("Account limit exhausted");
}
break;
case 2:
try
{
System.out.println("Enter Customer Id :");
cusid = sc.nextInt();
if(c[cusid-1].sb instanceof SBAccount)
System.out.println("SB Account");
else 
System.out.println("FD Account");
System.out.println("Enter Type of Account would like to Access");
System.out.println("SB Account ---> 1");
System.out.println("FD Account ---> 2");
type1 = sc.nextInt();
if(type1 == 1 && c[cusid-1].sb instanceof SBAccount)
{
System.out.println(cusid);
System.out.println(c[cusid-1].name);
System.out.println(c[cusid-1].sb.balance);
}
else if(type1 == 2 && c[cusid-1].fd instanceof FDAccount)
{
System.out.println(cusid);
System.out.println(c[cusid-1].name);
System.out.println(c[cusid-1].fd.balance);
}
else 
System.err.println("You do not have this type of Account ");
if(type1 == 1 && c[cusid-1].sb instanceof SBAccount)
{
System.out.println("Enter choice for Transaction ");
System.out.println("Deposit ---> 1");
System.out.println("Withdraw ---> 2");
System.out.println("Interest Calculation ---> 3");
type2 = sc.nextInt();
if(type2 == 1 || type2 == 2 || type2 == 3)
c[cusid-1].transaction(type2);
else 
System.err.println("Invalid Choice");
}
else if(type1 == 2 && c[cusid-1].fd instanceof FDAccount)
{
System.out.println("Enter choice for Transaction ");
System.out.println("Close FD Account ---> 4");
System.out.println("Check Balance ---> 5");
type2 = sc.nextInt();
if(type2 == 4)
{
c[cusid-1].transaction(type2);
c[cusid-1] = null;
}
else if(type2 == 5)
c[cusid-1].transaction(type2);
else 
System.err.println("Invalid Choice");
}
}catch(Exception e)
{
System.err.println("You do not Account with us or closed your existing Account. Thank you!!");
}
break;
case 3:
break;
default:
System.err.println("Invalid Choice ");
}
}while(type < 3);
}
}
