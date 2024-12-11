package model;

import java.io.Serializable;

public class Data implements Serializable {
    private int id;
    private String name;
    private String pass;
    private int STR;
    private int CON;
    private int DEX;
    private int AGI;
    private int INT;
    private int SEC;
    private int MET;
    private int LUC;

    public Data() {}
    public Data(int id, String name, String pass, int STR, int CON, int DEX,int AGI, int INT, int SEC,int MET, int LUC) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.STR = STR;
        this.CON = CON;
        this.DEX = DEX;
        this.AGI = AGI;
        this.INT = INT;
        this.SEC = SEC;
        this.MET = MET ;
        this.LUC = LUC;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	public int getLUC() {
		return LUC;
	}

	public void setLUC(int lUC) {
		LUC = lUC;
	}

	public int getAGI() {
		return AGI;
	}

	public void setAGI(int aGI) {
		AGI = aGI;
	}

	public int getMET() {
		return MET;
	}

	public void setMET(int mET) {
		MET = mET;
	}

    // http://localhost:8080/api/data
}
