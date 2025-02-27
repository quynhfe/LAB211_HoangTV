/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;


import java.util.Date;


/**
 *
 * @author ADMIN
 */
public class Reservation {
    private String id, cusName, phoneNume;
    private int roomNum;
    private Date bookingDate;
    private FlightInformation flightInformation;

    public Reservation() {
        this.id = "";
        this.cusName="";
        this.phoneNume = "";
        this.roomNum = 0;
    }

    public Reservation(String id, String cusName, String phoneNume, int roomNum, Date bookingDate, FlightInformation flightInformation) {
        this.id = id;
        this.cusName = cusName;
        this.phoneNume = phoneNume;
        this.roomNum = roomNum;
        this.bookingDate = bookingDate;
        this.flightInformation = flightInformation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhoneNume() {
        return phoneNume;
    }

    public void setPhoneNume(String phoneNume) {
        this.phoneNume = phoneNume;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }

    @Override
    public String toString() {
        return id + " - " + cusName + " - " + phoneNume + " - " + roomNum + " - " + bookingDate + " - " + flightInformation.toString();
    }

 
}
