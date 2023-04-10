package com.example.project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class modelclass
{
    private SimpleStringProperty mhotel;
    private SimpleStringProperty mflight;
    private SimpleStringProperty mcar;
    private SimpleIntegerProperty bookingid1;
    private SimpleIntegerProperty rooms1;
    private SimpleIntegerProperty totalpassenger1;
    private SimpleStringProperty name1;

    public modelclass(int a,String b,String mhotel,int r, String mflight, String mcar,int t) {
        this.bookingid1=new SimpleIntegerProperty(a);
        this.name1 = new SimpleStringProperty(b);
        this.mhotel = new SimpleStringProperty(mhotel);
        this.rooms1=new SimpleIntegerProperty(r);
        this.mflight = new SimpleStringProperty(mflight);
        this.mcar = new SimpleStringProperty(mcar);
        this.totalpassenger1=new SimpleIntegerProperty(t);
    }

    public String getMhotel() {
        return mhotel.get();
    }

    public SimpleStringProperty mhotelProperty() {
        return mhotel;
    }

    public void setMhotel(String mhotel) {
        this.mhotel.set(mhotel);
    }

    public String getMflight() {
        return mflight.get();
    }

    public SimpleStringProperty mflightProperty() {
        return mflight;
    }

    public void setMflight(String mflight) {
        this.mflight.set(mflight);
    }

    public String getMcar() {
        return mcar.get();
    }

    public SimpleStringProperty mcarProperty() {
        return mcar;
    }

    public void setMcar(String mcar) {
        this.mcar.set(mcar);
    }

    public int getBookingid1() {
        return bookingid1.get();
    }

    public SimpleIntegerProperty bookingid1Property() {
        return bookingid1;
    }

    public void setBookingid1(int bookingid1) {
        this.bookingid1.set(bookingid1);
    }

    public int getRooms1() {
        return rooms1.get();
    }

    public SimpleIntegerProperty rooms1Property() {
        return rooms1;
    }

    public void setRooms1(int rooms1) {
        this.rooms1.set(rooms1);
    }

    public int getTotalpassenger1() {
        return totalpassenger1.get();
    }

    public SimpleIntegerProperty totalpassenger1Property() {
        return totalpassenger1;
    }

    public void setTotalpassenger1(int totalpassenger1) {
        this.totalpassenger1.set(totalpassenger1);
    }

    public String getName1() {
        return name1.get();
    }

    public SimpleStringProperty name1Property() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1.set(name1);
    }
}
