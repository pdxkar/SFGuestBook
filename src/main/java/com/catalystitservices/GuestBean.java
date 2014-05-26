package com.catalystitservices;

import java.io.Serializable;
import java.util.List;

import com.catalystitservices.guest.bo.GuestBo;
import com.catalystitservices.guest.model.Guest;

public class GuestBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//DI via Spring
	GuestBo guestBo;
	
	public String name;
	public String address;
	public boolean editable;
	
	//get all guest data from database
	public List<Guest> getGuestList(){
		return guestBo.findAllGuest();
	}
	
	//add a new guest data into database
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
	
	public String editAction(Guest guest){
		guest.setEditable(true);
		return null;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGuestBo(GuestBo guestBo) {
		this.guestBo = guestBo;
	}
 

	
}
