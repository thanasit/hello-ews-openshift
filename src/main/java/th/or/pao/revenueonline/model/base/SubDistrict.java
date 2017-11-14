package th.or.pao.revenueonline.model.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SUB_DISTRICT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubDistrict implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "SUB_DISTRICT", nullable = false)
    private String subDistrictName;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DISTRICT_ID")
    private District district;

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

    public String getSubDistrictName() {
        return subDistrictName;
    }

    public void setSubDistrictName(String subDistrictName) {
        this.subDistrictName = subDistrictName;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "SubDistrict{" +
                "subDistrictId=" + id +
                ", code='" + code + '\'' +
                ", subDistrictName='" + subDistrictName + '\'' +
                ", isActive=" + isActive +
                ", district=" + district +
                '}';
    }
}
