package au.com.qsone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.qsone.model.Property;
import au.com.qsone.service.PropertyService;

@RestController
@RequestMapping(path = "/qsoneapp")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PreAuthorize("hasRole('CONTRACTOR') OR hasRole('MANAGER') OR hasRole('ADMIN')")
    @GetMapping(value = "/getAllProperties")
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok().body(propertyService.listProperties());
    }

    @PreAuthorize("hasRole('MANAGER') OR hasRole('ADMIN')")
    @PostMapping(value = "/saveProperty")
    public ResponseEntity<Property> saveProperty(Property property) {
        return ResponseEntity.ok().body(propertyService.saveProperty(property));
    }
}
