package Main;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector2f;

import ReNAQH.Components.Renderer.SpriteRenderer;
import ReNAQH.Core.Application;
import ReNAQH.Core.ApplicationSpec;
import ReNAQH.Core.GameObject;
import ReNAQH.Math.Vector2;
import ReNAQH.Math.Vector3;
import ReNAQH.Renderer.Camera;
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
		
		Application.Create(appSpec);
		Renderer.DrawColor(new Color(0.07f, 0.13f, 0.17f));
		
		float speed = 0.05f, camSpeed = 0.03f;

		long lastTime = System.currentTimeMillis();

		Vector2f cameraPosition = new Vector2f(0, 0);
		Camera cam = new Camera(cameraPosition);
		Vector2f camPos = new Vector2f();
		
		GameObject rect = new GameObject("MyRect");
		rect.AddComponent(SpriteRenderer.class);
		
		Application.Start();
		while (!Window.IsClosed()) {
			Window.SetTitle("ReNAQH | FPS: " + Window.GetFrames());
			Window.Update();
			
			if(System.currentTimeMillis() > lastTime + 80)
			{
				lastTime = System.currentTimeMillis();
			}
			
			Window.SwapBuffer();
			Application.Update();
		}
		
		Application.Destroy();
	}
}