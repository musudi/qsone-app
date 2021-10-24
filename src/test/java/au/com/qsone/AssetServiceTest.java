package au.com.qsone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import au.com.qsone.service.AssetService;
import au.com.qsone.model.Asset;
import au.com.qsone.model.AssetRequest;

@ExtendWith(MockitoExtension.class)
public class AssetServiceTest {

    @InjectMocks
    private AssetService assetService;

    @Mock
    Environment environment;

    @BeforeEach
    void setMockOutput() throws FileNotFoundException {
        when(environment.getProperty("reference.data.file")).thenReturn("src/test/resources/assets.yml");
    }

    @Test
    public void saveAssetTest() throws IOException {
        AssetRequest assetRequest = new AssetRequest();
        Asset p1 = new Asset();
        p1.setAssetId(3L);

        Asset c1 = new Asset(8L, 1, "CAPITAL X1", null, null);
        Asset c2 = new Asset(9L, 1, "ORIGINAL X1", null, null);

        assetRequest.setParentAsset(p1);
        assetRequest.setChildAssets(new ArrayList<Asset>());
        assetRequest.getChildAssets().add(c1);
        assetRequest.getChildAssets().add(c2);

        Asset response = assetService.saveAsset(assetRequest);
        assertThat(response.getAssetId()).isEqualTo(1L);
    }
}