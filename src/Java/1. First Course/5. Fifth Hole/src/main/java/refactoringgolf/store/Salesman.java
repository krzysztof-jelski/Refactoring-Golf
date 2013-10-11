package refactoringgolf.store;

public class Salesman extends Employee {

    private int commissionPercentage;
    private float monthQuota;

    public Salesman(String firstName, String lastName, float fixedSalary, int commissionPercentage) {
        super(firstName, lastName, fixedSalary);
        this.commissionPercentage = commissionPercentage;
    }

    public void setCommissionPercentage(int commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public int getCommissionPercentage() {
        return commissionPercentage;
    }

    public float getMonthQuota() {
        return monthQuota;
    }

    public float netSalary() {
        float benefits = monthQuota * commissionPercentage / 100;
        float pensionFounds = fixedSalary * 10 / 100;
        float tax = 0;
        if (fixedSalary > 3500)
            tax = fixedSalary * 5 / 100;
        return fixedSalary + benefits - pensionFounds - tax;
    }

    public void updateMonthQuota(float addQuota) {
        monthQuota = monthQuota + addQuota;
    }
}
