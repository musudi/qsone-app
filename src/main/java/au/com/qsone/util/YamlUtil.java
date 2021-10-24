package au.com.qsone.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import au.com.qsone.model.Asset;

public class YamlUtil {

    public static Asset readYml(String path) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(path);
        Asset asset = yaml.loadAs(inputStream, Asset.class);
        return asset;
    }

    public static void writeYml(String path, Asset asset) throws IOException {
        DumperOptions options = new DumperOptions();
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Yaml yaml = new Yaml(options);
        String s = yaml.dump(asset);

        File data = new File(path);
        FileOutputStream file = new FileOutputStream(data);
        FilterOutputStream filter = new FilterOutputStream(file);
        byte b[] = s.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        file.close();
    }
}
