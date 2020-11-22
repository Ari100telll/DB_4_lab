package ua.lviv.iot.uklon.model.entity;

import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.annotation.PrimaryKey;
import ua.lviv.iot.uklon.model.annotation.Table;

@Table(name = "vehicle")
public class Vehicle {

  @PrimaryKey
  @Column(name = "id")
  private Integer id;

  @Column(name = "driver_id")
  private Integer driverId;

  @Column(name = "number")
  private String number;

  @Column(name = "model")
  private String model;

  @Column(name = "places")
  private Integer places;

  @Column(name = "trunk_size_in_liter")
  private Integer trunkSizeInLiter;

  @Column(name = "color")
  private String color;

  @Column(name = "insurance_policy")
  private String insurancePolicy;

  public Vehicle() {
  }

  public Vehicle(Integer id, Integer driverId, String number, String model, Integer places, Integer trunkSizeInLiter,
      String color, String insurancePolicy) {
    super();
    this.id = id;
    this.driverId = driverId;
    this.number = number;
    this.model = model;
    this.places = places;
    this.trunkSizeInLiter = trunkSizeInLiter;
    this.color = color;
    this.insurancePolicy = insurancePolicy;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDriverId() {
    return driverId;
  }

  public void setDriverId(Integer driverId) {
    this.driverId = driverId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getPlaces() {
    return places;
  }

  public void setPlaces(Integer places) {
    this.places = places;
  }

  public Integer getTrunkSizeInLiter() {
    return trunkSizeInLiter;
  }

  public void setTrunkSizeInLiter(Integer trunkSizeInLiter) {
    this.trunkSizeInLiter = trunkSizeInLiter;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getInsurancePolicy() {
    return insurancePolicy;
  }

  public void setInsurancePolicy(String insurancePolicy) {
    this.insurancePolicy = insurancePolicy;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    result = prime * result + ((driverId == null) ? 0 : driverId.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((insurancePolicy == null) ? 0 : insurancePolicy.hashCode());
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result = prime * result + ((places == null) ? 0 : places.hashCode());
    result = prime * result + ((trunkSizeInLiter == null) ? 0 : trunkSizeInLiter.hashCode());
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
    Vehicle other = (Vehicle) obj;
    if (color == null) {
      if (other.color != null)
        return false;
    } else if (!color.equals(other.color))
      return false;
    if (driverId == null) {
      if (other.driverId != null)
        return false;
    } else if (!driverId.equals(other.driverId))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (insurancePolicy == null) {
      if (other.insurancePolicy != null)
        return false;
    } else if (!insurancePolicy.equals(other.insurancePolicy))
      return false;
    if (model == null) {
      if (other.model != null)
        return false;
    } else if (!model.equals(other.model))
      return false;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    if (places == null) {
      if (other.places != null)
        return false;
    } else if (!places.equals(other.places))
      return false;
    if (trunkSizeInLiter == null) {
      if (other.trunkSizeInLiter != null)
        return false;
    } else if (!trunkSizeInLiter.equals(other.trunkSizeInLiter))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Vehicle [id=" + id + ", driverId=" + driverId + ", number=" + number + ", model=" + model + ", places="
        + places + ", trunkSizeInLiter=" + trunkSizeInLiter + ", color=" + color + ", insurancePolicy="
        + insurancePolicy + "]";
  }

}