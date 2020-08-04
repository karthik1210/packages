package pkbanking.pkinterface;
public interface Transaction
{
public final int min_balance = 500;
public void withdraw(double amount);
public void deposit(double amount);
}	