package au.com.qsone.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepreciationAmount {

    private BigDecimal plantAndEquipment;
    private BigDecimal captial;
    private BigDecimal total;
}
