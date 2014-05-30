package com.catalystitservices;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.RequestScoped;

import com.catalystitservices.guest.bo.GuestBo;

@ManagedBean(name = "guest")
@ViewScoped
public class GuestBean implements Serializable {
	
	//DI via Spring
	GuestBo guestBo;

    private static final long serialVersionUID = 1L;
    transient int i;
    transient int nbGuest;
    long guestId;
    String name;
    String address;
    int qty;
    boolean editable = false;
    
    private static ArrayList<com.catalystitservices.GuestBean.Guest> guestList;  //Guest = com.catalystitservices.GuestBean.Guest
    
    
/*    private static final ArrayList<Guest> guestList = 
            new ArrayList<Guest>(Arrays.asList(
     
            new Guest(10L, "guest1", "guest1@email.com"),
            new Guest(10L, "guest2", "guest2@email.com"),
            new Guest(10L, "guest3", "guest3@email.com"),
            new Guest(10L, "guest4", "guest4@email.com"),
            new Guest(10L, "guest5", "guest5@email.com"),
            new Guest(10L, "guest6", "guest6@email.com")
        ));*/
    
    public ArrayList<Guest> getGuestList() {  //Guest = com.catalystitservices.GuestBean.Guest
    	List<com.catalystitservices.GuestBean.Guest> guestListFromDB = guestBo.findAllGuest(); // guestBo.findAllGuest(); is List<GuestBean.Guest>
    	ArrayList<com.catalystitservices.GuestBean.Guest> guestArrayListFromDB = new ArrayList<com.catalystitservices.GuestBean.Guest>(guestListFromDB);
    	setGuestList(guestArrayListFromDB);
    	System.out.println("getGuestList()");
        //return guestList;
    	int sizeOfGuestArrayList = guestArrayListFromDB.size();
    	for(int i = 0; i < sizeOfGuestArrayList; i++){
        	System.out.println("guestArrayListFromDB.get(i) = " + guestArrayListFromDB.get(i));
    	}

    	return guestArrayListFromDB;
    }
    
    public void setGuestList(ArrayList<Guest> guestList){
    	System.out.println("setGuestList()");
    	GuestBean.guestList = guestList;
    }

    public final int getNbGuest() {
        nbGuest = guestList.size();
        return nbGuest;
    }

    public long getGuestId() {
        return guestId;
    }
    
    public void setGuestId(final long guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(final boolean editable) {
    	System.out.println("setEditable in GuestBean class");
        this.editable = editable;
    }

    public GuestBo getGuestBo() {
		return guestBo;
	}

	public void setGuestBo(GuestBo guestBo) {
		this.guestBo = guestBo;
	}

	public String saveAction() {
		System.out.println("saveAction()");
       //get all existing value but set "editable" to false 
        for (Guest guest : guestList) {
            guest.setEditable(false);
        }

        //return to current page
        return null;

    }

    public String editAction(final com.catalystitservices.GuestBean.Guest guest) {
    	//if default.xhtml calls this one, there's a runtime error indicating that editAction(com.catalystitservices.guest.model.Guest guest) can't be found
		    	String x = "hellow";
    	System.out.println(x);
    	System.out.println(guest);
        guest.setEditable(true);
        return null;
    }
    
//    public String editAction(final com.catalystitservices.guest.model.Guest guest) {
//    	//if default.xhtml calls this one, there's no runtime error, but the row doesn't show as editable either.
//    	String x = "hellow";
//System.out.println(x);
// 		System.out.println("editAction com.catalystitservices.guest.model.Guest");
//         guest.setEditable(true);
//         return null;
//     }

    public String addAction() {
    	System.out.println("addAction");
        final Guest guest = new Guest(this.guestId, this.name, this.address);
        guestList.add(guest);
        setEditable(false);
        setGuestId(0);
        setName(null);
        setAddress(null);
        return null;
    }

    public String deleteAction(final Guest guest) {
    	System.out.println("deleteAction");
        guestList.remove(guest);
        return null;
    }

    public static class Guest {

        long guestId;
        String name;
        String address;
        boolean editable;
        
        protected Guest(){
//        	int sizeOfGuestList = GuestBean.guestList.size();
        	System.out.println("in default Guest constructor");
//        	for(int i = 0; i < sizeOfGuestList; i++){
//        		System.out.println("GuestBean.guestList.get(i)" + GuestBean.guestList.get(i));
//        	}

        }

        public Guest(final long guestId, final String name, final String address) {
            this.guestId = guestId;
            this.name = name;
            this.address = address;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(final boolean editable) {
        	System.out.println("setEditable in inner Guest class");
            this.editable = editable;
        }

        public long getGuestId() {
            return guestId;
        }

        public void setGuestId(final long guestId) {
            this.guestId = guestId;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(final String address) {
            this.address = address;
        }

     }
}