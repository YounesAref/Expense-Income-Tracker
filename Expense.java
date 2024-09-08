public class Expense extends Money {

  public Expense(String user, String name, Double amount, String day, String month, String year, String category, String description) {
    super.user = user;
    super.name = name;
    super.amount = amount;
    super.day = day;
    super.month = month;
    super.year = year;
    super.category = category;
    super.description = description;
  }

  public Expense(String user, String name, Double amount, String day, String month, String year, String category, String description, String familyName) {
    super.user = user;
    super.name = name;
    super.amount = amount;
    super.day = day;
    super.month = month;
    super.year = year;
    super.category = category;
    super.description = description;
    super.familyName = familyName;
  }
}
