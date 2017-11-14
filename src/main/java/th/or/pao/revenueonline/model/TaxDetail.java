package th.or.pao.revenueonline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "TAX_DETAIL")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "COMPANY_TYPE")
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "QTY_KILO")
    private Double qtyKilo;

    @Column(name = "QTY_PACK")
    private Integer qtyPack;

    @Column(name = "QTY_ROLL")
    private Integer qtyRoll;

    @Column(name = "AMOUNT")
    private Double amount;

    @OneToMany(mappedBy = "taxDetail", cascade = CascadeType.ALL)
    @JsonBackReference(value = "taxList")
    private List<Tax> taxList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getQtyKilo() {
        return qtyKilo;
    }

    public void setQtyKilo(Double qtyKilo) {
        this.qtyKilo = qtyKilo;
    }

    public Integer getQtyPack() {
        return qtyPack;
    }

    public void setQtyPack(Integer qtyPack) {
        this.qtyPack = qtyPack;
    }

    public Integer getQtyRoll() {
        return qtyRoll;
    }

    public void setQtyRoll(Integer qtyRoll) {
        this.qtyRoll = qtyRoll;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }

    @Override
    public String toString() {
        return "TaxDetail{" +
                "taxDetailId=" + id +
                ", number=" + number +
                ", companyType=" + companyType +
                ", detail='" + detail + '\'' +
                ", qtyKilo=" + qtyKilo +
                ", qtyPack=" + qtyPack +
                ", qtyRoll=" + qtyRoll +
                ", amount=" + amount +
                ", taxList=" + taxList +
                '}';
    }
}
