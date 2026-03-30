import java.util.ArrayList;
import java.util.List;

public class Account {
    String name;
    double balance;
    List<Transaction> transactions = new ArrayList<>();
    
    Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
}
