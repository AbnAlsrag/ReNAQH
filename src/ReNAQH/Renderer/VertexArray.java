package ReNAQH.Renderer;

import org.lwjgl.opengl.GL40;

public class VertexArray {
	private int id;
	
	public VertexArray(){
		id = GL40.glGenVertexArrays();
		GL40.glBindVertexArray(id);
	}
	
	protected void finalize() {
		Delete();
	}
	
	public void Bind() {
		GL40.glBindVertexArray(id);
	}
	
	public void UnBind() {
		GL40.glBindVertexArray(0);
	}
	
	public void Delete() {
		GL40.glBindVertexArray(0);
		GL40.glDeleteVertexArrays(id);
	}
}