package com.pojo;

public class trade {
	private int TRADE_NUMBER;
	private String NAME;
	private String CLASS;
	private String STOCK;
	private String TRADE_DATE;
	private String TRADE_TIME;
	private String TRADE_TYPE;
	private String SECURITY_TYPE;
	private int QUANTITY;
	private double PRICE;
	private double VALUE;
	
	public trade() {
		// TODO Auto-generated constructor stub
		TRADE_NUMBER=0;
		NAME="0";
		CLASS="0";
		STOCK="0";
		TRADE_DATE="0";
		TRADE_TIME="0";
		TRADE_TYPE="0";
		SECURITY_TYPE="0";
		QUANTITY=0;
		PRICE=0;
		VALUE=0;
	}
	

	public trade(int tRADE_NUMBER, String nAME, String cLASS, String sTOCK, String tRADE_DATE, String tRADE_TIME,
			String tRADE_TYPE, String sECURITY_TYPE, int qUANTITY, double pRICE, double vALUE) {
		super();
		TRADE_NUMBER = tRADE_NUMBER;
		NAME = nAME;
		CLASS = cLASS;
		STOCK = sTOCK;
		TRADE_DATE = tRADE_DATE;
		TRADE_TIME = tRADE_TIME;
		TRADE_TYPE = tRADE_TYPE;
		SECURITY_TYPE = sECURITY_TYPE;
		QUANTITY = qUANTITY;
		PRICE = pRICE;
		VALUE = vALUE;
	}


	public int getTRADE_NUMBER() {
		return TRADE_NUMBER;
	}


	public void setTRADE_NUMBER(int tRADE_NUMBER) {
		TRADE_NUMBER = tRADE_NUMBER;
	}


	public String getNAME() {
		return NAME;
	}


	public void setNAME(String nAME) {
		NAME = nAME;
	}


	public String getCLASS() {
		return CLASS;
	}


	public void setCLASS(String cLASS) {
		CLASS = cLASS;
	}


	public String getSTOCK() {
		return STOCK;
	}


	public void setSTOCK(String sTOCK) {
		STOCK = sTOCK;
	}


	public String getTRADE_DATE() {
		return TRADE_DATE;
	}


	public void setTRADE_DATE(String tRADE_DATE) {
		TRADE_DATE = tRADE_DATE;
	}


	public String getTRADE_TIME() {
		return TRADE_TIME;
	}


	public void setTRADE_TIME(String tRADE_TIME) {
		TRADE_TIME = tRADE_TIME;
	}


	public String getTRADE_TYPE() {
		return TRADE_TYPE;
	}


	public void setTRADE_TYPE(String tRADE_TYPE) {
		TRADE_TYPE = tRADE_TYPE;
	}


	public String getSECURITY_TYPE() {
		return SECURITY_TYPE;
	}


	public void setSECURITY_TYPE(String sECURITY_TYPE) {
		SECURITY_TYPE = sECURITY_TYPE;
	}


	public int getQUANTITY() {
		return QUANTITY;
	}


	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}


	public double getPRICE() {
		return PRICE;
	}


	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}


	public double getVALUE() {
		return VALUE;
	}


	public void setVALUE(double vALUE) {
		VALUE = vALUE;
	}
	
	@Override
	public String toString() {
		return "trade [TRADE_NUMBER=" + TRADE_NUMBER + ", NAME=" + NAME + ", CLASS=" + CLASS + ", STOCK=" + STOCK
				+ ", TRADE_DATE=" + TRADE_DATE + ", TRADE_TIME=" + TRADE_TIME + ", TRADE_TYPE=" + TRADE_TYPE
				+ ", SECURITY_TYPE=" + SECURITY_TYPE + ", QUANTITY=" + QUANTITY + ", PRICE=" + PRICE + ", VALUE="
				+ VALUE + "]";
	}


}
