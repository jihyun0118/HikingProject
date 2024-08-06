package com.jenncontrollers;
import java.time.LocalDate;
/*
 * class Hike creates getters and setters to be used in the 
 * ReservationControllerServlet.java class
 * 
 * 
 * */
public class Hike {
    private String hikingPath;
    private String hikingDuration;
    private LocalDate param3;
    private String param4;
    private String param5;
    private boolean isGoodDate = true;
    

    public Hike() {
    }

    public Hike(String hikingPath, String hikingDuration, LocalDate param3, String param4, String param5) {
        this.hikingPath = hikingPath;
        this.hikingDuration = hikingDuration;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
    }
    
    public String getParam5()
    {
    	return param5;
    }
    
    public void setParam5(String param5)
    {
    	this.param5 = param5;
    }
    
    public String getParam1() {
        return hikingPath;
    }

    public void setParam1(String hikingPath) {
        this.hikingPath = hikingPath;
    }

    public String getParam2() {
        return hikingDuration;
    }

    public void setParam2(String hikingDuration) {
        this.hikingDuration = hikingDuration;
    }

    public LocalDate getParam3() {
        return param3;
    }

    public void setParam3(LocalDate param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }
}// end Hike.java