package com.catalystitservices.customer.dao;
 
import java.util.List;
 

import com.catalystitservices.customer.model.Guest;
 
public interface GuestDao{
 
	void addGuest(Guest guest);
 
	List<Guest> findAllGuest();
 
}