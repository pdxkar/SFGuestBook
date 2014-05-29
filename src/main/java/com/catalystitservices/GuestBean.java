package com.catalystitservices;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.RequestScoped;
import com.catalystitservices.guest.model.Guest;
import com.catalystitservices.guest.bo.GuestBo;
import javax.faces.context.FacesContext;  


public class GuestBean implements Serializable {  
	  
    private final static String[] names;  
  
    private final static String[] addresses;  
  
    private List<Guest> guestList;  
  
    static {  
        names = new String[10];  
        names[0] = "Black";  
        names[1] = "White";  
        names[2] = "Green";  
        names[3] = "Red";  
        names[4] = "Blue";  
        names[5] = "Orange";  
        names[6] = "Silver";  
        names[7] = "Yellow";  
        names[8] = "Brown";  
        names[9] = "Maroon";  
  
        addresses = new String[10];  
        addresses[0] = "Mercedes";  
        addresses[1] = "BMW";  
        addresses[2] = "Volvo";  
        addresses[3] = "Audi";  
        addresses[4] = "Renault";  
        addresses[5] = "Opel";  
        addresses[6] = "Volkswagen";  
        addresses[7] = "Chrysler";  
        addresses[8] = "Ferrari";  
        addresses[9] = "Ford";  
    }  
  
    public GuestBean() {  
        guestList = new ArrayList<Guest>();  
  
        populateRandomGuests(guestList, 9);  
    }  
  
    private void populateRandomGuests(List<Guest> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add(new Guest(getRandomName(), getRandomAddress()));  
    }  
  
    public List<Guest> getGuestList() {  
        return guestList;  
    }  
  
    private String getRandomName() {  
        return names[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomAddress() {  
        return addresses[(int) (Math.random() * 10)];  
    }  
  
  
    public String[] getAddresses() {  
        return addresses;  
    }  
  
    public String[] getNames() {  
        return names;  
    }  
}  



//import org.primefaces.examples.domain.Car;

//@ManagedBean(name = "guest")
//@ViewScoped
//public class GuestBean implements Serializable {
//	
//	static //DI via Spring
//	GuestBo guestBo;
//
//    private static final long serialVersionUID = 1L;
//    transient int i;
//    transient int nbGuest;
//    long guestId;
//    String name;
//    String address;
//    int qty;
//    boolean editable = false;
//   
//    static public List<Guest> getGuestList() {
//        return guestBo.findAllGuest();
//    }
//
//    public long getGuestId() {
//        return guestId;
//    }
//    
//    public void setGuestId(final long guestId) {
//        this.guestId = guestId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(final String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(final String address) {
//        this.address = address;
//    }
//    
//    public void setGuestBo(GuestBo guestBo) {
//    	  this.guestBo = guestBo;
//    }
//
//    public boolean isEditable() {
//        return editable;
//    }
//
//    public void setEditable(final boolean editable) {
//        this.editable = editable;
//    }
//
//    public String saveAction() {
//       //get all existing value but set "editable" to false 
//        for (Guest guest : getGuestList()) {
//            guest.setEditable(false);
//        }
//
//        //return to current page
//        return null;
//
//    }
//
//    public String editAction(final Guest guest) {
//
//        guest.setEditable(true);
//        return null;
//    }
//
//    public String addGuest(){
//    	Guest guest = new Guest();
//    	guest.setName(getName());
//    	guest.setAddress(getAddress());
//    	guestBo.addGuest(guest);
//    	clearForm();
//    	return "";
//    }
//    
//    //clear form values
//    private void clearForm(){
//    	setName("");
//    	setAddress("");
//    }
//
//    public String deleteAction(final Guest guest) {
//
//        //guestList.remove(guest);
//        return null;
//    }
//
//}