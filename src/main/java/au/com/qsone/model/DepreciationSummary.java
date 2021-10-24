package au.com.qsone.model;

import java.util.List;
import java.time.LocalDate;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepreciationSummary {

    private Property property;
    private List<DepreciationResult> results;
    private BigDecimal lowValuePool;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate firstTaxableEndDate;
}
