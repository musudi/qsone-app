package au.com.qsone.model;

import lombok.Data;

@Data
public class AddressModel {

    private String flatNumber;
    private String streeName;
    private String suburb;
    private String state;
    private String postcode;
    private String country;

}
