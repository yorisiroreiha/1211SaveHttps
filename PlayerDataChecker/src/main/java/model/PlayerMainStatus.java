package model;

import java.io.Serializable;

public class PlayerMainStatus implements Serializable {
	private int STR;
    private int CON;
    private int DEX;
    private int AGI;
    private int INT;
    private int SEC;
    private int MET;
    private int LUC;
    
    public PlayerMainStatus(int STR,int CON,int DEX,int AGI,int INT,int SEC,int MET,int LUC) {
    	 this.STR = STR;
         this.CON = CON;
         this.DEX = DEX;
         this.AGI = AGI;
         this.INT = INT;
         this.SEC = SEC;
         this.MET = MET ;
         this.LUC = LUC;
    }
    
	public int getSTR() {
		return STR;
	}
	public void setSTR(int sTR) {
		STR = sTR;
	}
	public int getCON() {
		return CON;
	}
	public void setCON(int cON) {
		CON = cON;
	}
	public int getDEX() {
		return DEX;
	}
	public void setDEX(int dEX) {
		DEX = dEX;
	}
	public int getAGI() {
		return AGI;
	}
	public void setAGI(int aGI) {
		AGI = aGI;
	}
	public int getINT() {
		return INT;
	}
	public void setINT(int iNT) {
		INT = iNT;
	}
	public int getSEC() {
		return SEC;
	}
	public void setSEC(int sEC) {
		SEC = sEC;
	}
	public int getMET() {
		return MET;
	}
	public void setMET(int mET) {
		MET = mET;
	}
	public int getLUC() {
		return LUC;
	}
	public void setLUC(int lUC) {
		LUC = lUC;
	}
    
    
	
}
