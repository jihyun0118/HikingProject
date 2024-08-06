package com.jenncontrollers;

import java.util.*;
import java.time.*;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import com.jenncontrollers.Rates.HIKE;
/*
 * class ReservationControllerServlet is the servlet controller for the MVC project.
 * 
 * image sources: https://www.hikingproject.com/trail/7004180/the-beaten-path
 * image sources: https://www.alltrails.com/trail/us/montana/hellroaring-plateau-trail
 * image source: https://www.alltrails.com/us/new-york/gardiner
 * image source: https://www.xperiencedays.com/images/West-Forks-Guided-Hiking-Tour-XD-1587-003_700x410.jpg
 * 
 * */
//http link - http://localhost:8080/MvcHikingRate/reservations when run on localhost
@WebServlet("/Controller") 
public class Controller extends HttpServlet 
{
    public final String TEMPLATE_BASE = "/WEB-INF/jsp";
    public final String RESERVATION_FORM = TEMPLATE_BASE + "/index.jsp";
    public final String RESERVATION_SUMMARY_FORM = TEMPLATE_BASE + "/reservation-summary.jsp";

    @Override
    protected void doGet
    (
            HttpServletRequest req, HttpServletResponse resp
    ) {
        // set any necessary request attributes
        req.setAttribute("formName", "BHC Beartooth Hiking Company");

        try {
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher(RESERVATION_FORM);

            dispatcher.forward(req, resp);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost
    (
            HttpServletRequest req, HttpServletResponse resp
    ) {
        try 
        {
            /*
             * get the form variables from the client (user) through input fields on html page
             * */
            String hikingPath = req.getParameter("hikepath");
            String hikingDuration = req.getParameter("hikeduration");
            String param3 = req.getParameter("param3");
            String param4 = req.getParameter("param4");
            String param5 = req.getParameter("param5");

            boolean hasErrors = false;
            Hike model = new Hike();
            /*
             * validating correct hike with duration
             * 
             * */
            if (hikingPath.equals("GARDINER") && hikingDuration.equals("3 Days") || 
               (hikingPath.equals("GARDINER") && hikingDuration.equals("5 Days") ||
               (hikingPath.equals("HELLROARING") && hikingDuration.equals("2 Days") ||
               (hikingPath.equals("HELLROARING") && hikingDuration.equals("3 Days") ||
               (hikingPath.equals("HELLROARING") && hikingDuration.equals("4 Days") ||
               (hikingPath.equals("BEATEN") && hikingDuration.equals("5 Days") ||	
               (hikingPath.equals("BEATEN") && hikingDuration.equals("7 Days"))))))))
            {
            	 model.setParam1(hikingPath);
                 model.setParam2(hikingDuration);
            }
            else
            {
                hasErrors = true;
                req.setAttribute("param1Errors", "Error. Enter valid duration for hike.");
            }
            
            /*
             * validating input date between 2007-2040 for hike
             * 
             * */
            Double hikingCost = null;
            int durationHike = 0;
            boolean success;
            Rates rates = null;
			String hikeName;
            BookingDay startDay;
            
            /*
             * validating input date is not null
             * 
             * */

            try 
            {
                model.setParam3(LocalDate.parse(param3));
                int year = Integer.parseInt(param3.substring(0,4));
       	     	int month = Integer.parseInt(param3.substring(5,7));
       	     	int day = Integer.parseInt(param3.substring(8,10));
       	     	startDay = new BookingDay(year, month, day);
       	     	
       	     	
       	     	if (!(startDay.isValidDate()) || (startDay == null))
       	     	{
       	     		throw new Exception();
       	     	}
            }
            catch(Exception e) 
            {
                hasErrors = true;
                model.setParam3(null);
                //int year = Integer.parseInt(param3.substring(0,4));
       	     	//int month = Integer.parseInt(param3.substring(5,7));
       	     	//int day = Integer.parseInt(param3.substring(8,10));
       	     	//startDay = new BookingDay(year, month, day);
                req.setAttribute("param3Errors", "Error. Enter a date between <2007-2040> in season.");
            }
    		
            try
            {
            	int year = Integer.parseInt(param3.substring(0,4));
       	     	int month = Integer.parseInt(param3.substring(5,7));
       	     	int day = Integer.parseInt(param3.substring(8,10));
       	     	startDay = new BookingDay(year, month, day);
       	     	if (startDay.isValidDate())
       	     	{
	    			if (hikingDuration.equals("2 Days"))
	    			{
	    				durationHike = 2;
	    			}
	    			if (hikingDuration.equals("3 Days"))
	    			{
	    				durationHike = 3;
	    			}
	    			if (hikingDuration.equals("4 Days"))
	    			{
	    				durationHike = 4;
	    			}
	    			if (hikingDuration.equals("5 Days"))
	    			{
	    				durationHike = 5;
	    			}
	    			if (hikingDuration.equals("7 Days"))
	    			{
	    				durationHike = 7;
	    			}
	
	    			if (hikingPath.equals("GARDINER"))
	    			{
	    				rates = new Rates(Rates.HIKE.GARDINER);
	    				hikeName = "GARDINER";
	    			}
	    			else if (hikingPath.equals("HELLROARING"))
	    			{
	    				rates = new Rates(Rates.HIKE.HELLROARING);
	    				hikeName = "HELLROARING";
	    			}
	    			else if (hikingPath.equals("BEATEN"))
	    			{
	    				rates = new Rates(Rates.HIKE.BEATEN);
	    				hikeName = "BEATEN";
	    			}
	    			rates.setBeginDate(startDay);
	    			success = rates.setDuration(durationHike);
	    			if (rates.isValidDates() && success)
	    			{
	    				hikingCost = rates.getCost();
	    			}
	    			else if (!rates.isValidDates())
	    			{
	    				throw new Exception();
	    			}
       	     	} 
            }
       	    catch(Exception e)
       	    {
       	    	hasErrors = true;
       	    	req.setAttribute("param2Errors", "Hike out of season/Enter valid duration for hike.");
       	    }
            
            /*
             * validating length of name for client booking hike
             * 
             * */
            if (param4.length() >= 2) 
            {
                model.setParam4(param4);
            } 
            else
            {
                hasErrors = true;
                model.setParam4(null);
                req.setAttribute("param4Errors", "Enter minimum 2 characters for name.");
            }

            model.setParam5(param5);
            int people = 0;
            if (param5.equals("1 Person"))
            {
            	people = 1;
            }
            else if (param5.equals("2 People"))
            {
            	people = 2;
            }
            else if (param5.equals("3 People"))
            {
            	people = 3;
            }
            else if (param5.equals("4 People"))
            {
            	people = 4;
            }
            else if (param5.equals("5 People"))
            {
            	people = 5;
            }
            else if (param5.equals("6 People"))
            {
            	people = 6;
            }
            else if (param5.equals("7 People"))
            {
            	people = 7;
            }
            else if (param5.equals("8 People"))
            {
            	people = 8;
            }
            else if (param5.equals("9 People"))
            {
            	people = 9;
            }
            else if (param5.equals("10 People"))
            {
            	people = 10;
            }
            
            
            req.setAttribute("model", model);

            if(hasErrors) 
            {
                doGet(req, resp);
                return;
            }

            hikingCost = people*hikingCost;
            
	    	req.setAttribute("hikingCost", hikingCost);
	    	


            RequestDispatcher dispatcher = req.getRequestDispatcher(RESERVATION_SUMMARY_FORM);
            dispatcher.forward(req, resp);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
} // end class ReservationControllerServlet
