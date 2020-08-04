package pkaccount.sb;
import pkaccount.*;
import pkbanking.pkinterface.*;
public class SBAccount extends Account implements Transaction,InterestRate
{
public SBAccount(int accountnumber,double init_balance)
{
super(accountnumber,init_balance);
}
public void deposit(double amount)
{
if(amount > 0)
{
balance += amount;
System.out.println("New Balance = "+balance);
}
else 
System.err.println("Invalid Amount");
}
public void withdraw(double amount)
{
if(balance - amount > min_balance)
{
balance -= amount;
System.out.println("New Balance = "+balance);
}
else
System.err.println("Low Balance");
}
public void calc_interest()
{
balance += balance * sbrate;
System.out.println("New Balance = "+balance);
}
}