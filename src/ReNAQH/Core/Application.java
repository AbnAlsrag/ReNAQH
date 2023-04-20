package ReNAQH.Core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.lwjgl.glfw.GLFW;

import ReNAQH.Events.Input;
import ReNAQH.Events.SignalManger;
import ReNAQH.Renderer.Color;
import ReNAQH.Renderer.Renderer;
import ReNAQH.Renderer.Window;

public class Application {
	private final static int CREATE = 0;
	private final static int DESTROY = 1;
	private final static int START = 2;
	private final static int UPDATE = 3;
	
	private static Application instance;
	private static boolean isRunning;
	private static int frames, FPS;
	private static double time;
	private final static ArrayList<Method> objectMangerMethods = new ArrayList<>();
	
	private Application(ApplicationSpec appSpec) {
		isRunning = true;
		time = System.currentTimeMillis();
		
		try {
			objectMangerMethods.add(ObjectManger.class.getDeclaredMethod("Create"));
			objectMangerMethods.add(ObjectManger.class.getDeclaredMethod("Destroy"));
			objectMangerMethods.add(ObjectManger.class.getDeclaredMethod("Start"));
			objectMangerMethods.add(ObjectManger.class.getDeclaredMethod("Update"));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			Window.Create(appSpec.name, (int)appSpec.size.x, (int)appSpec.size.y);
			Renderer.Create();
			
			objectMangerMethods.get(CREATE).setAccessible(true);
			objectMangerMethods.get(CREATE).invoke(null);
			SignalManger.Create();
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		Renderer.DrawColor(new Color(0.07f, 0.13f, 0.17f));
		
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
		try {
			Window.Destroy();
			Renderer.Destroy();
			
			objectMangerMethods.get(DESTROY).setAccessible(true);
			objectMangerMethods.get(DESTROY).invoke(null);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		GLFW.glfwTerminate();
	}
	
	public static void Run() {		
		Start();
		
		while(isRunning && !Window.IsClosed()) {
			frames++;

			Update();

			if(System.currentTimeMillis() > time + 1000) {
				time = System.currentTimeMillis();
				FPS = frames;
				frames = 0;
			}
		}
		
		Destroy();
	}
	
	public static void Start() {
		try {
			objectMangerMethods.get(START).setAccessible(true);
			objectMangerMethods.get(START).invoke(null);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static void Update() {
		try {
			Window.Update();
			Window.SwapBuffer();
			Renderer.Update();
			Input.Update();
			
			objectMangerMethods.get(UPDATE).setAccessible(true);
			objectMangerMethods.get(UPDATE).invoke(null);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static int GetFrames() {
		return FPS;
	}
}