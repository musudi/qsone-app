package au.com.qsone;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import au.com.qsone.model.Asset;

import java.io.*;
import java.util.ArrayList;

public class ReferenceData {

    public static void main(String[] args) throws IOException {

        Asset p1 = new Asset(1L, 0, "CAPITAL WORKS DIV 43", null, null);

        Asset c1 = new Asset(2L, 1, "CAPITAL ALLOWANCE DIV 43", p1, null);
        Asset c2 = new Asset(3L, 1, "ORIGINAL COMMON AREAS", p1, null);

        Asset c11 = new Asset(4L, 2, "Main Unit Capital Allowance", c1, null);
        Asset c12 = new Asset(5L, 2, "Structure Renovations 2017", c1, null);

        Asset c21 = new Asset(6L, 2, "Common Areas Common Services", c2, null);
        Asset c22 = new Asset(7L, 2, "Structure Renovations 2017", c2, null);

        c1.setChildren(new ArrayList());
        c1.getChildren().add(c11);
        c1.getChildren().add(c12);

        c2.setChildren(new ArrayList());
        c2.getChildren().add(c21);
        c2.getChildren().add(c22);

        p1.setChildren(new ArrayList());
        p1.getChildren().add(c1);
        p1.getChildren().add(c2);

        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Representer representer = new Representer();
        representer.addClassTag(Asset.class, Tag.MAP);
        representer.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Yaml yaml = new Yaml(options);
        String s = yaml.dump(p1);
        System.out.println(s);

        Yaml yaml1 = new Yaml();
        StringWriter writer = new StringWriter();
        yaml1.dump(s, writer);

        // Yaml yaml = new Yaml();
        File data = new File("D://$STUDY/qsone-app/src/main/resources/assets1.yml");
        FileOutputStream file = new FileOutputStream(data);
        FilterOutputStream filter = new FilterOutputStream(file);
        byte b[] = s.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        file.close();

        Yaml yaml2 = new Yaml();
        InputStream inputStream = new FileInputStream("D://$STUDY/qsone-app/src/main/resources/assets.yml");
        System.out.println(inputStream);
        Asset assetRead = yaml2.loadAs(inputStream, Asset.class);
        System.out.println("assetRead = " + assetRead.getChildren().get(0).getAssetName());
    }
}