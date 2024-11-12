
import java.io.*;
import java.util.ArrayList;

public class ExpenseStorage {
    private String fileName;

    public ExpenseStorage(String fileName) {
        this.fileName = fileName;
    }

    public void saveExpenses(ArrayList<Expense> expenses) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(expenses);
            System.out.println("Expenses saved.");
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    public ArrayList<Expense> loadExpenses() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<Expense>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous expense records found.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
            return null;
        }
    }
}
