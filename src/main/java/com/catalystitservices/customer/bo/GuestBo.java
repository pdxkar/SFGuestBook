package com.catalystitservices.customer.bo;
 
import java.util.List;
 

import com.catalystitservices.customer.model.Guest;
 
public interface GuestBo{
 
	void addGuest(Guest guest);
 
	List<Guest> findAllGuest();
 
}