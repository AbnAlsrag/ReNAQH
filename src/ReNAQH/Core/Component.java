package ReNAQH.Core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Component {
	private GameObject gameObject = null;
	
	protected void finalize() {
		Destroy();
	}

	public final void Destroy() {
		OnExit();
	}
	
	public final GameObject GetObject(String ObjectName) {
		GameObject result = null;
		
		try {
			Method method = ObjectManger.class.getDeclaredMethod("GetObject", String.class);
			method.setAccessible(true);
			result = (ReNAQH.Core.GameObject)method.invoke(null, ObjectName);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public final GameObject GameObject() {
		return gameObject;
	}
	
	public final void SetGameObject(GameObject gameObject) {
		this.gameObject = this.gameObject == null ? gameObject : this.gameObject;
	}

	public void OnEnable() {
		
	}

	public void Start() {
		
	}

	public void FixedUpdate() {
		
	}

	public void Update() {
		
	}
	
	public void LateUpdate() {
		
	}
	
	public void OnDisable() {
		
	}

	public void OnExit() {
		
	}
}