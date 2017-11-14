package th.or.pao.revenueonline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TAX_CIGARETTE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxCigarette implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "TOTAL_PACK")
    private Integer totalPack;

    @Column(name = "TOTAL_ROLL")
    private Integer totalRoll;

    @OneToMany(mappedBy = "taxCigarette", cascade = CascadeType.ALL)
    @JsonBackReference(value = "taxList")
    private List<Tax> taxList;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TAX_CIGARETTE_ATTACHED_ID")
    private TaxCigaretteAttached taxCigaretteAttached;

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

    public Integer getTotalPack() {
        return totalPack;
    }

    public void setTotalPack(Integer totalPack) {
        this.totalPack = totalPack;
    }

    public Integer getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(Integer totalRoll) {
        this.totalRoll = totalRoll;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }

    public TaxCigaretteAttached getTaxCigaretteAttached() {
        return taxCigaretteAttached;
    }

    public void setTaxCigaretteAttached(TaxCigaretteAttached taxCigaretteAttached) {
        this.taxCigaretteAttached = taxCigaretteAttached;
    }

    @Override
    public String toString() {
        return "TaxCigarette{" +
                "taxCigaretteId=" + id +
                ", number=" + number +
                ", totalPack=" + totalPack +
                ", totalRoll=" + totalRoll +
                ", taxList=" + taxList +
                ", taxCigaretteAttached=" + taxCigaretteAttached +
                '}';
    }
}
