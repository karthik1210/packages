package pkaccount.fd;
import pkaccount.*;
import pkbanking.pkinterface.*;
public class FDAccount extends Account implements InterestRate
{
public int period;
public FDAccount(int accno,int period,double depositamount)
{
super(accno,depositamount);
this.period = period;
}
public double calc_interest()
{
return(balance * period * fdrate);
}
public void close()
{
balance += calc_interest();
System.out.println("Matured Amount = "+balance);
}
}
