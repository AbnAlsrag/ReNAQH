package ReNAQH.Core;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import ReNAQH.Components.Math.Transform;

public class GameObject {
	public String name;
	public Transform transform;

	private ArrayList<Component> components = new ArrayList<>();

	public GameObject(String name) {
		this.name = name;
		
		ObjectManger.AddObject(this);
	}

	protected void finalize() {
		Destroy();
	}

	public void Destroy() {
		for(int i = 0; i < components.size(); i++) {
			components.get(i).Destroy();
		}
	}

	public void Start() {
		for(int i = 0; i < components.size(); i++) {
			components.get(i).Start();
		}
	}

	public void Update() {
		for(int i = 0; i < components.size(); i++) {
			components.get(i).Update();
		}
	}

	public <T extends Component> void AddComponent(Class<T> component) {
		for(int i = 0; i < components.size(); i++) {
			if(component == components.get(i).getClass()) {
				return;
			}
		}
		
		Component addedComponent = null;

		try {
			addedComponent = component.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		components.add(addedComponent);
		addedComponent.gameObject = this;
	}

	public ArrayList<Component> GetAllComponents() {
		return components;
	}

	@SuppressWarnings("unchecked")
	public <T extends Component> T GetComponent(Class<T> component) {
		for(int i = 0; i < components.size(); i++) {
			if(component == components.get(i).getClass()) {
				return (T)components.get(i);
			}
		}

		return null;
	}

	public <T extends Component> void RemoveComponent(Class<T> component) {
		for(int i = 0; i < components.size(); i++) {
			if(component == components.get(i).getClass()) {
				components.get(i).Destroy();;
				components.remove(i);
				return;
			}
		}
	}
}