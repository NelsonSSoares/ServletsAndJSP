package com.nelson.trainings.servlets.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	System.out.println("Resquest Destroyed");
    }

    public void requestInitialized(ServletRequestEvent arg0)  { 
    	System.out.println("Resquest Created");
    }
	
}
