package th.or.pao.revenueonline.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import th.or.pao.revenueonline.model.base.TaxConfiguration;
import th.or.pao.revenueonline.model.enumeration.Month;
import th.or.pao.revenueonline.model.enumeration.TaxStatus;
import th.or.pao.revenueonline.model.enumeration.TaxType;

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
import java.sql.Timestamp;

@Entity
@Table(name = "TAX")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tax implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TAX_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaxStatus taxStatus;

    @Column(name = "MONTH", nullable = false)
    @Enumerated(EnumType.STRING)
    private Month month;

    @Column(name = "YEAR")
    private String year;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TAX_CIGARETTE_ID")
    private TaxCigarette taxCigarette;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TAX_DETAIL_ID", insertable = false, updatable = false)
    private TaxDetail taxDetail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TAX_HOTEL_ATTACHED_ID")
    private TaxHotelAttached taxHotelAttached;

    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount;

    @Column(name = "TOTAL_AMOUNT_TH")
    private String totalAmountTH;

    @Column(name = "TOTAL_AMOUNT_HOTEL")
    private Double totalAmountHotel;

    @Column(name = "SIGN_DATE")
    private Timestamp signDate;

    @Column(name = "PAID_DATE")
    private Timestamp paidDate;

    @Column(name = "NUMBER_OF_ATTACHMENT")
    private Integer numberOfAttachment;

    @Column(name = "NUMBER_OF_PERSON")
    private Integer numberOfPerson;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TAX_CONFIGURATION_ID")
    private TaxConfiguration taxConfiguration;

    @Column(name = "TAX_TYPE")
    @Enumerated(EnumType.STRING)
    private TaxType taxType;

    @Column(name = "NUMBER_OF_ADDITIONAL_TAX")
    private Integer numberOfAdditionalTax;

    @Column(name = "DATE_FROM")
    private Timestamp dateFrom;

    @Column(name = "DATE_TO")
    private Timestamp dateTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaxStatus getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(TaxStatus taxStatus) {
        this.taxStatus = taxStatus;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public TaxCigarette getTaxCigarette() {
        return taxCigarette;
    }

    public void setTaxCigarette(TaxCigarette taxCigarette) {
        this.taxCigarette = taxCigarette;
    }

    public TaxDetail getTaxDetail() {
        return taxDetail;
    }

    public void setTaxDetail(TaxDetail taxDetail) {
        this.taxDetail = taxDetail;
    }

    public TaxHotelAttached getTaxHotelAttached() {
        return taxHotelAttached;
    }

    public void setTaxHotelAttached(TaxHotelAttached taxHotelAttached) {
        this.taxHotelAttached = taxHotelAttached;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalAmountTH() {
        return totalAmountTH;
    }

    public void setTotalAmountTH(String totalAmountTH) {
        this.totalAmountTH = totalAmountTH;
    }

    public Double getTotalAmountHotel() {
        return totalAmountHotel;
    }

    public void setTotalAmountHotel(Double totalAmountHotel) {
        this.totalAmountHotel = totalAmountHotel;
    }

    public Timestamp getSignDate() {
        return signDate;
    }

    public void setSignDate(Timestamp signDate) {
        this.signDate = signDate;
    }

    public Timestamp getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Timestamp paidDate) {
        this.paidDate = paidDate;
    }

    public Integer getNumberOfAttachment() {
        return numberOfAttachment;
    }

    public void setNumberOfAttachment(Integer numberOfAttachment) {
        this.numberOfAttachment = numberOfAttachment;
    }

    public Integer getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(Integer numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public TaxConfiguration getTaxConfiguration() {
        return taxConfiguration;
    }

    public void setTaxConfiguration(TaxConfiguration taxConfiguration) {
        this.taxConfiguration = taxConfiguration;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public Integer getNumberOfAdditionalTax() {
        return numberOfAdditionalTax;
    }

    public void setNumberOfAdditionalTax(Integer numberOfAdditionalTax) {
        this.numberOfAdditionalTax = numberOfAdditionalTax;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "taxId=" + id +
                ", taxStatus=" + taxStatus +
                ", month=" + month +
                ", year='" + year + '\'' +
                ", taxCigarette=" + taxCigarette +
                ", taxDetail=" + taxDetail +
                ", taxHotelAttached=" + taxHotelAttached +
                ", totalAmount=" + totalAmount +
                ", totalAmountTH='" + totalAmountTH + '\'' +
                ", totalAmountHotel=" + totalAmountHotel +
                ", signDate=" + signDate +
                ", paidDate=" + paidDate +
                ", numberOfAttachment=" + numberOfAttachment +
                ", numberOfPerson=" + numberOfPerson +
                ", taxConfiguration=" + taxConfiguration +
                ", taxType=" + taxType +
                ", numberOfAdditionalTax=" + numberOfAdditionalTax +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
