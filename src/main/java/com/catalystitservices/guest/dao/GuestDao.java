package com.catalystitservices.guest.dao;
 
import java.util.List;
//import com.catalystitservices.guest.model.Guest;
 
public interface GuestDao{
 
//	void addGuest(Guest guest);
 
//	List<Guest> findAllGuest();
	
	void addGuest(com.catalystitservices.GuestBean.Guest guest);
	
	List<com.catalystitservices.GuestBean.Guest> findAllGuest();
 
}