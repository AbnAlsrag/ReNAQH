package ReNAQH.Renderer;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL40;
import org.lwjgl.system.MemoryUtil;

public class VertexBuffer {
	private int id;
	
	public VertexBuffer(Vertex[] vertices) {
		
		FloatBuffer vertexBuffer = MemoryUtil.memAllocFloat(vertices.length * 3);
		float[] positionData = new float[vertices.length * 3];
		
		for(int i = 0; i < vertices.length; i++) {
			positionData[i * 3] = vertices[i].GetPosition().x;
			positionData[i * 3 + 1] = vertices[i].GetPosition().y;
			positionData[i * 3 + 2] = vertices[i].GetPosition().z;
		}
		
		vertexBuffer.put(positionData).flip();
		
		id = GL40.glGenBuffers();
		GL40.glBindBuffer(GL40.GL_ARRAY_BUFFER, id);
		GL40.glBufferData(GL40.GL_ARRAY_BUFFER, vertexBuffer, GL40.GL_STATIC_DRAW);
		GL40.glVertexAttribPointer(0, 3, GL40.GL_FLOAT, false, 0, 0);
	}
	
	protected void finalize() {
		Delete();
	}
	
	public void Bind() {
		GL40.glEnableVertexAttribArray(0);
		GL40.glBindBuffer(GL40.GL_ARRAY_BUFFER, id);
	}

	public void UnBind() {
		GL40.glDisableVertexAttribArray(0);
		GL40.glBindBuffer(GL40.GL_ARRAY_BUFFER, 0);
	}
	
	public void Delete() {
		GL40.glBindBuffer(GL40.GL_ARRAY_BUFFER, 0);
		GL40.glDeleteBuffers(id);
	}
}