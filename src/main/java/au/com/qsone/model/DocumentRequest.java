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
public class DocumentRequest {

    private String template;
    private String createdBy;
    private String title;
    private String fileName;
    private Property property;
    //private Asset asset;
    private Object body;
    private BigDecimal lowValuePool;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate firstTaxableEndDate;
    private BigDecimal openingValueCost;
}
