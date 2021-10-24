package au.com.qsone.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import au.com.qsone.model.Asset;

@ExtendWith(MockitoExtension.class)
public class YamlUtilTest {

    @Mock
    Environment environment;

    @Test
    public void readYmlTest() throws FileNotFoundException {
        Asset asset = YamlUtil.readYml("D://$STUDY/qsone-app/src/test/resources/assets.yml");
        assertThat(asset.getAssetId()).isEqualTo(1L);
    }

}
