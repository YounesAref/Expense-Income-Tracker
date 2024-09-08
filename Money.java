public abstract class Money {
  protected String user;
  protected String name;
  protected Double amount;
  protected String day;
  protected String month;
  protected String year;
  protected String category;
  protected String description;
  protected String familyName;

  public void setName(String name) {
    this.name = name;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public Double getAmount() {
    return amount;
  }

  public String getCategory() {
    return category;
  }

  public String getDescription() {
    return description;
  }

  public String getUser() {
    return user;
  }

  public String getDay() {
    return day;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }

  public String getFamilyName() {
    return familyName;
  }
}
