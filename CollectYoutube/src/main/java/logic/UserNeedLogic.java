package logic;

import java.util.ArrayList;
import java.util.List;

import dao.CollectYoutubeConnection;
import model.Collections;
import model.UserNeed;

public class UserNeedLogic {
	public List<Collections> execute(UserNeed und){
		CollectYoutubeConnection dao = new CollectYoutubeConnection();
		List<Collections> list = new ArrayList<>();
		list = dao.findNeed(und.getTitle(), und.getChoice());
		return list ;
	}
	public List<Collections> executeLimit(UserNeed und){
		int limit = und.getLimit() ;
		CollectYoutubeConnection dao = new CollectYoutubeConnection();
		List<Collections> list = new ArrayList<>();
		list = dao.limitFindNeed(und.getTitle(), und.getChoice(),limit ,limit*(und.getPage()-1));
		return list ;
	}
}

