package au.com.qsone.depreciable.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Asset implements Serializable {

    private String id;
    private int level;
    private String assetName;
    private Asset parent;
    private List<Asset> children = new ArrayList<>();

}
