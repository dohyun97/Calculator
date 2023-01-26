package listener;


import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MaxPrincipal implements HttpSessionAttributeListener {
	
      double max = 0.0;
    /**
     * Default constructor. 
     */
    public MaxPrincipal() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	handleEvent(arg0);
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	handleEvent(arg0);
    	
    }
    
    void handleEvent(HttpSessionBindingEvent event) {
    	
    	double DPrincipal=0.0;  double Dinterest =0; double Dperiod = 0;
    	if (event.getName().equals("principal")) {
    	   try{
    		    DPrincipal = Double.parseDouble((String) event.getSession().getAttribute("principal"));
    		    Dinterest = Double.parseDouble((String) event.getSession().getAttribute("interest"));
    		    Dperiod = Double.parseDouble((String) event.getSession().getAttribute("period"));
    	   
    	     }catch (Exception e){
    		
    	  }
    	  if (max < DPrincipal) {
    		   max = DPrincipal;
    		   double ML = Math.round((DPrincipal * Dinterest/100/12) / ( 1-(Math.pow((1+Dinterest/100/12), -Dperiod)))*10)/10.0;
    		   event.getSession().getServletContext().setAttribute("ML", ML);
    	    }
     		event.getSession().getServletContext().setAttribute("mPrincipal", max);
   		

    		
    	}
    
    }

}
