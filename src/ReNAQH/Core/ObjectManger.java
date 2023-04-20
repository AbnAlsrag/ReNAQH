package ReNAQH.Core;

import java.util.ArrayList;

public class ObjectManger {
	private static ObjectManger instance;
	private static ArrayList<GameObject> objects;
	
	private ObjectManger() {
		
	}
	
	@SuppressWarnings("unused")
	private static void Create() {
		if(instance == null) {
			instance = new ObjectManger();
		}
		
		if(objects == null) {
			objects = new ArrayList<>();
		}
	}
	
	protected void finalize() {
		Destroy();
	}
	
	private static void Destroy()
	{
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).Destroy();
			objects.remove(i);
		}
	}
	
	@SuppressWarnings("unused")
	private static void Start() {
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).IsEnabled()) {
				objects.get(i).Start();				
			}
		}
	}
	
	@SuppressWarnings("unused")
	private static void Update() {
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).IsEnabled()) {
				objects.get(i).Update();				
			}
		}
	}
	
	@SuppressWarnings("unused")
	private static void AddObject(GameObject object) {
		for(int i = 0; i < objects.size(); i++) {
			if(object.name == objects.get(i).name) {
				return;				
			}
		}
		
		objects.add(object);
	}
	
	@SuppressWarnings("unused")
	private static GameObject GetObject(String name) {
		for(int i = 0; i < objects.size(); i++) {
			if(name == objects.get(i).name) {
				return objects.get(i);
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unused")
	private static void RemoveObject(String name) {
		for(int i = 0; i < objects.size(); i++) {
			if(name == objects.get(i).name) {
				objects.get(i).Destroy();
				objects.remove(i);
			}
		}
	}
}