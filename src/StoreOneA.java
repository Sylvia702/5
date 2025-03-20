public class StoreOneA extends StoreToRent {
    private boolean specialCustomer;
    private double monthlyPayment;

    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    @Override
    public double calculateLoanFinancing() {
        monthlyPayment = super.calculateLoanFinancing();
        if (specialCustomer) {
            double DISCOUNT_RATE = 0.1; 
            monthlyPayment -= (monthlyPayment * DISCOUNT_RATE);
        }
        return monthlyPayment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nLOAN DETAILS (if applicable):\n");
        sb.append("Loan Amount: ").append(getLoanAmount()).append("\n");
        sb.append("Loan Payment Term: ").append(getLoanPaymentTerm()).append("\n");
        sb.append("Interest Rate: ").append(getINTEREST_RATE()).append("\n");
        sb.append("Special Customer: ").append(specialCustomer).append("\n");
        sb.append("Monthly Loan Payment: ").append(monthlyPayment).append("\n");
        return sb.toString();
    }

    private double getLoanAmount() {
        return super.getLoanAmount();
    }

    private int getLoanPaymentTerm() {
        return super.getLoanPaymentTerm();
    }

    private double getINTEREST_RATE() {
        return super.getINTEREST_RATE();
    }
}