package ReNAQH.Renderer;

import org.lwjgl.opengl.GL40;

import ReNAQH.Math.Vector2;
import ReNAQH.Math.Vector3;
import ReNAQH.Utils.FileUtils;

public class Shader {
	private String vertexSource, fragmentSource;
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
	
	protected void finalize() {
		Delete();
	}
	
	public void Use() {
		GL40.glUseProgram(shaderProgram);
	}
	
	public void Delete() {
		GL40.glDeleteProgram(shaderProgram);
	}
	
	public void setBool(String name, boolean value)
    {
		GL40.glUniform1i(GL40.glGetUniformLocation(shaderProgram, name), (value)?1:0);
    }

	public void setInt(String name, int value)
    {
		GL40.glUniform1i(GL40.glGetUniformLocation(shaderProgram, name), value);
    }

	public void setFloat(String name, float value)
    {
		GL40.glUniform1f(GL40.glGetUniformLocation(shaderProgram, name), value);
    }

//	public void setMatrix4(String name, glm::mat4 value)
//    {
//		GL40.glUniformMatrix4fv(GL40.glGetUniformLocation(shaderProgram, name), 1, GL_FALSE, glm::value_ptr(value));
//    }

	public void setVector3(String name, Vector3 value)
    {
		GL40.glUniform3f(GL40.glGetUniformLocation(shaderProgram, name), value.x, value.y, value.z);
    }

	public void setVector2(String name, Vector2 value)
    {
		GL40.glUniform2f(GL40.glGetUniformLocation(shaderProgram, name), value.x, value.y);
    }
}
