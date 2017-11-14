package th.or.pao.revenueonline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import th.or.pao.revenueonline.model.enumeration.StayType;

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
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "TAX_HOTEL_ATTACHED")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxHotelAttached implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "CHECKIN_DATE")
    private Timestamp checkInDate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STAY_TYPE")
    @Enumerated(EnumType.STRING)
    private StayType stayType;

    @Column(name = "TOTAL_HOUR_STAY")
    private Double totalHourStay;

    @Column(name = "TOTAL_DAY_STAY")
    private Integer totalDayStay;

    @Column(name = "ROOM_RATE")
    private Double roomRate;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "FEE")
    private Double fee;

    @Column(name = "REMARK")
    private String remark;

    @OneToMany(mappedBy = "taxHotelAttached", cascade = CascadeType.ALL)
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

    public Timestamp getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Timestamp checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StayType getStayType() {
        return stayType;
    }

    public void setStayType(StayType stayType) {
        this.stayType = stayType;
    }

    public Double getTotalHourStay() {
        return totalHourStay;
    }

    public void setTotalHourStay(Double totalHourStay) {
        this.totalHourStay = totalHourStay;
    }

    public Integer getTotalDayStay() {
        return totalDayStay;
    }

    public void setTotalDayStay(Integer totalDayStay) {
        this.totalDayStay = totalDayStay;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }

    @Override
    public String toString() {
        return "TaxHotelAttached{" +
                "taxHotelAttachedId=" + id +
                ", number=" + number +
                ", checkInDate=" + checkInDate +
                ", name='" + name + '\'' +
                ", stayType=" + stayType +
                ", totalHourStay=" + totalHourStay +
                ", totalDayStay=" + totalDayStay +
                ", roomRate=" + roomRate +
                ", amount=" + amount +
                ", fee=" + fee +
                ", remark='" + remark + '\'' +
                ", taxList=" + taxList +
                '}';
    }
}
