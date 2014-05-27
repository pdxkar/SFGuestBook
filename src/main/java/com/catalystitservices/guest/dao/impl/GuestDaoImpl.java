package com.catalystitservices.guest.dao.impl;
 
import java.util.Date;
import java.util.List;
import com.catalystitservices.guest.dao.GuestDao;
import com.catalystitservices.guest.model.Guest;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
public class GuestDaoImpl extends 
       HibernateDaoSupport implements GuestDao{
 
	public void addGuest(Guest guest){

		getHibernateTemplate().save(guest);
 
	}
 
	public List<Guest> findAllGuest(){
		return getHibernateTemplate().find("from Guest");
	}
}