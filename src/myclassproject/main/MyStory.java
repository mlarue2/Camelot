package myclassproject.main;

import com.storygraph.Graph;
import myclassproject.mystorygraph.MyGraph;
import com.storygraph.Story;

public class MyStory extends Story {

	/**
	 * @return A new object of MyGraph
	 */
	@Override
	public Graph getGraph() {
		return new MyGraph();
	}


}
