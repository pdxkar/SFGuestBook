package com.catalystitservices.guest.bo;
 
import java.util.List;
//import com.catalystitservices.guest.model.Guest;
 
public interface GuestBo{
 
//	void addGuest(Guest guest);
 
//	List<Guest> findAllGuest();
	
	void addGuest(com.catalystitservices.GuestBean.Guest guest);
	
	List<com.catalystitservices.GuestBean.Guest> findAllGuest();
 
}

