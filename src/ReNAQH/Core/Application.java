package ReNAQH.Core;

import org.lwjgl.glfw.GLFW;

import ReNAQH.Renderer.Renderer;
import ReNAQH.Renderer.Window;

public class Application {
	private static Application instance;
	
	private Application(ApplicationSpec appSpec) {
		Window.Create(appSpec.name, (int)appSpec.size.x, (int)appSpec.size.y);
		Renderer.Create();
		ObjectManger.Create();
		
		GLFW.glfwSetKeyCallback(Window.GetWindowHandel(), Input::KeyCallback);
		GLFW.glfwSetMouseButtonCallback(Window.GetWindowHandel(), Input::MouseButtonCallback);
		GLFW.glfwSetCursorPosCallback(Window.GetWindowHandel(), Input::MousePosCallback);
	}
	
	public static void Create(ApplicationSpec appSpec) {
		if(instance == null) {
			instance = new Application(appSpec);
		}
	}
	
	protected void finalize() {
		Destroy();
	}
	
	public static void Destroy() {
		Window.Destroy();
		Renderer.Destroy();

		GLFW.glfwTerminate();
	}
	
	public static void Run() {
		
	}
	
	public static void Start() {
		ObjectManger.Start();
	}
	
	public static void Update() {
		Renderer.Update();
		Input.Update();
		ObjectManger.Update();
	}
}