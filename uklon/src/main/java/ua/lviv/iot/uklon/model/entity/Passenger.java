package ua.lviv.iot.uklon.model.entity;

import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.annotation.PrimaryKey;
import ua.lviv.iot.uklon.model.annotation.Table;

@Table(name = "passenger")
public class Passenger {

  @PrimaryKey
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surName;

  @Column(name = "tel_num")
  private String telNum;

  @Column(name = "credit_card_id")
  private String creditCardId;

  @Column(name = "rate")
  private Float rate;

  public Passenger() {
  }

  public Passenger(Integer id, String name, String surName, String telNum, String creditCardId, Float rate) {
    super();
    this.id = id;
    this.name = name;
    this.surName = surName;
    this.telNum = telNum;
    this.creditCardId = creditCardId;
    this.rate = rate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getTelNum() {
    return telNum;
  }

  public void setTelNum(String telNum) {
    this.telNum = telNum;
  }

  public String getCreditCardId() {
    return creditCardId;
  }

  public void setCreditCardId(String creditCardId) {
    this.creditCardId = creditCardId;
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
    result = prime * result + ((creditCardId == null) ? 0 : creditCardId.hashCode());
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
    Passenger other = (Passenger) obj;
    if (creditCardId == null) {
      if (other.creditCardId != null)
        return false;
    } else if (!creditCardId.equals(other.creditCardId))
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
    return "Passenger [id=" + id + ", name=" + name + ", surName=" + surName + ", telNum=" + telNum + ", creditCardId="
        + creditCardId + ", rate=" + rate + "]";
  }

}