
import java.io.Serializable;

public class Expense implements Serializable {
    private String category;
    private String description;
    private double amount;

    public Expense(String category, String description, double amount) {
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Description: " + description + ", Amount: $" + amount;
    }
}
