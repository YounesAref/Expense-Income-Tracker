public class Income extends Money {

  public Income() {}

  public Income(String user, String name, Double amount, String day, String month, String year, String description) {
    super.user = user;
    super.name = name;
    super.amount = amount;
    super.day = day;
    super.month = month;
    super.year = year;
    super.description = description;
  }

  public Income(String user, String name, Double amount, String day, String month, String year, String description, String familyName) {
    super.user = user;
    super.name = name;
    super.amount = amount;
    super.day = day;
    super.month = month;
    super.year = year;
    super.description = description;
    super.familyName = familyName;
  }
}
