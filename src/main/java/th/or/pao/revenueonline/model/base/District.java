package th.or.pao.revenueonline.model.base;

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
@Table(name = "DISTRICT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class District implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DISTRICT", nullable = false)
    private String districtName;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonBackReference(value = "subDistricts")
    private List<SubDistrict> subDistricts;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonBackReference(value = "postalCodes")
    private List<PostalCode> postalCodes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<SubDistrict> getSubDistricts() {
        return subDistricts;
    }

    public void setSubDistricts(List<SubDistrict> subDistricts) {
        this.subDistricts = subDistricts;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<PostalCode> getPostalCodes() {
        return postalCodes;
    }

    public void setPostalCodes(List<PostalCode> postalCodes) {
        this.postalCodes = postalCodes;
    }

    @Override
    public String toString() {
        return "District{" +
                "districtId=" + id +
                ", code='" + code + '\'' +
                ", districtName='" + districtName + '\'' +
                ", isActive=" + isActive +
                ", province=" + province +
                ", subDistricts=" + subDistricts +
                ", postalCodes=" + postalCodes +
                '}';
    }
}
