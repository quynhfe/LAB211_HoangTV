/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;

import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class FlightInformation {

    private String flightNum, seatNum;
    private LocalDateTime timePickUp;

    public FlightInformation() {
        this.flightNum = "";
        this.seatNum = "";
        this.timePickUp = LocalDateTime.now();
    }

    public FlightInformation(String flightNum, String seatNum, LocalDateTime timePickUp) {
        this.flightNum = flightNum;
        this.seatNum = seatNum;
        this.timePickUp = timePickUp;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public LocalDateTime getTimePickUp() {
        return timePickUp;
    }

    public void setTimePickUp(LocalDateTime timePickUp) {
        this.timePickUp = timePickUp;
    }

    @Override
    public String toString() {
        return flightNum + " - " + seatNum + " - " + timePickUp;
    }
    
    
    
    
}
