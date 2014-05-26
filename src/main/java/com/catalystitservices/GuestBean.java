package com.catalystitservices;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "guest")
@ViewScoped
public class GuestBean implements Serializable {

    private static final long serialVersionUID = 1L;
    transient int i;
    transient int nbGuest;
    long guestId;
    String name;
    String address;
    int qty;
    boolean editable = false;
    
    
    private static final ArrayList<Guest> guestList = 
            new ArrayList<Guest>(Arrays.asList(
     
            new Guest(10L, "guest1", "guest1@email.com"),
            new Guest(10L, "guest2", "guest1@email.com"),
            new Guest(10L, "guest3", "guest1@email.com"),
            new Guest(10L, "guest4", "guest1@email.com"),
            new Guest(10L, "guest5", "guest1@email.com"),
            new Guest(10L, "guest6", "guest1@email.com")
        ));
    
    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    public final int getNbGuest() {
        nbGuest = guestList.size();
        return nbGuest;
    }

    public long getGuestId() {
        return guestId;
    }
    
    public void setGuestId(final long guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(final boolean editable) {
        this.editable = editable;
    }

    public String saveAction() {
       //get all existing value but set "editable" to false 
        for (Guest guest : guestList) {
            guest.setEditable(false);
        }

        //return to current page
        return null;

    }

    public String editAction(final Guest guest) {

        guest.setEditable(true);
        return null;
    }

    public String addAction() {

        final Guest guest = new Guest(this.guestId, this.name, this.address);
        guestList.add(guest);
        setEditable(false);
        setGuestId(0);
        setName(null);
        setAddress(null);
        return null;
    }

    public String deleteAction(final Guest guest) {

        guestList.remove(guest);
        return null;
    }

    public static class Guest {

        long guestId;
        String name;
        String address;
        boolean editable;

        public Guest(final long guestId, final String name, final String address) {
            this.guestId = guestId;
            this.name = name;
            this.address = address;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(final boolean editable) {
            this.editable = editable;
        }

        public long getGuestId() {
            return guestId;
        }

        public void setGuestId(final long guestId) {
            this.guestId = guestId;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(final String address) {
            this.address = address;
        }

     }
}