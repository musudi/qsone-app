package au.com.qsone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.qsone.mapper.PropertyMapper;
import au.com.qsone.repository.PropertyRepository;
import au.com.qsone.model.Property;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    /**
     * This method retuns all the Properties defined in the Yaml definition.
     * 
     * @return Property
     */
    public List<Property> listProperties() {
        log.info("Fetching all properties from the db");

        List<au.com.qsone.entity.Property> properties = propertyRepository.findAll();
        if (!properties.isEmpty()) {
            return properties.stream().map(p -> PropertyMapper.INSTANCE.entityToDto(p)).collect(Collectors.toList());
        }

        return new ArrayList<Property>();
    }

    /**
     * This method retuns specific Property based on the PropertyId.
     * 
     * @return Property
     */
    public Property getPropertyById(final long id) {
        return null;
    }

    /**
     * This method persists/merges the property.
     * 
     * @return Property
     */
    public Property saveProperty(final Property property) {
        au.com.qsone.entity.Property entity = propertyRepository.save(PropertyMapper.INSTANCE.dtoToEntity(property));
        return PropertyMapper.INSTANCE.entityToDto(entity);
    }

}
