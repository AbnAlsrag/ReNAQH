package ReNAQH.Renderer;

import java.nio.IntBuffer;

import org.lwjgl.opengl.GL40;
import org.lwjgl.system.MemoryUtil;

public class IndexBuffer {
	private int id;
	
	public IndexBuffer(int[] indices) {
		IntBuffer indexBuffer = MemoryUtil.memAllocInt(indices.length);
		indexBuffer.put(indices).flip();
		
		id = GL40.glGenBuffers();
		GL40.glBindBuffer(GL40.GL_ELEMENT_ARRAY_BUFFER, id);
		GL40.glBufferData(GL40.GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL40.GL_STATIC_DRAW);
	}
	
	protected void finalize() {
		Delete();
	}
	
	public void Bind() {
		GL40.glBindBuffer(GL40.GL_ELEMENT_ARRAY_BUFFER, id);
	}
	
	public void UnBind() {
		GL40.glBindBuffer(GL40.GL_ELEMENT_ARRAY_BUFFER, 0);
	}
	
	public void Delete() {
		GL40.glBindBuffer(GL40.GL_ELEMENT_ARRAY_BUFFER, 0);
		GL40.glDeleteBuffers(id);
	}
}