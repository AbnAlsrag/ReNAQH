package ReNAQH.Core;

import org.lwjgl.glfw.GLFW;
import ReNAQH.Math.Vector2;

public class Input {
	public static final int KEY_UNKNOWN             = -1;
    public static final int KEY_Space               = 32;
    public static final int KEY_Apostrophe          = 39; /* ' */
    public static final int KEY_Comma               = 44; /* , */
    public static final int KEY_Minus               = 45; /* - */
    public static final int KEY_Period              = 46; /* . */
    public static final int KEY_Slash               = 47; /* / */

    public static final int KEY_D0                  = 48; /* 0 */
    public static final int KEY_D1                  = 49; /* 1 */
    public static final int KEY_D2                  = 50; /* 2 */
    public static final int KEY_D3                  = 51; /* 3 */
    public static final int KEY_D4                  = 52; /* 4 */
    public static final int KEY_D5                  = 53; /* 5 */
    public static final int KEY_D6                  = 54; /* 6 */
    public static final int KEY_D7                  = 55; /* 7 */
    public static final int KEY_D8                  = 56; /* 8 */
    public static final int KEY_D9                  = 57; /* 9 */

    public static final int KEY_Semicolon           = 59; /* ; */
    public static final int KEY_Equal               = 61; /* = */

    public static final int KEY_A                   = 65;
    public static final int KEY_B                   = 66;
    public static final int KEY_C                   = 67;
    public static final int KEY_D                   = 68;
    public static final int KEY_E                   = 69;
    public static final int KEY_F                   = 70;
    public static final int KEY_G                   = 71;
    public static final int KEY_H                   = 72;
    public static final int KEY_I                   = 73;
    public static final int KEY_J                   = 74;
    public static final int KEY_K                   = 75;
    public static final int KEY_L                   = 76;
    public static final int KEY_M                   = 77;
    public static final int KEY_N                   = 78;
    public static final int KEY_O                   = 79;
    public static final int KEY_P                   = 80;
    public static final int KEY_Q                   = 81;
    public static final int KEY_R                   = 82;
    public static final int KEY_S                   = 83;
    public static final int KEY_T                   = 84;
    public static final int KEY_U                   = 85;
    public static final int KEY_V                   = 86;
    public static final int KEY_W                   = 87;
    public static final int KEY_X                   = 88;
    public static final int KEY_Y                   = 89;
    public static final int KEY_Z                   = 90;

    public static final int KEY_LeftBracket         = 91;  /* [ */
    public static final int KEY_Backslash           = 92;  /* \ */
    public static final int KEY_RightBracket        = 93;  /* ] */
    public static final int KEY_GraveAccent         = 96;  /* ` */

    public static final int KEY_World1              = 161; /* non-US #1 */
    public static final int KEY_World2              = 162; /* non-US #2 */

    /* Function keys */
    public static final int KEY_Escape              = 256;
    public static final int KEY_Enter               = 257;
    public static final int KEY_Tab                 = 258;
    public static final int KEY_Backspace           = 259;
    public static final int KEY_Insert              = 260;
    public static final int KEY_Delete              = 261;
    public static final int KEY_Right               = 262;
    public static final int KEY_Left                = 263;
    public static final int KEY_Down                = 264;
    public static final int KEY_Up                  = 265;
    public static final int KEY_PageUp              = 266;
    public static final int KEY_PageDown            = 267;
    public static final int KEY_Home                = 268;
    public static final int KEY_End                 = 269;
    public static final int KEY_CapsLock            = 280;
    public static final int KEY_ScrollLock          = 281;
    public static final int KEY_NumLock             = 282;
    public static final int KEY_PrintScreen         = 283;
    public static final int KEY_Pause               = 284;
    public static final int KEY_F1                  = 290;
    public static final int KEY_F2                  = 291;
    public static final int KEY_F3                  = 292;
    public static final int KEY_F4                  = 293;
    public static final int KEY_F5                  = 294;
    public static final int KEY_F6                  = 295;
    public static final int KEY_F7                  = 296;
    public static final int KEY_F8                  = 297;
    public static final int KEY_F9                  = 298;
    public static final int KEY_F10                 = 299;
    public static final int KEY_F11                 = 300;
    public static final int KEY_F12                 = 301;
    public static final int KEY_F13                 = 302;
    public static final int KEY_F14                 = 303;
    public static final int KEY_F15                 = 304;
    public static final int KEY_F16                 = 305;
    public static final int KEY_F17                 = 306;
    public static final int KEY_F18                 = 307;
    public static final int KEY_F19                 = 308;
    public static final int KEY_F20                 = 309;
    public static final int KEY_F21                 = 310;
    public static final int KEY_F22                 = 311;
    public static final int KEY_F23                 = 312;
    public static final int KEY_F24                 = 313;
    public static final int KEY_F25                 = 314;

    /* Keypad */
    public static final int KEY_KP0                 = 320;
    public static final int KEY_KP1                 = 321;
    public static final int KEY_KP2                 = 322;
    public static final int KEY_KP3                 = 323;
    public static final int KEY_KP4                 = 324;
    public static final int KEY_KP5                 = 325;
    public static final int KEY_KP6                 = 326;
    public static final int KEY_KP7                 = 327;
    public static final int KEY_KP8                 = 328;
    public static final int KEY_KP9                 = 329;
    public static final int KEY_KPDecimal           = 330;
    public static final int KEY_KPDivide            = 331;
    public static final int KEY_KPMultiply          = 332;
    public static final int KEY_KPSubtract          = 333;
    public static final int KEY_KPAdd               = 334;
    public static final int KEY_KPEnter             = 335;
    public static final int KEY_KPEqual             = 336;

    public static final int KEY_LeftShift           = 340;
    public static final int KEY_LeftControl         = 341;
    public static final int KEY_LeftAlt             = 342;
    public static final int KEY_LeftSuper           = 343;
    public static final int KEY_RightShift          = 344;
    public static final int KEY_RightControl        = 345;
    public static final int KEY_RightAlt            = 346;
    public static final int KEY_RightSuper          = 347;
    public static final int KEY_Menu                = 348;
    
    public static final int BUTTON_Left   = 0;
    public static final int BUTTON_Right  = 1;
    public static final int BUTTON_Middle = 2;
	
    private static final int keysNum = 349, buttonsNum = 8;
    
	private static Input instance;
	private static boolean[] keys = new boolean[keysNum], lastKeys = new boolean[keysNum];
	private static boolean[] buttons = new boolean[buttonsNum], lastButtons = new boolean[buttonsNum];
	private static boolean isDragging;
	
	private static Vector2 mousePos = new Vector2(), lastMousePos = new Vector2(), deltaMousePos = new Vector2(), mouseScroll = new Vector2();
	
	private Input()
	{
		
	}
	
	protected void finalize() {
		Destroy();
	}
	
	private void Destroy() {
		
	}
	
	public static Input Get() {
        if (Input.instance == null) {
        	Input.instance = new Input();
        }

        return Input.instance;
	}
	
	public static void Update() {
		for(int i = 0; i < keys.length; i++) {
			lastKeys[i] = keys[i];
		}
		
		for(int i = 0; i < buttons.length; i++) {
			lastButtons[i] = buttons[i];
		}
		
		deltaMousePos.Set(lastMousePos.x - mousePos.x, lastMousePos.y - mousePos.y);

		mouseScroll.Set(0, 0);
		lastMousePos.Set(mousePos);

		GLFW.glfwPollEvents();
	}

	public static boolean IsKeyPressed(int key) {
		if(key < keysNum)
			return !lastKeys[key] && keys[key];

		return false;
	}
	
	public static boolean IsKeyDown(int key) {
		if(key < keysNum)
			return lastKeys[key] && keys[key];
		
		return false;
	}
	
	public static boolean IsKeyReleased(int key) {
		if(key < keysNum)
			return lastKeys[key] && !keys[key];
		
		return false;
	}
	
	public static boolean IsButtonPressed(int button){
		if(button < buttonsNum)
			return !lastButtons[button] && buttons[button];

		return false;
	}
	
	public static boolean IsButtonDown(int button) {
		if(button < buttonsNum)
			return lastButtons[button] && buttons[button];

		return false;
	}
	
	public static boolean IsButtonReleased(int button) {
		if(button < buttonsNum)
			return lastButtons[button] && !buttons[button];

		return false;
	}
	
	public static boolean IsMouseDragging() {
		return isDragging;
	}

	public static Vector2 GetMousePos() {
		return mousePos;
	}
	
	public static Vector2 GetMouseDeltaPos() {
		return deltaMousePos;
	}
	
	public static Vector2 GetMousScroll() {
		return mouseScroll;
	}
	
	public static void KeyCallback(long window, int key, int scanCode, int action, int mod) {
		lastKeys[key] = keys[key];
		keys[key] = (action != GLFW.GLFW_RELEASE);
	}
	
	public static void MouseButtonCallback(long window, int button, int action, int mod) {
		buttons[button] = (action != GLFW.GLFW_RELEASE);
		isDragging = (action != GLFW.GLFW_RELEASE);
	}
	
	public static void MousePosCallback(long window, double x, double y) {
		lastMousePos.Set(mousePos);
		mousePos.Set((float)x, (float)y);
	}
	
	public static void MouseScrollCallback(long window, double x, double y) {
		mouseScroll.Set((float)x, (float)y);
	}
}