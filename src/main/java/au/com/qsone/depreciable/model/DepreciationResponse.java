package au.com.qsone.depreciable.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepreciationResponse {

    private Property property;
    private List<DepreciationResult> depreciationResults;
}
