package com.olympus.nbva.assets;

public class AssetData {
	private long assetId; // i=27
	private long assetId_1;
	private String equipType; // i=9
	private String equipDesc; // i=10
	private String Model; // i=11
	private String serNum; // i=12
	private int qty; // i=13
	private String equipAddr1; // i=14
	private String equipAddr2; // i=15
	private String equipCity; // i=16
	private String equipState; // i=17
	private String equipZip; // i=18
	private double equipCost; // i=20
	private double residAmt; // i=19
	private double assetRentalAmt;
	private int dispCode; // i=22
	private String termDate; // i=
	private double floorPrice;
	private String calcOpt;
	private double rollPrice;
	private double buyPrice;
	private double rtnPrice;
	private String returnAsset;

	
	/****************************************************************************************************************************************************/
	// New fields 
	private String OL_Residual; 	//i=32
	double Contract_Payment;	//i=33
	private String Asset_CPP_Rate;	//i=37
	private String Asset_Purchase_Option; //i=40
	double residualValue;	//i=19
	private double netInvestment;

	/****************************************************************************************************************************************************/

	
	
	
	public String getCalcOpt() {
		return calcOpt;
	}





	




	public long getAssetId_1() {
		return assetId_1;
	}





	public void setAssetId_1(long assetId_1) {
		this.assetId_1 = assetId_1;
	}





	public double getAssetRentalAmt() {
		return assetRentalAmt;
	}





	public void setAssetRentalAmt(double assetRentalAmt) {
		this.assetRentalAmt = assetRentalAmt;
	}





	public double getNetInvestment() {
		return netInvestment;
	}





	public void setNetInvestment(double netInvestment) {
		this.netInvestment = netInvestment;
	}





	public double getResidualValue() {
		return residualValue;
	}





	public void setResidualValue(double residualValue) {
		this.residualValue = residualValue;
	}





	public String getOL_Residual() {
		return OL_Residual;
	}





	public void setOL_Residual(String oL_Residual) {
		OL_Residual = oL_Residual;
	}





	public double getContract_Payment() {
		return Contract_Payment;
	}





	public void setContract_Payment(double contract_Payment) {
		Contract_Payment = contract_Payment;
	}





	public String getAsset_CPP_Rate() {
		return Asset_CPP_Rate;
	}





	public void setAsset_CPP_Rate(String asset_CPP_Rate) {
		Asset_CPP_Rate = asset_CPP_Rate;
	}





	public String getAsset_Purchase_Option() {
		return Asset_Purchase_Option;
	}





	public void setAsset_Purchase_Option(String asset_Purchase_Option) {
		Asset_Purchase_Option = asset_Purchase_Option;
	}





	public String getReturnAsset() {
		return returnAsset;
	}





	public void setReturnAsset(String returnAsset) {
		this.returnAsset = returnAsset;
	}





	public double getRollPrice() {
		return rollPrice;
	}


	public void setRollPrice(double rollPrice) {
		this.rollPrice = rollPrice;
	}


	public double getBuyPrice() {
		return buyPrice;
	}


	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}


	public double getRtnPrice() {
		return rtnPrice;
	}


	public void setRtnPrice(double rtnPrice) {
		this.rtnPrice = rtnPrice;
	}


	public void setCalcOpt(String calcOpt) {
		this.calcOpt = calcOpt;
	}
	
	
	public String getTermDate() {
		return termDate;
	}


	


	public double getFloorPrice() {
		return floorPrice;
	}

	public void setFloorPrice(double floorPrice) {
		this.floorPrice = floorPrice;
	}

	public void setTermDate(String termDate) {
		this.termDate = termDate;
	}
	
	public long getAssetId() {
		return assetId;
	}
	public int getDispCode() {
		return dispCode;
	}
	public void setDispCode(int dispCode) {
		this.dispCode = dispCode;
	}
	public double getEquipCost() {
		return equipCost;
	}
	public void setEquipCost(double equipCost) {
		this.equipCost = equipCost;
	}
	public double getResidAmt() {
		return residAmt;
	}
	public void setResidAmt(double residAmt) {
		this.residAmt = residAmt;
	}
	public double getassetRentalAmt() {
		return assetRentalAmt;
	}
	public void setassetRentalAmt(double assetRentalAmt) {
		this.assetRentalAmt = assetRentalAmt;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}
	
	public String getEquipType() {
		return equipType;
	}
	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}
	
	public String getEquipDesc() {
		return equipDesc;
	}
	public void setEquipDesc(String equipDesc) {
		this.equipDesc = equipDesc;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getSerNum() {
		return serNum;
	}
	public void setSerNum(String serNum) {
		this.serNum = serNum;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getEquipAddr1() {
		return equipAddr1;
	}
	public void setEquipAddr1(String equipAddr1) {
		this.equipAddr1 = equipAddr1;
	}
	public String getEquipAddr2() {
		return equipAddr2;
	}
	public void setEquipAddr2(String equipAddr2) {
		this.equipAddr2 = equipAddr2;
	}
	public String getEquipCity() {
		return equipCity;
	}
	public void setEquipCity(String equipCity) {
		this.equipCity = equipCity;
	}
	public String getEquipState() {
		return equipState;
	}
	public void setEquipState(String equipState) {
		this.equipState = equipState;
	}
	public String getEquipZip() {
		return equipZip;
	}
	public void setEquipZip(String equipZip) {
		this.equipZip = equipZip;
	}
	

	
	
	/****************************************************************************************************************************************************/

} // End Class
