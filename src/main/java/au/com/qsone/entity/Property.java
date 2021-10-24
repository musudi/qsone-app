package au.com.qsone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PROPERTY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "owner", nullable = false)
    private String owner;
    @Column(name = "phone", nullable = true)
    private String phone;
    @Column(name = "mobile", nullable = false)
    private String mobile;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "propertyType", nullable = false)
    private String propertyType;
    @OneToMany(targetEntity = Address.class)
    private List addresslist;
    @Column(name = "purchasePrice", nullable = true)
    private BigDecimal purchasePrice;
    @Column(name = "stampDuty", nullable = true)
    private BigDecimal stampDuty;
    @Column(name = "legalCosts", nullable = true)
    private BigDecimal legalCosts;
    @Column(name = "additionalExpenses", nullable = true)
    private BigDecimal additionalExpenses;
    @Column(name = "originalBuildingCost", nullable = true)
    private BigDecimal originalBuildingCost;
    @Column(name = "forAndBehalfOfOwner", nullable = true)
    private String forAndBehalfOfOwner;
    @Column(name = "nameOfAuthorizedPerson", nullable = true)
    private String nameOfAuthorizedPerson;
    @Column(name = "comments", nullable = true)
    private String comments;

    @Column(name = "constructionStart", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate constructionStart;

    @Column(name = "constructionEnd", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate constructionEnd;

    @Column(name = "dateOfContractExchange", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfContractExchange;

    @Column(name = "dateSettlement", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateSettlement;

    @Column(name = "firstLeaseDate", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate firstLeaseDate;

    @Column(name = "firstTaxableEndDate", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate firstTaxableEndDate;
}
