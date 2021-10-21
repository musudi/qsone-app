package au.com.qsone.depreciable.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepreciationRequest {

    private Property property;
    private BigDecimal openingValueCost;
    private BigDecimal lowValuePool;
    private String constructionYear;
    private int estimatedNoOfYears;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate firstTaxableEndDate;
}
