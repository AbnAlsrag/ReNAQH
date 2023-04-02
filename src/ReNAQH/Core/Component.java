package ReNAQH.Core;

public abstract class Component {
	public GameObject gameObject = null;
	
	protected void finalize() {
		Destroy();
	}

	public final void Destroy() {
		OnExit();
	}

	public void Start() {
		
	}

	public void Update() {
		
	}
	
	public void OnDisable() {
		
	}

	public void OnExit() {
		
	}
}