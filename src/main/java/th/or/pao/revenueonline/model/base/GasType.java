package th.or.pao.revenueonline.model.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "GAS_TYPE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GasType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "GAS_TYPE_NAME", nullable = false)
    private String gasTypeName;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

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

    public String getGasTypeName() {
        return gasTypeName;
    }

    public void setGasTypeName(String gasTypeName) {
        this.gasTypeName = gasTypeName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "GasType{" +
                "gasTypeId=" + id +
                ", code='" + code + '\'' +
                ", gasTypeName='" + gasTypeName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
