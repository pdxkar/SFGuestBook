package com.catalystitservices.customer.bo.impl;
 
import java.util.List;
 



import com.catalystitservices.customer.bo.GuestBo;
import com.catalystitservices.customer.dao.GuestDao;
import com.catalystitservices.customer.model.Guest;
 
public class GuestBoImpl implements GuestBo{
 
	GuestDao guestDao;
 
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}
 
	public void addGuest(Guest guest){
 
		guestDao.addGuest(guest);
 
	}
 
	public List<Guest> findAllGuest(){
 
		return guestDao.findAllGuest();
	}
}