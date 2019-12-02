package projectnew;

public class CalcDetails {
	
	private double gweight,n;
	private int type_ind;
	private int ack_ind;
	private int pay=17;
	private int quo;
	
	public CalcDetails(double w,int t_ind,int a_ind) {
	
		gweight=w;
		type_ind=t_ind;
		ack_ind=a_ind;
		
	}
	
	public double Payment()
	{
		switch(type_ind) 
		{	
			case 0:
				break;
			
			case 1:
				n=gweight;
			
				quo=(int)n/20;
			
				if(0<(n%20)&&(n%20)<20)
					quo+=1;
			
				pay+=quo*5;
				break;
			
			case 2:
				n=gweight;
				quo=(int)n/500;
			
				if(0<(n%500)&&(n%500)<500)
					quo+=1;
			
				pay+=quo*19;
					break;				
		}
		if(ack_ind==1)
			pay+=3;
		else
			;
		return pay;
	}
}