package ReNAQH.Renderer;

public class Material {
	Shader shader;
	
	public Material(String vertexPath, String fragmentPath) {
		shader = new Shader(vertexPath, fragmentPath);
	}
	
	protected void finalize() {
		Delete();
	}
	
	public void Delete() {
		shader.Delete();
	}
	
	public Shader GetShader() {
		return shader;
	}
}