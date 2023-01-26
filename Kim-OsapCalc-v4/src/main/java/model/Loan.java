package model;

public class Loan {

	private static Loan instance;
	public static Loan getInstance(){
	if (instance==null) {
	instance =new Loan();
	}
	return instance;
	}
	//not the constructor is private
	private Loan() {
	 }
	
	public double principalDo (String principal) throws Exception{
		
		
	    	 double principalDo=  Double.parseDouble(principal);
	    	 
	       
	    if ( principalDo<0) {
			throw new Exception("Principal must be greater than 0!");
		}
		return principalDo;
	}
	public double periodDo (String period) throws Exception{
		double periodDo=  Double.parseDouble(period);
	          
	 if (periodDo<0)  {
			throw new Exception("Period must be greater than 0!");
		}
	
  	return periodDo; 
     
	}
	public double interestDo (String interest) throws Exception{
		    double interestDo=  Double.parseDouble(interest);
   	          
		 if (interestDo>=100 || interestDo<=0)  {
				throw new Exception("Interest must be greater than 0 and less than 100!");
			}
		
	    	return interestDo; 
	       
	    
	}
	public double computePayment (String principal, String period,String interest) throws Exception {
		
			double interestDo = interestDo(interest);
			double principalDo = principalDo(principal);
			double periodDo = periodDo(period);
			
			double monthlyPayment = Math.round((principalDo * interestDo/100/12) / ( 1-(Math.pow((1+interestDo/100/12), -periodDo)))*10)/10.0;
		    return monthlyPayment;
		
	}
	
	  
	}
	

