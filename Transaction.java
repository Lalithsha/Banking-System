import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime timestamp;


    // Constructor
    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
        return String.format("%s: $%.2f at %s", type, amount, timestamp.format(formatter));
    }

}
