package au.com.qsone.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetRequest {

    private Asset parentAsset;
    private List<Asset> childAssets;

}
