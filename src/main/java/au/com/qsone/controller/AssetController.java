package au.com.qsone.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.qsone.service.AssetService;
import au.com.qsone.model.Asset;

@RestController
@RequestMapping(path = "/qsoneapp")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PreAuthorize("hasRole('CONTRACTOR') OR hasRole('MANAGER') OR hasRole('ADMIN')")
    @GetMapping(value = "/getAllAssets")
    public ResponseEntity<Asset> getAllAssets() throws FileNotFoundException {
        return ResponseEntity.ok().body(assetService.getAllAssets());
    }

    @PreAuthorize("hasRole('CONTRACTOR') OR hasRole('MANAGER') OR hasRole('ADMIN')")
    @GetMapping(value = "/getAssetById")
    public ResponseEntity<Asset> getAssetById() {

        return null;
    }

    @PreAuthorize("hasRole('CONTRACTOR') OR hasRole('MANAGER') OR hasRole('ADMIN')")
    @PostMapping(value = "/saveAsset")
    public ResponseEntity<Asset> saveAsset() {
        return null;

    }

}
