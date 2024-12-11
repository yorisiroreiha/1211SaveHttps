package model;

import java.util.List;

public class PostCommentLogic {
	public void execute(Comment comment,List<Comment> mls) {
		mls.add(0,comment);
	}
}
