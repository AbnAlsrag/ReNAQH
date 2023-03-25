package ReNAQH.Renderer;


import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40;

import ReNAQH.Math.Vector2;

public class Window {
	private long window;
	private String title;
	private int width, height;
	private int frames, currentFrames;
	private long time;

	public Window(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		time = System.currentTimeMillis();

		GLFW.glfwInit();
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();
		GLFW.glfwSwapInterval(1);
		GLFW.glfwShowWindow(window);
		GLFW.glfwSetInputMode(window, GLFW.GLFW_STICKY_KEYS, 1);
	}
	
	protected void finalize() {
		Destroy();
	}
	
	public void Destroy()
	{
		GLFW.glfwDestroyWindow(window);
	}

	public void Update() {


		frames++;
		if(System.currentTimeMillis() > time + 1000) {
			currentFrames = frames;
			time = System.currentTimeMillis();
			frames = 0;
		}
	}

	public void SwapBuffer() {
		GLFW.glfwSwapBuffers(window);
	}

	public boolean IsClosed() {
		return GLFW.glfwWindowShouldClose(window);
	}
	
	public void SetTitle(String title) {
		GLFW.glfwSetWindowTitle(window, title);
	}

	public String GetTitle() {
		return title;
	}

	public Vector2 GetSize() {
		return new Vector2(width, height);
	}

	public int GetFrames() {
		return currentFrames;
	}
	
	public long GetWindowHandel() {
		return window;
	}

	public void SetVsync(boolean state) {
		if (state == true)
			GLFW.glfwSwapInterval(1);
		if (state == false)
			GLFW.glfwSwapInterval(0);
	}
}
