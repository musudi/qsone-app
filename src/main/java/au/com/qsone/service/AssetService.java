package au.com.qsone.service;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import au.com.qsone.util.YamlUtil;
import au.com.qsone.model.Asset;
import au.com.qsone.model.AssetRequest;

@Service
public class AssetService {

    @Autowired
    private Environment environment;

    /**
     * This method retuns all the assets defined in the Yaml definition.
     * 
     * @return Asset
     * @throws FileNotFoundException
     */
    public Asset getAllAssets() throws FileNotFoundException {
        return getAssetsFromYaml();
    }

    /**
     * This method retuns specific asset based on the assetId.
     * 
     * @return Asset
     * @throws FileNotFoundException
     */
    public Asset getAssetById(final long id) throws FileNotFoundException {
        return getAssetByAssetId(id);
    }

    /**
     * This mehtod adds the child elements to the parent asset identified by the
     * AssetId.
     * 
     * @param assetRequest
     * @return Asset
     * @throws IOException
     */
    public Asset saveAsset(final AssetRequest assetRequest) throws IOException {

        Asset referenceData = getAssetsFromYaml();
        Asset selectedAsset = getAssetByAssetId(assetRequest.getParentAsset().getAssetId());
        if (selectedAsset != null) {
            assetRequest.getChildAssets().forEach(c -> c.setAssetParent(selectedAsset));
            selectedAsset.getChildren().addAll(assetRequest.getChildAssets());

            Asset parent = referenceData;
            // parent.getChildren().forEach(e -> e.flattened().map(o ->
            // o.getAssetId().equals(selectedAsset.getAssetId()) ? selectedAsset : o));
            List<Asset> assets = referenceData.flattened()
                    .map(o -> o.getAssetId().equals(selectedAsset.getAssetId()) ? selectedAsset : o)
                    .collect(Collectors.toList());

            YamlUtil.writeYml(environment.getProperty("reference.data.file"), assets.get(0));
        }

        return referenceData;
    }

    private Asset getAssetsFromYaml() throws FileNotFoundException {
        return YamlUtil.readYml(environment.getProperty("reference.data.file"));
    }

    private Asset getAssetByAssetId(final long id) throws FileNotFoundException {
        Asset asset = getAssetsFromYaml();
        Optional<Asset> parent = asset.flattened().filter(a -> a.getAssetId().equals(id)).findFirst();

        if (parent.isPresent()) {
            return parent.get();
        }

        return null;
    }
}
