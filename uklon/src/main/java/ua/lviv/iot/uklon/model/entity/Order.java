package ua.lviv.iot.uklon.model.entity;

import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.annotation.PrimaryKey;
import ua.lviv.iot.uklon.model.annotation.Table;

@Table(name = "`order`")
public class Order {

  @PrimaryKey
  @Column(name = "id")
  private Integer id;

  @Column(name = "passenger_id")
  private Integer passengerId;

  @Column(name = "cost")
  private Integer cost;

  @Column(name = "estimated_departure_time")
  private String estimatedDepartureTime;

  @Column(name = "estimated_arrival_time")
  private String estimatedArrivalTime;

  @Column(name = "count_passangers")
  private Integer countPassangers;

  @Column(name = "paymant_type")
  private String paymantType;

  @Column(name = "order_type_id")
  private Integer orderTypeId;

  @Column(name = "adress_start_id")
  private Integer adressStartId;

  @Column(name = "adress_end_id")
  private Integer adressEndId;

  @Column(name = "vehicle_id")
  private Integer vehicleId;

  @Column(name = "order_state_id")
  private Integer orderStateId;

  public Order() {
  }

  public Order(Integer id, Integer passengerId, Integer cost, String estimatedDepartureTime,
      String estimatedArrivalTime, Integer countPassangers, String paymantType, Integer orderTypeId,
      Integer adressStartId, Integer adressEndId, Integer vehicleId, Integer orderStateId) {
    super();
    this.id = id;
    this.passengerId = passengerId;
    this.cost = cost;
    this.estimatedDepartureTime = estimatedDepartureTime;
    this.estimatedArrivalTime = estimatedArrivalTime;
    this.countPassangers = countPassangers;
    this.paymantType = paymantType;
    this.orderTypeId = orderTypeId;
    this.adressStartId = adressStartId;
    this.adressEndId = adressEndId;
    this.vehicleId = vehicleId;
    this.orderStateId = orderStateId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPassengerId() {
    return passengerId;
  }

  public void setPassengerId(Integer passengerId) {
    this.passengerId = passengerId;
  }

  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public String getEstimatedDepartureTime() {
    return estimatedDepartureTime;
  }

  public void setEstimatedDepartureTime(String estimatedDepartureTime) {
    this.estimatedDepartureTime = estimatedDepartureTime;
  }

  public String getEstimatedArrivalTime() {
    return estimatedArrivalTime;
  }

  public void setEstimatedArrivalTime(String estimatedArrivalTime) {
    this.estimatedArrivalTime = estimatedArrivalTime;
  }

  public Integer getCountPassangers() {
    return countPassangers;
  }

  public void setCountPassangers(Integer countPassangers) {
    this.countPassangers = countPassangers;
  }

  public String getPaymantType() {
    return paymantType;
  }

  public void setPaymantType(String paymantType) {
    this.paymantType = paymantType;
  }

  public Integer getOrderTypeId() {
    return orderTypeId;
  }

  public void setOrderTypeId(Integer orderTypeId) {
    this.orderTypeId = orderTypeId;
  }

  public Integer getAdressStartId() {
    return adressStartId;
  }

  public void setAdressStartId(Integer adressStartId) {
    this.adressStartId = adressStartId;
  }

  public Integer getAdressEndId() {
    return adressEndId;
  }

  public void setAdressEndId(Integer adressEndId) {
    this.adressEndId = adressEndId;
  }

  public Integer getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
  }

  public Integer getOrderStateId() {
    return orderStateId;
  }

  public void setOrderStateId(Integer orderStateId) {
    this.orderStateId = orderStateId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((adressEndId == null) ? 0 : adressEndId.hashCode());
    result = prime * result + ((adressStartId == null) ? 0 : adressStartId.hashCode());
    result = prime * result + ((cost == null) ? 0 : cost.hashCode());
    result = prime * result + ((countPassangers == null) ? 0 : countPassangers.hashCode());
    result = prime * result + ((estimatedArrivalTime == null) ? 0 : estimatedArrivalTime.hashCode());
    result = prime * result + ((estimatedDepartureTime == null) ? 0 : estimatedDepartureTime.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((orderStateId == null) ? 0 : orderStateId.hashCode());
    result = prime * result + ((orderTypeId == null) ? 0 : orderTypeId.hashCode());
    result = prime * result + ((passengerId == null) ? 0 : passengerId.hashCode());
    result = prime * result + ((paymantType == null) ? 0 : paymantType.hashCode());
    result = prime * result + ((vehicleId == null) ? 0 : vehicleId.hashCode());
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
    Order other = (Order) obj;
    if (adressEndId == null) {
      if (other.adressEndId != null)
        return false;
    } else if (!adressEndId.equals(other.adressEndId))
      return false;
    if (adressStartId == null) {
      if (other.adressStartId != null)
        return false;
    } else if (!adressStartId.equals(other.adressStartId))
      return false;
    if (cost == null) {
      if (other.cost != null)
        return false;
    } else if (!cost.equals(other.cost))
      return false;
    if (countPassangers == null) {
      if (other.countPassangers != null)
        return false;
    } else if (!countPassangers.equals(other.countPassangers))
      return false;
    if (estimatedArrivalTime == null) {
      if (other.estimatedArrivalTime != null)
        return false;
    } else if (!estimatedArrivalTime.equals(other.estimatedArrivalTime))
      return false;
    if (estimatedDepartureTime == null) {
      if (other.estimatedDepartureTime != null)
        return false;
    } else if (!estimatedDepartureTime.equals(other.estimatedDepartureTime))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (orderStateId == null) {
      if (other.orderStateId != null)
        return false;
    } else if (!orderStateId.equals(other.orderStateId))
      return false;
    if (orderTypeId == null) {
      if (other.orderTypeId != null)
        return false;
    } else if (!orderTypeId.equals(other.orderTypeId))
      return false;
    if (passengerId == null) {
      if (other.passengerId != null)
        return false;
    } else if (!passengerId.equals(other.passengerId))
      return false;
    if (paymantType == null) {
      if (other.paymantType != null)
        return false;
    } else if (!paymantType.equals(other.paymantType))
      return false;
    if (vehicleId == null) {
      if (other.vehicleId != null)
        return false;
    } else if (!vehicleId.equals(other.vehicleId))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", passengerId=" + passengerId + ", cost=" + cost + ", estimatedDepartureTime="
        + estimatedDepartureTime + ", estimatedArrivalTime=" + estimatedArrivalTime + ", countPassangers="
        + countPassangers + ", paymantType=" + paymantType + ", orderTypeId=" + orderTypeId + ", adressStartId="
        + adressStartId + ", adressEndId=" + adressEndId + ", vehicleId=" + vehicleId + ", orderStateId=" + orderStateId
        + "]";
  }

}
