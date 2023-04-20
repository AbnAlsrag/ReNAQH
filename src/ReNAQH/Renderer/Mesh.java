package ReNAQH.Renderer;

public class Mesh {	
	private Vertex[] vertices;
	private int[] indices;
	private VertexArray vao;
	private VertexBuffer vbo;
	private IndexBuffer ibo;
	private Material material;
	private Texture texture;
	private int id;
	
	public Mesh() {
		
	}
	
	public Mesh(Vertex[] vertices, int[] indices, String vertexPath, String fragmentPath) {
		this.vertices = vertices;
		this.indices = indices;
		vao = new VertexArray();
		vbo = new VertexBuffer(vertices);
		ibo = new IndexBuffer(indices);
		material = new Material(vertexPath, fragmentPath);
	}
	
	protected void finalize() {
		Delete();
	}
	
	public void Delete() {
		material.Delete();
		vao.Delete();
		vbo.Delete();
		ibo.Delete();		
	}

	public Vertex[] GetVertices() {
		return vertices;
	}

	public int[] GetIndices() {
		return indices;
	}

	public VertexArray GetVAO() {
		return vao;
	}

	public VertexBuffer GetVBO() {
		return vbo;
	}

	public IndexBuffer GetIBO() {
		return ibo;
	}
	
	public Shader GetShader() {
		return material.GetShader();
	}
	
	public void SetTexture(Texture texture) {
		this.texture = texture;
	}
	
	public Texture GetTexture() {
		return texture;
	}
	
	public void SetId(int id) {
		this.id = id;
	}
	
	public int GetId() {
		return id;
	}
}