package ua.lviv.iot.uklon.model.entity;

import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.annotation.PrimaryKey;
import ua.lviv.iot.uklon.model.annotation.Table;

@Table(name = "adress")
public class Adress {

  @PrimaryKey
  @Column(name = "id")
  private Integer id;

  @Column(name = "streets_id")
  private Integer streetsId;

  @Column(name = "house_number")
  private Integer houseNumber;

  @Column(name = "house_letter")
  private String houseLetter;

  @Column(name = "city_id")
  private Integer cityId;

  public Adress() {
  }

  public Adress(Integer id, Integer streetsId, Integer houseNumber, String houseLetter, Integer cityId) {
    super();
    this.id = id;
    this.streetsId = streetsId;
    this.houseNumber = houseNumber;
    this.houseLetter = houseLetter;
    this.cityId = cityId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getStreetsId() {
    return streetsId;
  }

  public void setStreetsId(Integer streetsId) {
    this.streetsId = streetsId;
  }

  public Integer getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(Integer houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getHouseLetter() {
    return houseLetter;
  }

  public void setHouseLetter(String houseLetter) {
    this.houseLetter = houseLetter;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
    result = prime * result + ((houseLetter == null) ? 0 : houseLetter.hashCode());
    result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((streetsId == null) ? 0 : streetsId.hashCode());
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
    Adress other = (Adress) obj;
    if (cityId == null) {
      if (other.cityId != null)
        return false;
    } else if (!cityId.equals(other.cityId))
      return false;
    if (houseLetter == null) {
      if (other.houseLetter != null)
        return false;
    } else if (!houseLetter.equals(other.houseLetter))
      return false;
    if (houseNumber == null) {
      if (other.houseNumber != null)
        return false;
    } else if (!houseNumber.equals(other.houseNumber))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (streetsId == null) {
      if (other.streetsId != null)
        return false;
    } else if (!streetsId.equals(other.streetsId))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Adress [id=" + id + ", streetsId=" + streetsId + ", houseNumber=" + houseNumber + ", houseLetter="
        + houseLetter + ", cityId=" + cityId + "]";
  }

}
