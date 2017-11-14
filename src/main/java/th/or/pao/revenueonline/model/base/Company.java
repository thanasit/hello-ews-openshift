package th.or.pao.revenueonline.model.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import th.or.pao.revenueonline.model.enumeration.CompanyType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COMPANY")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String name;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "TAX_PAYER")
    private String taxPayer;

    @Column(name = "COM_REGISTRATION_CER")
    private String comRegistrationCer;

    @Column(name = "COMPANY_TYPE")
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;

    @Column(name = "ADDRESS_LINE2")
    private String addressLine2;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getTaxPayer() {
        return taxPayer;
    }

    public void setTaxPayer(String taxPayer) {
        this.taxPayer = taxPayer;
    }

    public String getComRegistrationCer() {
        return comRegistrationCer;
    }

    public void setComRegistrationCer(String comRegistrationCer) {
        this.comRegistrationCer = comRegistrationCer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branchName='" + branchName + '\'' +
                ", taxPayer='" + taxPayer + '\'' +
                ", comRegistrationCer='" + comRegistrationCer + '\'' +
                ", companyType=" + companyType +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", province=" + province +
                '}';
    }
}
