package ua.lviv.iot.uklon.model.entity;

import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.annotation.PrimaryKey;
import ua.lviv.iot.uklon.model.annotation.Table;

@Table(name = "driver")
public class Driver {

  @PrimaryKey
  @Column(name = "id")
  private Integer id;

  @Column(name = "tel_num")
  private String telNum;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surName;

  @Column(name = "count_of_orders")
  private Integer countOfOrders;

  @Column(name = "drive_license")
  private String driveLicense;

  @Column(name = "rate")
  private Float rate;

  public Driver() {
  }

  public Driver(Integer id, String telNum, String name, String surName, Integer countOfOrders, String driveLicense,
      Float rate) {
    super();
    this.id = id;
    this.telNum = telNum;
    this.name = name;
    this.surName = surName;
    this.countOfOrders = countOfOrders;
    this.driveLicense = driveLicense;
    this.rate = rate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTelNum() {
    return telNum;
  }

  public void setTelNum(String telNum) {
    this.telNum = telNum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public Integer getCountOfOrders() {
    return countOfOrders;
  }

  public void setCountOfOrders(Integer countOfOrders) {
    this.countOfOrders = countOfOrders;
  }

  public String getDriveLicense() {
    return driveLicense;
  }

  public void setDriveLicense(String driveLicense) {
    this.driveLicense = driveLicense;
  }

  public Float getRate() {
    return rate;
  }

  public void setRate(Float rate) {
    this.rate = rate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((countOfOrders == null) ? 0 : countOfOrders.hashCode());
    result = prime * result + ((driveLicense == null) ? 0 : driveLicense.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((rate == null) ? 0 : rate.hashCode());
    result = prime * result + ((surName == null) ? 0 : surName.hashCode());
    result = prime * result + ((telNum == null) ? 0 : telNum.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Driver other = (Driver) obj;
    if (countOfOrders == null) {
      if (other.countOfOrders != null)
        return false;
    } else if (!countOfOrders.equals(other.countOfOrders))
      return false;
    if (driveLicense == null) {
      if (other.driveLicense != null)
        return false;
    } else if (!driveLicense.equals(other.driveLicense))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (rate == null) {
      if (other.rate != null)
        return false;
    } else if (!rate.equals(other.rate))
      return false;
    if (surName == null) {
      if (other.surName != null)
        return false;
    } else if (!surName.equals(other.surName))
      return false;
    if (telNum == null) {
      if (other.telNum != null)
        return false;
    } else if (!telNum.equals(other.telNum))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Driver [id=" + id + ", telNum=" + telNum + ", name=" + name + ", surName=" + surName + ", countOfOrders="
        + countOfOrders + ", driveLicense=" + driveLicense + ", rate=" + rate + "]";
  }

}
