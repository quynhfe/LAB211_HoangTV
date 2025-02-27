/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import validation.Validation;

/**
 *
 * @author ADMIN
 */
public class ManageRoomReservation {

    Validation v = new Validation();
    ArrayList<Reservation> reList = new ArrayList<>();

//○ ID is a 6 digits and unique
//○ customerName is alphabet and blanks
//○ phoneNumber is 12 digits
//○ roomNumber is 4 digits
//○ bookingDate must be after present
//○ timePickUp must be after present and before bookingDate
    public void add() throws ParseException {
        String id;
        do {
            id = v.getValidStringHaveNDigit("Enter id", 6, "Please enter number have 6 digits");
        } while (getReservation(id) != null);
        String cusName = v.getValidString("Enter name");
        String phoneNume = v.getValidStringHaveNDigit("Enter phone number", 12, "Phone number must have 12 digits");
        int roomNum = v.getValidNumberHaveNDigit("Enter room number", 4, "Room number must have 4 digits");
        Date bookingDate;
        do {
            bookingDate = v.getValidDate("Enter Booking Date");
        } while (bookingDate.before(new Date()));
        String flightNum = v.getValidStringHaveStartStringThenNDigit("Enter flight number", "FL", 4, "Flight number must be FLxxxx(xxxx is number 4 digits)");
        String seatNum = v.getValidStringHaveStartStringThenNDigit("Enter seat number", "A", 2, "Seat number must be Axx, xx is number 2 digits)");
        LocalDateTime timePickUp;
        do {
            timePickUp = v.getValidLocalDateTime("Enter Time pickup");
        } while (timePickUp.isBefore(LocalDateTime.now()));
        FlightInformation flightInformation = new FlightInformation(flightNum, seatNum, timePickUp);
        Reservation re = new Reservation(id, cusName, phoneNume, roomNum, bookingDate, flightInformation);
        reList.add(re);
    }

    public Reservation getReservation(String id) {
        for (Reservation re : reList) {
            if (re.getId().equalsIgnoreCase(id)) {
                return re;
            }
        }
        return null;
    }

    public void update() throws ParseException {
        String id;
        Reservation re;
        do {
            id = v.getValidStringHaveNDigit("Enter id", 6, "Please enter number have 6 digits");
            re = getReservation(id);
            if (re == null) {
                boolean choice = v.getOption("You want to find again? (Y/N):", new String[]{"Y", "N"}).equalsIgnoreCase("N");
                if (choice) {
                    return;
                }
            }
        } while (getReservation(id) == null);
        printFlight(id);
        String[] menu = new String[]{
            "Name", "Phone Number", "Room Number", "Booking Date", "Flight Number", "Seat Number", "Time Pickup", "Exit"
        };
        int choice;
        do {
             choice = v.getChoice(menu, "Update Reservation " + id);
            switch (choice) {
                case 1: {
                    String cusName = v.getValidString("Enter name");
                    re.setCusName(cusName);
                    break;
                }
                case 2: {
                    String phoneNume = v.getValidStringHaveNDigit("Enter phone number", 12, "Phone number must have 12 digits");
                    re.setPhoneNume(phoneNume);
                    break;
                }
                case 3: {
                    int roomNum = v.getValidNumberHaveNDigit("Enter room number", 4, "Room number must have 4 digits");
                    re.setRoomNum(roomNum);
                    break;
                }
                case 4: {
                    Date bookingDate;
                    do {
                        bookingDate = v.getValidDate("Enter Booking Date");
                    } while (bookingDate.after(new Date()));
                    re.setBookingDate(bookingDate);
                    break;
                }
                case 5: {
                    String flightNum = v.getValidStringHaveStartStringThenNDigit("Enter flight number", "FL", 4, "Flight number must be FLxxxx(xxxx is number 4 digits)");
                    FlightInformation f = re.getFlightInformation();
                    f.setFlightNum(flightNum);
                    re.setFlightInformation(f);
                    break;
                }
                case 6: {
                    String seatNum = v.getValidStringHaveStartStringThenNDigit("Enter seat number", "A", 2, "Seat number must be Yxx(Y is char form A to F, xx is number 2 digits)");
                    FlightInformation f = re.getFlightInformation();
                    f.setSeatNum(seatNum);
                    re.setFlightInformation(f);
                    break;
                }
                case 7: {
                    LocalDateTime timePickUp;
                    do {
                        timePickUp = v.getValidLocalDateTime("Enter Time pickup");
                    } while (timePickUp.isBefore(LocalDateTime.now()));
                    FlightInformation f = re.getFlightInformation();
                    f.setTimePickUp(timePickUp);
                    re.setFlightInformation(f);
                    break;
                }
            }
        } while (choice > 0 && choice < menu.length);
    }

    public void delete() {
        String id;
        Reservation re;
        do {
            id = v.getValidStringHaveNDigit("Enter id", 6, "Please enter number have 6 digits");
           
            //
            re = getReservation(id);
            if(re == null){
                boolean choice = v.getOption(" you want to continue? (Y/N):", new String[]{"Y","N"}).equalsIgnoreCase("N");
                if(choice) return;
            }
        } while (getReservation(id) == null);
        printFlight(id);
        boolean choice = v.getOption("Are you sure you want to delete this information? (Y/N):", new String[]{"Y", "N"}).equalsIgnoreCase("Y");
        if (choice) {
            reList.remove(re);
        }
    }

    public void printFlight(String id) {
        if (reList.isEmpty()) {
            System.out.println("Reservation is emty");
            return;
        }
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        for (Reservation re : reList) {
            if (re.getId().equalsIgnoreCase(id)) {
                System.out.println(re.toString());
                return;
            }
        }
        System.out.println("No information found");
    }

    public void printAll() {
        if (reList.isEmpty()) {
            System.out.println("Reservation is emty");
            return;
        }
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        for (Reservation re : reList) {
            System.out.println(re.toString());
        }
    }

    public void menu() throws ParseException {
        String[] menu = new String[]{
            "Create new reservation",
            "Update reservation",
            "Delete reservation",
            "Print Flight Information",
            "Print all",
            "Exit"
        };
        int choice;
        do {
            choice = v.getChoice(menu, "Reservation Management");
            switch (choice) {
                case 1: {
                    add();
                    break;
                }
                case 2: {
                    update();
                    break;
                }
                case 3: {
                    delete();
                    break;
                }
                case 4: {
                    String id;
                    Reservation re;
                    do {
                        id = v.getValidStringHaveNDigit("Enter id", 6, "Please enter number have 6 digits");
                        re = getReservation(id);
                        if (re == null) {
                            boolean notFoundAgain = v.getOption("You want to find again? (Y/N):", new String[]{"Y", "N"}).equalsIgnoreCase("N");
                            if (notFoundAgain) {
                                break;
                            }
                        }
                    } while (getReservation(id) == null);
                    if (re != null) {
                        printFlight(id);
                    }
                    break;
                }
                case 5: {
                    printAll();
                    break;
                }
            }
        } while (choice > 0 && choice < menu.length);
    }
}
