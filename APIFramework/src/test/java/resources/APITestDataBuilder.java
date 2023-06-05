package resources;

import pojo.AddLeadAPI;

public class APITestDataBuilder {
	AddLeadAPI addlead = new AddLeadAPI();

	public AddLeadAPI AddLeadPayload(String Firstname,String Lastname,String phonemobile,String renewal,String Loanamounttaken)
	{
		addlead.setFirst_name(Firstname);
		addlead.setLast_name(Lastname);
		addlead.setPhone_mobile(phonemobile);
		addlead.setIs_renewal(renewal);
		addlead.setMerchant_name_c("youtubes");
		addlead.setPickup_appointment_city_c("BANGALORE");
		addlead.setLoan_amount_c(Loanamounttaken);
		addlead.setAvg_sales_per_month_c("34343");
		addlead.setLead_source("Marketing");
		addlead.setIndicative_deal_amount("36473827");
		addlead.setDigital("no");
		return addlead;
		
		
	}
}
