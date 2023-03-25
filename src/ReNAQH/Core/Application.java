package ReNAQH.Core;

import org.lwjgl.glfw.GLFW;

import ReNAQH.Renderer.Renderer;
import ReNAQH.Renderer.Window;

public class Application {
	private Window window;
	private Renderer renderer;

	public Application(ApplicationSpec appSpec) {
		window = new Window(appSpec.name, (int)appSpec.size.x, (int)appSpec.size.y);
		renderer = new Renderer();
		
		GLFW.glfwSetKeyCallback(window.GetWindowHandel(), Input::KeyCallback);
		GLFW.glfwSetMouseButtonCallback(window.GetWindowHandel(), Input::MouseButtonCallback);
		GLFW.glfwSetCursorPosCallback(window.GetWindowHandel(), Input::MousePosCallback);
	}
	
	protected void finalize() {
		Destroy();
	}
	
	public void Destroy() {
		window.Destroy();
		renderer.Destroy();

		GLFW.glfwTerminate();
	}
	
	public void Run() {
		
	}
	
	public void Update() {
		renderer.Update();
		Input.Update();
	}
	
	public Window GetWindow() {
		return window;
	}
	
	public Renderer GetRendere() {
		return renderer;
	}
}