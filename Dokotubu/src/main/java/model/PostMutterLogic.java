package model;

import java.util.List;

public class PostMutterLogic {
	public void execute(Mutter mutter,List<Mutter> mls) {
		mls.add(0,mutter);
	}
}
