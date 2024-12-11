package logic;

import model.UserPass;

public class CheckUserPass {
	public boolean execute(UserPass ups) {
		String needPass = "0925" ;
		if(ups.getPass().equals(needPass)) {
			return true ;
		}
		return false;}
}
