package au.com.qsone.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    private Integer jobNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate yearOfConstruction;
    private int usefulLifeInYears;
    private int remainingLifeYears;

    private String owner;
    private String phone;
    private String mobile;
    private String email;
    private String propertyType;
    private AddressModel address;
    private BigDecimal purchasePrice;
    private BigDecimal stampDuty;
    private BigDecimal legalCosts;
    private BigDecimal additionalExpenses;
    private BigDecimal originalBuildingCost;
    private String forAndBehalfOfOwner;
    private String nameOfAuthorizedPerson;
    private String comments;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate constructionStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate constructionEnd;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfContractExchange;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateSettlement;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate firstLeaseDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate firstTaxableEndDate;

}
