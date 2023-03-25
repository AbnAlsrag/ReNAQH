package Main;

import org.joml.Matrix4f;

import ReNAQH.Core.Application;
import ReNAQH.Core.ApplicationSpec;
import ReNAQH.Core.Input;
import ReNAQH.Math.Vector2;
import ReNAQH.Math.Vector3;
import ReNAQH.Renderer.Color;
import ReNAQH.Renderer.Mesh;
import ReNAQH.Renderer.Vertex;
import ReNAQH.Renderer.Window;
import ReNAQH.Renderer.Renderer;
import ReNAQH.Renderer.Texture;

public class Main {
	public static void main(String[] args) {
		ApplicationSpec appSpec = new ApplicationSpec();
		appSpec.name = "NAQH";
		appSpec.size = new Vector2(600, 600);
		
		Application app = new Application(appSpec);
		Window window = app.GetWindow();
		Renderer renderer = app.GetRendere();
		renderer.DrawColor(new Color(0.07f, 0.13f, 0.17f));
		
		Vector3 color = new Vector3(1.0f, 0.0f, 0.0f);
		int state = 0;

		boolean dr = true;
		long lastTime = System.currentTimeMillis();
		
		Texture tex1 = new Texture("res/Textures/wall.jpg");

		Vertex[] verticesRect = new Vertex[] {
				new Vertex(new Vector3(-0.5f, 0.5f, 0f)),
				new Vertex(new Vector3(0.5f, 0.5f, 0f)),
				new Vertex(new Vector3(0.5f, -0.5f, 0f)),
				new Vertex(new Vector3(-0.5f, -0.5f, 0f))
		};
		int[] indicesRect = new int[] {0, 1, 2, 0, 3, 2};
		
		Mesh Rect = new Mesh(verticesRect, indicesRect, "res/Shaders/vertex.glsl", "res/Shaders/fragment.glsl");
		Rect.SetTexture(tex1);
		Matrix4f matrixRect = new Matrix4f();
		
		Vertex[] verticesTri = new Vertex[] {
				new Vertex(new Vector3(0.0f, 0.5f, 0.0f)),
				new Vertex(new Vector3(0.5f, -0.5f, 0.0f)),
				new Vertex(new Vector3(-0.5f, -0.5f, 0.0f))
		};
		int[] indicesTri = new int[] {0, 1, 2, 0, 3, 2};
		
		Mesh Tri = new Mesh(verticesTri, indicesTri, "res/Shaders/vertex.glsl", "res/Shaders/fragment.glsl");
		
		while (!window.IsClosed()) {
			window.SetTitle("ReNAQH | FPS: " + window.GetFrames());
			window.Update();
			
			if(System.currentTimeMillis() > lastTime + 1000)
			{
//				dr = !dr;
				lastTime = System.currentTimeMillis();
			}
			
			if(dr) {
				renderer.RenderMesh(Rect);
			}
			else {
				renderer.RenderMesh(Tri);
			}
			
			if(Input.IsMouseDragging())
				System.out.println(Input.GetMouseDeltaPos().x + ", " + Input.GetMouseDeltaPos().y);

			window.SwapBuffer();
			app.Update();
		}
		
		app.Destroy();
	}
}