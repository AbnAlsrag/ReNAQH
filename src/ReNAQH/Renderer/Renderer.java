package ReNAQH.Renderer;

import org.lwjgl.opengl.GL40;

public class Renderer {
	private Color backColor = new Color(1.0f, 1.0f, 1.0f);
	
	public Renderer() {
		
	}
	
	protected void finalize() {
		Destroy();
	}
	
	public void Destroy() {
		
	}
	
	public void Update() {
		GL40.glClearColor(backColor.r, backColor.g, backColor.b, backColor.a);
		GL40.glClear(GL40.GL_COLOR_BUFFER_BIT | GL40.GL_DEPTH_BUFFER_BIT);
	}
	
	public void RenderMesh(Mesh mesh) {
		
		if(mesh.GetTexture() != null)
			mesh.GetTexture().Bind(0);
		
		mesh.GetShader().Use();
		mesh.GetVBO().Bind();
		mesh.GetVAO().Bind();
		GL40.glDrawElements(GL40.GL_TRIANGLES, mesh.GetIndices().length, GL40.GL_UNSIGNED_INT, 0);
		mesh.GetVBO().Bind();
		mesh.GetVAO().UnBind();
		
		if(mesh.GetTexture() != null)
			mesh.GetTexture().UnBind();
	}
	
	public void DrawColor(Color color) {
		if(color != null)
			backColor = color;
	}
}