package by.trofimov.jdbc.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static by.trofimov.jdbc.util.Constant.SEPARATOR;

public class Ticket implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String passengerNo;
    private String passengerName;
    private Long flightId;
    private String seatNo;
    private BigDecimal cost;

    public Ticket() {
    }

    public Ticket(Long id, String passengerNo, String passengerName, Long flightId, String seatNo, BigDecimal cost) {
        this.id = id;
        this.passengerNo = passengerNo;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.seatNo = seatNo;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengerNo, passengerName, flightId, seatNo, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(passengerNo, ticket.passengerNo) && Objects.equals(passengerName, ticket.passengerName) && Objects.equals(flightId, ticket.flightId) && Objects.equals(seatNo, ticket.seatNo) && Objects.equals(cost, ticket.cost);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + SEPARATOR + id + SEPARATOR + passengerNo + SEPARATOR + passengerName +
               SEPARATOR + flightId + SEPARATOR + seatNo + SEPARATOR + cost;
    }

}
