package au.com.qsone.depreciable.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Property {

    private Integer jobNumber;
    private String propertyAddress;
    private String propertyType;
    private Integer propertyCode;
    private String region;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate yearOfConstruction;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfContractExchange;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate firstLeaseDate;
    private String reportCalculationYear;
    private BigDecimal purchasePrice;
    private BigDecimal construtionPrice;
    private BigDecimal floorArea;
    private int usefulLifeInYears;
    private int remainingLifeYears;
}
