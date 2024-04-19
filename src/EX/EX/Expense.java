package EX;

public class Expense {

    private String description;
    private double amount;
    private int year;
    private String date;
    private String time;

    public Expense(String description, double amount, int year, String date, String time) {
        this.description = description;
        this.amount = amount;
        this.year = year;
        this.date = date;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public int getYear() {
        return year;
    }

    public String getDate() {
        return date;
    }
}