package clases;

import java.util.TreeSet;

public class Foro extends CosaConNombre{
	 private TreeSet<PostForo> postForo;

	public Foro(String nombre, TreeSet<PostForo> postForo) {
		super(nombre);
		this.postForo = postForo;
	}

	public TreeSet<PostForo> getPostForo() {
		return postForo;
	}

	public void setPostForo(TreeSet<PostForo> postForo) {
		this.postForo = postForo;
	}

	@Override
	public String toString() {
		return "FORO "+this.getNombre()+"\n\tPost del foro :\n\t" + postForo+"\n\t";
	}
	
	
	 
	
}
