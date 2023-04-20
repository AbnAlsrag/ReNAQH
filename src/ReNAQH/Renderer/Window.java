package ReNAQH.Renderer;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40;

import ReNAQH.Math.Vector2;

public class Window {
	private static Window instance;
	private static long window;
	private static String title;
	private static int width, height;

	private static IntBuffer widthBuffer = BufferUtils.createIntBuffer(1), heightBuffer = BufferUtils.createIntBuffer(1);

	private Window(String title, int width, int height) {
		Window.title = title;
		Window.width = width;
		Window.height = height;

		GLFW.glfwInit();
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();
		GLFW.glfwSwapInterval(0);
		GLFW.glfwShowWindow(window);
		GLFW.glfwSetInputMode(window, GLFW.GLFW_STICKY_KEYS, 1);
	}
	
	public static void Create(String title, int width, int height) {
		if(instance == null) {
			instance = new Window(title, width, height);
		}
	}
	
	protected void finalize() {
		Destroy();
	}
	
	public static void Destroy()
	{
		GLFW.glfwDestroyWindow(window);
	}

	public static void Update() {
		GLFW.glfwGetWindowSize(window, widthBuffer, heightBuffer);
		
		width = widthBuffer.get(0);
		height = heightBuffer.get(0);
		
		GL40.glViewport(0, 0, width, height);
	}

	public static void SwapBuffer() {
		GLFW.glfwSwapBuffers(window);
	}

	public static boolean IsClosed() {
		return GLFW.glfwWindowShouldClose(window);
	}
	
	public static void SetTitle(String title) {
		GLFW.glfwSetWindowTitle(window, title);
	}

	public static String GetTitle() {
		return title;
	}

	public static Vector2 GetSize() {
		return new Vector2(width, height);
	}
	
	public static long GetWindowHandel() {
		return window;
	}

	public static void SetVsync(boolean state) {
		if (state == true)
			GLFW.glfwSwapInterval(1);
		if (state == false)
			GLFW.glfwSwapInterval(0);
	}
}