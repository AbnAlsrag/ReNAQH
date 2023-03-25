package ReNAQH.Renderer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL40;
import org.lwjgl.stb.*;

public class Texture {
	private int id;
	
	public Texture(String path) {
		id = GL40.glGenTextures();
		GL40.glBindTexture(GL40.GL_TEXTURE_2D, id);
		GL40.glTexParameteri(GL40.GL_TEXTURE_2D, GL40.GL_TEXTURE_WRAP_S, GL40.GL_REPEAT);
		GL40.glTexParameteri(GL40.GL_TEXTURE_2D, GL40.GL_TEXTURE_WRAP_T, GL40.GL_REPEAT);
		GL40.glTexParameteri(GL40.GL_TEXTURE_2D, GL40.GL_TEXTURE_MIN_FILTER, GL40.GL_LINEAR);
		GL40.glTexParameteri(GL40.GL_TEXTURE_2D, GL40.GL_TEXTURE_MAG_FILTER, GL40.GL_LINEAR);
		
		IntBuffer width = BufferUtils.createIntBuffer(1), height = BufferUtils.createIntBuffer(1), nrChannels = BufferUtils.createIntBuffer(1);
		ByteBuffer data = STBImage.stbi_load(path, width, height, nrChannels, 0);
		GL40.glTexImage2D(GL40.GL_TEXTURE_2D, 0, GL40.GL_RGB, width.get(0), height.get(0), 0, GL40.GL_RGB, GL40.GL_UNSIGNED_BYTE, data);
		GL40.glGenerateMipmap(GL40.GL_TEXTURE_2D);
		STBImage.stbi_image_free(data);
		GL40.glBindTexture(GL40.GL_TEXTURE_2D, 0);
	}
	
	protected void finalize()
	{
		Delete();
	}
	
	public void Bind(int p_number)
	{
		GL40.glActiveTexture(GL40.GL_TEXTURE0 + p_number);
		GL40.glBindTexture(GL40.GL_TEXTURE_2D, id);
	}

	public void UnBind()
	{
		GL40.glBindTexture(GL40.GL_TEXTURE_2D, 0);
	}

	public void Delete()
	{
		GL40.glBindTexture(GL40.GL_TEXTURE_2D, 0);
		GL40.glDeleteTextures(id);
	}
}