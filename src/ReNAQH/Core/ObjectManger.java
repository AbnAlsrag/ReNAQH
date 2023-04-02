package ReNAQH.Core;

import java.util.ArrayList;
import java.util.List;

public class ObjectManger {
	private static ObjectManger instance;
	private static List<GameObject> objects;
	
	private ObjectManger() {
		
	}
	
	public static void Create() {
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
	
	public static void Destroy()
	{

	}
	
	public static void Start() {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).Start();
		}
	}
	
	public static void Update() {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).Update();
		}
	}
	
	public static void AddObject(GameObject object) {
		for(int i = 0; i < objects.size(); i++) {
			if(object.name == objects.get(i).name) {
				return;				
			}
		}
		
		objects.add(object);
	}
	
	public static GameObject GetObject(String name) {
		for(int i = 0; i < objects.size(); i++) {
			if(name == objects.get(i).name) {
				return objects.get(i);
			}
		}
		
		return null;
	}
	
	public static void RemoveObject(String name) {
		for(int i = 0; i < objects.size(); i++) {
			if(name == objects.get(i).name) {
				objects.remove(i);
			}
		}
	}
}