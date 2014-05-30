package com.catalystitservices.guest.bo.impl;
 
import java.util.List;
import com.catalystitservices.guest.bo.GuestBo;
import com.catalystitservices.guest.dao.GuestDao;
//import com.catalystitservices.guest.model.Guest;
 
public class GuestBoImpl implements GuestBo{
 
	GuestDao guestDao;
 
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}
 
//	public void addGuest(Guest guest){
//		guestDao.addGuest(guest);
// 
//	}
 
//	public List<Guest> findAllGuest(){
//		return guestDao.findAllGuest();
//	}
	
	public void addGuest(com.catalystitservices.GuestBean.Guest guest){
		guestDao.addGuest(guest);
 
	}
	
	public List<com.catalystitservices.GuestBean.Guest> findAllGuest(){
		return guestDao.findAllGuest();
	}
}