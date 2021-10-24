package au.com.qsone.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DepreciationResult {

    private int year;
    private String yearCount;
    private String fromDate;
    private String toDate;
    private BigDecimal buildingCost;
    private BigDecimal depreciationAmount;
    private DepreciationAmount diminishingMethod;
    private DepreciationAmount primeCostMethod;

    @Override
    public String toString() {
        return year + ", " + buildingCost + ", " + depreciationAmount;
    }
}
