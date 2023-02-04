package org.rohit.employee.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.util.Objects;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Double Open;
    private Double Close;
    private Double High;
    private Double Low;
    private Double Adj_Close;
    private Integer volume;
    private String Date;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(id, employee.id)) return false;
        if (!Objects.equals(Open, employee.Open)) return false;
        if (!Objects.equals(Close, employee.Close)) return false;
        if (!Objects.equals(High, employee.High)) return false;
        if (!Objects.equals(Low, employee.Low)) return false;
        if (!Objects.equals(Adj_Close, employee.Adj_Close)) return false;
        if (!Objects.equals(volume, employee.volume)) return false;
        return Objects.equals(Date, employee.Date);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (Open != null ? Open.hashCode() : 0);
        result = 31 * result + (Close != null ? Close.hashCode() : 0);
        result = 31 * result + (High != null ? High.hashCode() : 0);
        result = 31 * result + (Low != null ? Low.hashCode() : 0);
        result = 31 * result + (Adj_Close != null ? Adj_Close.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (Date != null ? Date.hashCode() : 0);
        return result;
    }

    public Employee(Integer id, Integer volume, String date, Double open, Double close, Double high, Double low, Double adj_Close) {
        this.id = id;
        this.volume = volume;
        Date = date;
        Open = open;
        Close = close;
        High = high;
        Low = low;
        Adj_Close = adj_Close;
    }

    public Employee() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Double getOpen() {
        return Open;
    }

    public void setOpen(Double open) {
        Open = open;
    }

    public Double getClose() {
        return Close;
    }

    public void setClose(Double close) {
        Close = close;
    }

    public Double getHigh() {
        return High;
    }

    public void setHigh(Double high) {
        High = high;
    }

    public Double getLow() {
        return Low;
    }

    public void setLow(Double low) {
        Low = low;
    }

    public Double getAdj_Close() {
        return Adj_Close;
    }

    public void setAdj_Close(Double adj_Close) {
        Adj_Close = adj_Close;
    }



}
