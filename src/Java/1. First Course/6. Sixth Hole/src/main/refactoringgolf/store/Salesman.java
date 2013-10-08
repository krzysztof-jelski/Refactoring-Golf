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

	public void updateMonthQuota(float addQuota) {
		monthQuota = monthQuota + addQuota;
	}

	protected float salaryBenefits() {
		return monthQuota * commissionPercentage / 100;
	}
}
