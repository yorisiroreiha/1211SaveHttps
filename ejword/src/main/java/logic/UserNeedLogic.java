package logic;

import java.util.ArrayList;
import java.util.List;

import dao.WordDAO;
import model.UserNeed;
import model.Word;

public class UserNeedLogic {
	public List<Word> execute(UserNeed und){
		WordDAO dao = new WordDAO();
		List<Word> list = new ArrayList<>();
		list = dao.findNeed(und.getTitle(), und.getChoice());
		return list ;
	}
	public List<Word> executeLimit(UserNeed und){
		int limit = und.getLimit() ;
		WordDAO dao = new WordDAO();
		List<Word> list = new ArrayList<>();
		list = dao.limitFindNeed(und.getTitle(), und.getChoice(),limit ,limit*(und.getPage()-1));
		return list ;
	}
}

