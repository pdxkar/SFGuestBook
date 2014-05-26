package com.catalystitservices.customer.dao.impl;
 
import java.util.Date;
import java.util.List;
 


import com.catalystitservices.customer.dao.GuestDao;
import com.catalystitservices.customer.model.Guest;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
public class GuestDaoImpl extends 
       HibernateDaoSupport implements GuestDao{
 
	public void addGuest(Guest guest){
 
		guest.setCreatedDate(new Date());
		getHibernateTemplate().save(guest);
 
	}
 
	public List<Guest> findAllGuest(){
 
		return getHibernateTemplate().find("from Guest");
 
	}
}