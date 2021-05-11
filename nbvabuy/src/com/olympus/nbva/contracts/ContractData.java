package com.olympus.nbva.contracts;

 public class ContractData {
	
	
	private String contractID; // i=0
	private String customerID; // i=1
	private String customerName; // i=2
	private String commenceDate; // i=3
	private long term; // i=4
	private String termDate; // i=5
	private double equipRate; // i=6
	private double serviceRate; // i=7
	private String invoiceCode; // i= 25
	private String contractStatus; // i=24
	private String purOption; // i=26
	private int monthsRemain; // i=
	private int monthsDiff; // i=
	private String finalInvDueDate; // i=
	private String effectiveDate; // i=
	private String termPlusSpan; // Non-input
	
	private String customerAddr1; // i=41
	private String customerAddr2; // i=42
	private String customerAddr3; // i=43
	private String customerAttn; // i=
	private String customerCity; // i=44
	private String customerState; // i=28
	private String customerZip; // i=45
	private double buyOut;  // Non-input
	private double rollTotal; // Non-input
	private double rtnTotal;// Non-input
	private double buyTotal;// Non-input
	private String Invoice;
	private String nextAgingDate;
	private String agingDate; // i=46
	private String buyOutDate; // Non-input
	/****************************************************************************************************************************************************/
// New values
	private double contractPayment; // i=33
	private String Contract_Purchase_Option;    // i=26
	private String SapSold_to_Number;	 // i=29
	private String Term_1;	 // i=30
	private double  Yield;	 // i=34 // IRR_DEC5
	private int Procedures_to_Date;  // i=35
	private int Remaining_Procedures;	 // i=36
	private String Non_Reporting_Procedures;	 // i=38
	private String FIS_Rep; 	 // i=39
	private String purchOptDesc;
	private String term_date_1; 

	private double remainRentRec; //i=47
	
	
	// added 2021-01-29
	private double cityTaxRate; //i=48
	private double cntyTaxRate;  //i=49
	private double stateTaxRate;  //i=50
	private double transCntyTaxRate; //i=51
	private double totalTaxRate; //i=52
	
	private double buyOutWithTax; //i=53
	private double buyOutInvoiceTotal; //i=53
	
	private double paymentWtax;
	
	private double cityTaxTotal;
	private double stateTaxTotal;
	private double cntyTaxTotal;
	private double transCntyTaxTotal;
	
	/****************************************************************************************************************************************************/

	
	
	
	
	public double getRemainRentRec() {
		return remainRentRec;
	}





	public double getCityTaxTotal() {
		return cityTaxTotal;
	}





	public void setCityTaxTotal(double cityTaxTotal) {
		this.cityTaxTotal = cityTaxTotal;
	}





	public double getStateTaxTotal() {
		return stateTaxTotal;
	}





	public void setStateTaxTotal(double stateTaxTotal) {
		this.stateTaxTotal = stateTaxTotal;
	}





	public double getCntyTaxTotal() {
		return cntyTaxTotal;
	}





	public void setCntyTaxTotal(double cntyTaxTotal) {
		this.cntyTaxTotal = cntyTaxTotal;
	}





	public double getTransCntyTaxTotal() {
		return transCntyTaxTotal;
	}





	public void setTransCntyTaxTotal(double transCntyTaxTotal) {
		this.transCntyTaxTotal = transCntyTaxTotal;
	}





	public double getPaymentWtax() {
		return paymentWtax;
	}





	public void setPaymentWtax(double paymentWtax) {
		this.paymentWtax = paymentWtax;
	}





	public double getBuyOutInvoiceTotal() {
		return buyOutInvoiceTotal;
	}





	public void setBuyOutInvoiceTotal(double buyOutInvoiceTotal) {
		this.buyOutInvoiceTotal = buyOutInvoiceTotal;
	}





	public double getBuyOutWithTax() {
		return buyOutWithTax;
	}





	public void setBuyOutWithTax(double buyOutWithTax) {
		this.buyOutWithTax = buyOutWithTax;
	}





	public double getTotalTaxRate() {
		return totalTaxRate;
	}





	public void setTotalTaxRate(double totalTaxRate) {
		this.totalTaxRate = totalTaxRate;
	}





	public double getCityTaxRate() {
		return cityTaxRate;
	}





	public void setCityTaxRate(double cityTaxRate) {
		this.cityTaxRate = cityTaxRate;
	}





	public double getCntyTaxRate() {
		return cntyTaxRate;
	}





	public void setCntyTaxRate(double cntyaxRate) {
		this.cntyTaxRate = cntyaxRate;
	}





	public double getStateTaxRate() {
		return stateTaxRate;
	}





	public void setStateTaxRate(double stateTaxRate) {
		this.stateTaxRate = stateTaxRate;
	}





	public double getTransCntyTaxRate() {
		return transCntyTaxRate;
	}





	public void setTransCntyTaxRate(double transCntyTaxRate) {
		transCntyTaxRate = transCntyTaxRate;
	}





	public void setRemainRentRec(double remainRentRec) {
		this.remainRentRec = remainRentRec;
	}

	
	
	
	public String getInvoice() {
		return Invoice;
	}
	public String getSapSold_to_Number() {
		return SapSold_to_Number;
	}
	public void setSapSold_to_Number(String sapSold_to_Number) {
		SapSold_to_Number = sapSold_to_Number;
	}
	public String getPurchOptDesc() {
		return purchOptDesc;
	}
	public void setPurchOptDesc(String purchOptDesc) {
		this.purchOptDesc = purchOptDesc;
	}
	public String getTerm_date_1() {
		return term_date_1;
	}
	public void setTerm_date_1(String term_date_1) {
		this.term_date_1 = term_date_1;
	}

	public void setServiceRate(double serviceRate) {
		this.serviceRate = serviceRate;
	}
	public String getBuyOutDate() {
		return buyOutDate;
	}
	public void setBuyOutDate(String buyOutDate) {
		this.buyOutDate = buyOutDate;
	}
	public int getMonthsDiff() {
		return monthsDiff;
	}
	public void setMonthsDiff(int monthsDiff) {
		this.monthsDiff = monthsDiff;
	}
	public String getAgingDate() {
		return agingDate;
	}
	public void setAgingDate(String agingDate) {
		this.agingDate = agingDate;
	}
	public String getNextAgingDate() {
		return nextAgingDate;
	}
	public void setNextAgingDate(String nextAgingDate) {
		this.nextAgingDate = nextAgingDate;
	}
	public void setInvoice(String invoice) {
		Invoice = invoice;
	}
	
	
	public String getTermPlusSpan() {
		return termPlusSpan;
	}
	public double getRollTotal() {
		return rollTotal;
	}
	public void setRollTotal(double rollTotal) {
		this.rollTotal = rollTotal;
	}
	public double getRtnTotal() {
		return rtnTotal;
	}
	public void setRtnTotal(double rtnTotal) {
		this.rtnTotal = rtnTotal;
	}
	public double getBuyTotal() {
		return buyTotal;
	}
	public void setBuyTotal(double buyTotal) {
		this.buyTotal = buyTotal;
	}
	
	public String getCustomerZip() {
		return customerZip;
	}
	public void setCustomerZip(String customerZip) {
		this.customerZip = customerZip;
	}
	public double getBuyOut() {
		return buyOut;
	}
	public void setBuyOut(double buyOut) {
		this.buyOut = buyOut;
	}
	public String getCustomerAddr1() {
		return customerAddr1;
	}
	public void setCustomerAddr1(String customerAddr1) {
		this.customerAddr1 = customerAddr1;
	}
	public String getCustomerAddr2() {
		return customerAddr2;
	}
	public void setCustomerAddr2(String customerAddr2) {
		this.customerAddr2 = customerAddr2;
	}
	public String getCustomerAddr3() {
		return customerAddr3;
	}
	public void setCustomerAddr3(String customerAddr3) {
		this.customerAddr3 = customerAddr3;
	}
	public String getCustomerAttn() {
		return customerAttn;
	}
	public void setCustomerAttn(String customerAttn) {
		this.customerAttn = customerAttn;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerState() {
		return customerState;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public void setTermPlusSpan(String termPlusSpan) {
		this.termPlusSpan = termPlusSpan;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	
	public String getFinalInvDueDate() {
		return finalInvDueDate;
	}

	public void setFinalInvDueDate(String finalInvDueDate) {
		this.finalInvDueDate = finalInvDueDate;
	}
	
	
	public String getPurOption() {
		return purOption;
	}
	
	public int getMonthsRemain() {
		return monthsRemain;
	}
	public void setMonthsRemain(int monthsRemain) {
		this.monthsRemain = monthsRemain;
	}
	public void setPurOption(String purOption) {
		this.purOption = purOption;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getContractID() {
		return contractID;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCommenceDate() {
		return commenceDate;
	}
	public void setCommenceDate(String commenceDate) {
		this.commenceDate = commenceDate;
	}
	public long getTerm() {
		return term;
	}
	public void setTerm(long term) {
		this.term = term;
	}
	public String getTermDate() {
		return termDate;
	}
	public void setTermDate(String termDate) {
		this.termDate = termDate;
	}
	public double getEquipRate() {
		return equipRate;
	}
	public void setEquipRate(double equipRate) {
		this.equipRate = equipRate;
	}
	public double getServiceRate() {
		return serviceRate;
	}
	
	public double getContractPayment() {
		return contractPayment;
	}
	public void setContractPayment(double contractPayment) {
		this.contractPayment = contractPayment;
	}
	public String getContract_Purchase_Option() {
		return Contract_Purchase_Option;
	}
	public void setContract_Purchase_Option(String contract_Purchase_Option) {
		Contract_Purchase_Option = contract_Purchase_Option;
	}
	public String getSold_to_Number() {
		return SapSold_to_Number;
	}
	public void setSold_to_Number(String sold_to_Number) {
		SapSold_to_Number = sold_to_Number;
	}
	public String getTerm_1() {
		return Term_1;
	}
	public void setTerm_1(String term_1) {
		Term_1 = term_1;
	}
	public double getYield() {
		return Yield;
	}
	public void setYield(double yield) {
		Yield = yield;
	}
	public int getProcedures_to_Date() {
		return Procedures_to_Date;
	}
	public void setProcedures_to_Date(int procedures_to_Date) {
		Procedures_to_Date = procedures_to_Date;
	}
	public int getRemaining_Procedures() {
		return Remaining_Procedures;
	}
	public void setRemaining_Procedures(int remaining_Procedures) {
		Remaining_Procedures = remaining_Procedures;
	}
	public String getNon_Reporting_Procedures() {
		return Non_Reporting_Procedures;
	}
	public void setNon_Reporting_Procedures(String non_Reporting_Procedures) {
		Non_Reporting_Procedures = non_Reporting_Procedures;
	}
	public String getFIS_Rep() {
		return FIS_Rep;
	}
	public void setFIS_Rep(String fIS_Rep) {
		FIS_Rep = fIS_Rep;
	}
	
	
	
	
	/****************************************************************************************************************************************************/

	
} // End Class
