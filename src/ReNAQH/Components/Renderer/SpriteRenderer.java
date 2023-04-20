package ReNAQH.Components.Renderer;

import org.joml.Matrix4f;

import ReNAQH.Core.Component;
import ReNAQH.Events.Signal;
import ReNAQH.Math.Vector2;
import ReNAQH.Math.Vector3;
import ReNAQH.Renderer.Mesh;
import ReNAQH.Renderer.Renderer;
import ReNAQH.Renderer.Texture;
import ReNAQH.Renderer.Vertex;

public class SpriteRenderer extends Component {
	public Texture texture = new Texture("res/Textures/wall.jpg");
	public final String str = "Hello, World!\n\tFrom ABN ALSRAG and MNS";

	private Vertex[] vertices = new Vertex[] {
			new Vertex(new Vector3(-0.5f, 0.5f, 0f), new Vector2()),
			new Vertex(new Vector3(0.5f, 0.5f, 0f), new Vector2()),
			new Vertex(new Vector3(0.5f, -0.5f, 0f), new Vector2()),
			new Vertex(new Vector3(-0.5f, -0.5f, 0f), new Vector2())
	};
	
	private int[] indices = new int[] {0, 1, 2, 0, 3, 2};
	
	private Mesh mesh = new Mesh(vertices, indices, "res/Shaders/vertex.glsl", "res/Shaders/fragment.glsl");
	Matrix4f matrix = new Matrix4f().scale(0.4f, 0.4f, 0.4f);
	
	public void Start() {
		mesh.SetTexture(texture);
	}

	public void Update() {
		mesh.GetShader().SetMatrix4("transform", matrix);
		Renderer.RenderMesh(mesh);
	}
	
}