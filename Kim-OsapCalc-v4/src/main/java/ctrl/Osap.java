package ctrl;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loan;


/**
 * Servlet implementation class Osap
 */
@WebServlet({"/Osap","/Osap/*"})
public class Osap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Osap() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
		 
	 }
    @Override
	 public void init(ServletConfig config) throws ServletException {
	 super.init(config);
	 ServletContext context = getServletContext();
	  //the context object is initialized with data from web.xml
	 String appName = context.getInitParameter("applicationName");
	 //get the default osap values from the context
	 String interest = context.getInitParameter("interest");
	 // Instantiate Loan thought the singleton method and persist it
	 String principal = context.getInitParameter("principal");	  // Instantiate Loan object
	  Loan model=Loan.getInstance();
	  context.setAttribute("mLoan", model); 
	  
	  }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getRequestURI();
		if (path.indexOf("/Lab1")>0) {
			try {
				lab1(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {	
		Writer resOut = response.getWriter();
		ServletContext context= this.getServletContext();
		Loan mLoan = (Loan) context.getAttribute("mLoan");
	     
	     String principal = request.getParameter("principal");
	     String period = request.getParameter("period");
	     String interest = request.getParameter("interest");
	     
	     if (principal == null) {
	        principal = context.getInitParameter("principal");
	     }
	     if (period == null) {
	      period = context.getInitParameter("period");
	     }
	     if (interest == null) {
	      interest = context.getInitParameter("Interest");
	     }
	     
	    
	     
	     
	     
	     
	     
		double monthly=0; String error = null;
		try {
			monthly = mLoan.computePayment(principal,period,interest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			error = e.getMessage();
		}
		
		String monthlyPaymentFormatted = ""+ monthly;
	   //save the result in the session object
	     request.getSession().setAttribute("payment", monthlyPaymentFormatted);
	     request.getSession().setAttribute("principal", principal);
	     request.getSession().setAttribute("interest", interest);
	     request.getSession().setAttribute("period", period);
	     
	   
	   //decide what to return, based on the parameter “out”
	     
	     if (request.getParameter("out") != null && request.getParameter("out").equals("html")) {
	  	   String target = "/ResultsView.jsp";
	  	   request.getRequestDispatcher(target).forward(request, response);
	  	   }
	  	   
	  	   if (request.getParameter("out") != null && request.getParameter("out").equals("text")&& request.getRequestURI().indexOf("Ajax") == -1) {
	  			   //return the text, as in Lab 1 ( here I have a private method, textView, that creates the response)
	  		   if (error != null) {
	  			   resOut.append(error);
	  		   }else {
	  		  
	  			resOut.write(textView(principal, interest, period, monthlyPaymentFormatted));
	  		   }
	  		
	  			   }
	  			   if (request.getParameter("out") == null && request.getRequestURI().indexOf("Ajax") == -1){
	  			   //if there is no parameter “out”, then, by default, return text as in out=text, to preserve Lab 1 functionality;
	  				   resOut.write(textView(principal, interest, period, monthlyPaymentFormatted));
	  			   }
	  	  	   if (request.getPathInfo() != null && request.getRequestURI().indexOf("Ajax") >= 0) {
				   response.setContentType("application/json");
				   System.out.println("Ajax call");//this is for testing at server side...
				    //here we return json data note the escape characters \”
				   resOut.append("{\"pr\":");
				   resOut.append(principal);
				   resOut.append(",\"mp\":");
				   resOut.append(monthlyPaymentFormatted);
				   resOut.append("}");
				   resOut.flush();
		}
	 }
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	private void lab1 (HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Writer resOut = response.getWriter();
		resOut.write("Hello, 4413!\n");
		System.out.println("Hello, Got a GET request from Osap!");
		 String clientIP = request.getRemoteAddr();
		 resOut.write("Client IP: " + clientIP + "\n");
		 int clientPort = request.getRemotePort();
		 if (clientIP != null) {
		 resOut.write("Client Port: " + clientPort + "\nThis IP has been flagged!\n");
		 }
		 resOut.write("Client Protocol: " + request.getProtocol() + "\n");
		 resOut.write("Client Method: " + request.getMethod() + "\n");
		 String clientQueryString = request.getQueryString();
		 String foo = request.getParameter("foo");
		 resOut.write("Query String: foo=" + foo + "\n");
		 resOut.write("Query Param foo=" + foo + "\n");
		 resOut.write("Request URI: " + request.getRequestURI() + "\n");
		 resOut.write("Request Servlet Path: " + request.getServletPath());
		 ServletContext context= this.getServletContext();
		 resOut.write("\n---- Info from context object ----\n");
		 resOut.write("Application Name = " + context.getInitParameter("applicationName") + "\n");
		 resOut.write("Context Path = " + context.getContextPath() + "\nReal Path of Osap\nservlet=" + context.getRealPath("Osap") + "\n");
	     resOut.write("Applicant Name = " + context.getInitParameter("applicantName") + "\n");
	     
	     
	     String principal = request.getParameter("principal");
	     String period = request.getParameter("period");
	     String interest = request.getParameter("interest");
	     
	     if (principal == null) {
	        principal = context.getInitParameter("principal");
	     }
	     if (period == null) {
	      period = context.getInitParameter("period");
	     }
	     if (interest == null) {
	      interest = context.getInitParameter("Interest");
	     }
	     
	    
	    Loan mLoan = (Loan) context.getAttribute("mLoan");
	    String monthlypayment= ""+mLoan.computePayment(principal,period,interest);
		
	     
	     
	     
	     resOut.write(textView(principal, interest, period, monthlypayment));
	     
	     
	   }
	 
	
	
	private String textView (String principal, String interest, String period , String monthly) {
		String text = "---- Monthly Payments ----\nBased on Principal = " + principal + " Period = " + period + " Interest: " + interest+ "\nMonthly Payments: " + monthly + "\n";
		return text;
	}
	 
	
	

}



