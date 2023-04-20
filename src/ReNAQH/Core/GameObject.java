package ReNAQH.Core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import ReNAQH.Components.Math.Transform;

//TODO: Optimize the component system(Adding and Removing) might use hash table

public class GameObject {
	public final String name;
	public Transform transform;

	private ArrayList<Component> components = new ArrayList<>();
	private boolean isEnabled = true;
	
	public GameObject(String name) {
		this.name = name;
		
		try {
			Method addObject = ObjectManger.class.getDeclaredMethod("AddObject", GameObject.class);
			addObject.setAccessible(true);
			addObject.invoke(null, this);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void finalize() {
		Destroy();
	}

	public void Destroy() {
		for(int i = 0; i < components.size(); i++) {
			components.get(i).Destroy();
		}
	}
	
	public void Remove() {
		try {
			Method removeObject = ObjectManger.class.getDeclaredMethod("RemoveObject", String.class);
			removeObject.setAccessible(true);
			removeObject.invoke(null, name);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
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
	
	public void Enable() {
		isEnabled = true;
	}
	
	public void Disable() {
		isEnabled = false;
	}
	
	public boolean IsEnabled() {
		return isEnabled;
	}
	
	public <T extends Component> void AddComponents(ArrayList<Class<T>> components) {
//		for(int i = 0; i < components.size(); i++) {
//			for(int j = 0; j < this.components.size(); j++) {
//				if(i)
//			}
//		}
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
			addedComponent.SetGameObject(this);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		components.add(addedComponent);
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
	
	public void RemoveAllComponents() {
		for(int i = 0; i < components.size(); i++) {
			components.get(i).Destroy();
			components.remove(i);
		}
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