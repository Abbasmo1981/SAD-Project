package model;

public class ComparisonData {
    private final PriceData company1;
    private final PriceData company2;

    public ComparisonData(PriceData company1, PriceData company2) {
        this.company1 = company1;
        this.company2 = company2;
    }

    public PriceData getCompany1() { return company1; }
    public PriceData getCompany2() { return company2; }
}
