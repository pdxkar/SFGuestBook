package com.catalystitservices;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.RequestScoped;
import com.catalystitservices.guest.model.Guest;
import com.catalystitservices.guest.bo.GuestBo;

@ManagedBean(name = "guest")
@ViewScoped
public class GuestBean implements Serializable {
	
	//DI via Spring
	GuestBo guestBo;

    private static final long serialVersionUID = 1L;
    transient int i;
    transient int nbGuest;
    long guestId;
    String name;
    String address;
    int qty;
    boolean editable = false;
   
    public List<Guest> getGuestList() {
        return guestBo.findAllGuest();
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
    
    public void setGuestBo(GuestBo guestBo) {
    	  this.guestBo = guestBo;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(final boolean editable) {
        this.editable = editable;
    }

    public String saveAction() {
       //get all existing value but set "editable" to false 
        for (Guest guest : getGuestList()) {
            guest.setEditable(false);
        }

        //return to current page
        return null;

    }

    public String editAction(final Guest guest) {

        guest.setEditable(true);
        return null;
    }

    public String addGuest(){
    	Guest guest = new Guest();
    	guest.setName(getName());
    	guest.setAddress(getAddress());
    	guestBo.addGuest(guest);
    	clearForm();
    	return "";
    }
    
    //clear form values
    private void clearForm(){
    	setName("");
    	setAddress("");
    }

    public String deleteAction(final Guest guest) {

        //guestList.remove(guest);
        return null;
    }

}