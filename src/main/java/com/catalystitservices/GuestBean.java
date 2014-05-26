package com.catalystitservices;

import java.io.Serializable;
import java.util.List;

import com.catalystitservices.customer.bo.GuestBo;
import com.catalystitservices.customer.model.Guest;

public class GuestBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//DI via Spring
	GuestBo guestBo;
	
	public String name;
	public String address;
	
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
 
	//get all customer data from database
	public List<Guest> getGuestList(){
		return guestBo.findAllGuest();
	}
	
	//add a new customer data into database
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
	
}
