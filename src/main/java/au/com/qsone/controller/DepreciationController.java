package au.com.qsone.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;

import au.com.qsone.MediaTypeUtils;
import au.com.qsone.model.DepreciationRequest;
import au.com.qsone.service.DepreciationService;

@RestController
@RequestMapping(path = "/qsoneapp")
public class DepreciationController {

    String pathSeparator = File.pathSeparator;

    private static final String DEFAULT_FILE_NAME = "DepreciationSummary.pdf";

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private DepreciationService service;

    @PreAuthorize("hasRole('CONTRACTOR') OR hasRole('MANAGER') OR hasRole('ADMIN')")
    @PostMapping(value = "/calculateAndDownloadDepreciationSummary")
    public ResponseEntity<InputStreamResource> calculateAndDownloadDepreciationSummary(
            @RequestBody DepreciationRequest depreciationRequest) {

        File file = null;
        try {
            service.calclulatePrimeCost(depreciationRequest);

            MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, DEFAULT_FILE_NAME);

            file = new File(DEFAULT_FILE_NAME);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            return ResponseEntity.ok()
                    // Content-Disposition
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                    // Content-Type
                    .contentType(mediaType)
                    // Contet-Length
                    .contentLength(file.length()) //
                    .body(resource);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }

        return null;
    }
}
