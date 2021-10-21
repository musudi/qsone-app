package au.com.qsone.depreciable;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ReferenceData {

    public static void main(String[] args) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream("D://$STUDY/qsone-app/src/main/resources/assets.yml");
        System.out.println(inputStream);

        HashMap yamlMap = yaml.load(inputStream);
        for (Object o : yamlMap.entrySet()) {
            System.out.println(o);
        }
        // Access HashMaps and ArrayList by key(s)
        HashMap assets = (HashMap) yamlMap.get("assets");
        HashMap parent = (HashMap) assets.get("Asset(CAPITAL WORKS DIV 43)");
        HashMap children = (HashMap) assets.get("Asset(CAPITAL WORKS DIV 43)");
        // List<Asset> children = (ArrayList) parent.values();
        System.out.println(parent.values());
    }
}