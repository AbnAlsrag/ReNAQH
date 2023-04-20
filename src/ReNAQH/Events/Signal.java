package ReNAQH.Events;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

//TODO: OPTIMIZE MY SELF!!!!!!!
//TODO: Hide Update method and use reflection instead

public class Signal {
	private final String name;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private Class<?>[] argumentTypes;
	
	public Signal(String name, Class<?>... argumentTypes) {
		this.name = name;
		this.argumentTypes = argumentTypes;
		
		SignalManger.AddSignal(this);
	}
	
	protected void finalize() {
		Destroy();
	}
	
	public static void Destroy() {

	}
	
	public void Invoke(Object... args) {
		if(argumentTypes.length != args.length) {
			return;
		}
		
		for(int i = 0; i < argumentTypes.length; i++) {
			if(argumentTypes[i] != args[i].getClass()) {
				return;
			}
		}
		
		for(Observer observer : observers) {
			try {
				observer.GetSubscriber().setAccessible(true);
				observer.GetSubscriber().invoke(observer.GetObject(), args);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void Update() {
		observers = SignalManger.GetObservers(name);
	}
	
	public String GetName() {
		return name;
	}
}