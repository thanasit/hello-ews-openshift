package th.or.pao.revenueonline.model.base;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import th.or.pao.revenueonline.model.Tax;
import th.or.pao.revenueonline.model.enumeration.CompanyType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TAX_CONFIGURATION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxConfiguration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TAX_RATE", nullable = false)
    private Double taxRate;

    @Column(name = "TAX_RATE_TYPE")
    @Enumerated(EnumType.STRING)
    private CompanyType taxRateType;

    @OneToMany(mappedBy = "taxConfiguration", cascade = CascadeType.ALL)
    @JsonBackReference(value = "taxList")
    private List<Tax> taxList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public CompanyType getTaxRateType() {
        return taxRateType;
    }

    public void setTaxRateType(CompanyType taxRateType) {
        this.taxRateType = taxRateType;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }

    @Override
    public String toString() {
        return "TaxConfiguration{" +
                "taxConfigurationId=" + id +
                ", taxRate=" + taxRate +
                ", taxRateType=" + taxRateType +
                ", taxList=" + taxList +
                '}';
    }
}
