package ReNAQH.Renderer;

import java.nio.FloatBuffer;

import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL40;

import ReNAQH.Math.Vector2;
import ReNAQH.Math.Vector3;
import ReNAQH.Utils.FileUtils;

public class Shader {
	private String vertexSource, fragmentSource, shaderSource;
	private int vertexShader, fragmentShader, shaderProgram;
	
	public Shader(String vertexPath, String fragmentPath) {
		vertexSource = FileUtils.LoadFile(vertexPath);
		fragmentSource = FileUtils.LoadFile(fragmentPath);
		
		vertexShader = GL40.glCreateShader(GL40.GL_VERTEX_SHADER);
		GL40.glShaderSource(vertexShader, vertexSource);
		GL40.glCompileShader(vertexShader);
	
		fragmentShader = GL40.glCreateShader(GL40.GL_FRAGMENT_SHADER);
		GL40.glShaderSource(fragmentShader, fragmentSource);
		GL40.glCompileShader(fragmentShader);
		
		shaderProgram = GL40.glCreateProgram();
		GL40.glAttachShader(shaderProgram, vertexShader);
		GL40.glAttachShader(shaderProgram, fragmentShader);
		GL40.glLinkProgram(shaderProgram);

		GL40.glDeleteShader(vertexShader);
		GL40.glDeleteShader(fragmentShader);
	}
	
	public Shader(String shaderPath) {
		shaderSource = FileUtils.LoadFile(shaderPath);
	}
	
	protected void finalize() {
		Delete();
	}
	
	public void Use() {
		GL40.glUseProgram(shaderProgram);
	}
	
	public void Detach() {
		GL40.glUseProgram(0);
	}
	
	public void Delete() {
		GL40.glDeleteProgram(shaderProgram);
	}
	
	public void SetBool(String name, boolean value)
    {
		Use();
		GL40.glUniform1i(GL40.glGetUniformLocation(shaderProgram, name), (value)?1:0);
    }

	public void SetInt(String name, int value)
    {
		Use();
		GL40.glUniform1i(GL40.glGetUniformLocation(shaderProgram, name), value);
    }

	public void SetFloat(String name, float value)
    {
		Use();
		GL40.glUniform1f(GL40.glGetUniformLocation(shaderProgram, name), value);
    }

	public void SetVector3(String name, Vector3 value)
    {
		Use();
		GL40.glUniform3f(GL40.glGetUniformLocation(shaderProgram, name), value.x, value.y, value.z);
    }

	public void SetVector2(String name, Vector2 value)
    {
		Use();
		GL40.glUniform2f(GL40.glGetUniformLocation(shaderProgram, name), value.x, value.y);
    }

	public void SetMatrix4(String name, Matrix4f value) {
		FloatBuffer matBuffer = BufferUtils.createFloatBuffer(16);
		value.get(matBuffer);
		
		Use();
		GL40.glUniformMatrix4fv(GL40.glGetUniformLocation(shaderProgram, name), false, matBuffer);
	}
	
    public void SetTexture(String name, int value) {
        Use();
        GL40.glUniform1i(GL40.glGetUniformLocation(shaderProgram, name), value);
    }
}