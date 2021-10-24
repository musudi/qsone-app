package au.com.qsone.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Asset implements Serializable {

    private Long assetId;
    private int assetLevel;
    private String assetName;
    private Asset assetParent;
    private List<Asset> children = new ArrayList<>();

    public Stream<Asset> flattened() {
        if (children != null) {
            return Stream.concat(Stream.of(this), children.stream().flatMap(Asset::flattened));
        }
        return null;
    }

}
