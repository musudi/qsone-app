package au.com.qsone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "flatNumber", nullable = false)
    private String flatNumber;
    @Column(name = "streeName", nullable = false)
    private String streeName;
    @Column(name = "suburb", nullable = false)
    private String suburb;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "postcode", nullable = false)
    private String postcode;
    @Column(name = "country", nullable = false)
    private String country;

}
