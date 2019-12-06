package com.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CourseListener implements ServletRequestAttributeListener  {
	@Override
    public void attributeAdded(ServletRequestAttributeEvent event)  { 
        System.out.println("attribute added.");
    }
	@Override
    public void attributeRemoved(ServletRequestAttributeEvent event)  { 
        System.out.println("attribute removed");
    }
	@Override
    public void attributeReplaced(ServletRequestAttributeEvent event)  { 
        System.out.println("attribute replace");
    }


	
}
