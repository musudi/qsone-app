package au.com.qsone.mapper;

import au.com.qsone.entity.Property;
import au.com.qsone.entity.Property.PropertyBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-24T12:15:07+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 14.0.1 (Oracle Corporation)"
)
public class PropertyMapperImpl implements PropertyMapper {

    @Override
    public Property dtoToEntity(au.com.qsone.model.Property source) {
        if ( source == null ) {
            return null;
        }

        PropertyBuilder property = Property.builder();

        property.additionalExpenses( source.getAdditionalExpenses() );
        property.comments( source.getComments() );
        property.constructionEnd( source.getConstructionEnd() );
        property.constructionStart( source.getConstructionStart() );
        property.dateOfContractExchange( source.getDateOfContractExchange() );
        property.dateSettlement( source.getDateSettlement() );
        property.email( source.getEmail() );
        property.firstLeaseDate( source.getFirstLeaseDate() );
        property.firstTaxableEndDate( source.getFirstTaxableEndDate() );
        property.forAndBehalfOfOwner( source.getForAndBehalfOfOwner() );
        property.legalCosts( source.getLegalCosts() );
        property.mobile( source.getMobile() );
        property.nameOfAuthorizedPerson( source.getNameOfAuthorizedPerson() );
        property.originalBuildingCost( source.getOriginalBuildingCost() );
        property.owner( source.getOwner() );
        property.phone( source.getPhone() );
        property.propertyType( source.getPropertyType() );
        property.purchasePrice( source.getPurchasePrice() );
        property.stampDuty( source.getStampDuty() );

        return property.build();
    }

    @Override
    public au.com.qsone.model.Property entityToDto(Property destination) {
        if ( destination == null ) {
            return null;
        }

        au.com.qsone.model.Property property = new au.com.qsone.model.Property();

        property.setAdditionalExpenses( destination.getAdditionalExpenses() );
        property.setComments( destination.getComments() );
        property.setConstructionEnd( destination.getConstructionEnd() );
        property.setConstructionStart( destination.getConstructionStart() );
        property.setDateOfContractExchange( destination.getDateOfContractExchange() );
        property.setDateSettlement( destination.getDateSettlement() );
        property.setEmail( destination.getEmail() );
        property.setFirstLeaseDate( destination.getFirstLeaseDate() );
        property.setFirstTaxableEndDate( destination.getFirstTaxableEndDate() );
        property.setForAndBehalfOfOwner( destination.getForAndBehalfOfOwner() );
        property.setLegalCosts( destination.getLegalCosts() );
        property.setMobile( destination.getMobile() );
        property.setNameOfAuthorizedPerson( destination.getNameOfAuthorizedPerson() );
        property.setOriginalBuildingCost( destination.getOriginalBuildingCost() );
        property.setOwner( destination.getOwner() );
        property.setPhone( destination.getPhone() );
        property.setPropertyType( destination.getPropertyType() );
        property.setPurchasePrice( destination.getPurchasePrice() );
        property.setStampDuty( destination.getStampDuty() );

        return property;
    }
}
