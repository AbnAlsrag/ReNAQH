package ReNAQH.Events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

//TODO: Optimize :) (I Love My Self)
//TODO: It's Very Slow Optimize It PLEASE (FUCK ME!)

public class SignalManger {
	private static SignalManger instance;
	private static ArrayList<Observer> observers = new ArrayList<Observer>();
	private static ArrayList<Signal> signals = new ArrayList<Signal>();
	
	private SignalManger() {
		
	}
	
	public static void Create() {
		if(instance == null) {
			instance = new SignalManger();
		}
	}
	
	protected void finalize() {
		Destroy();
	}
	
	public static void Destroy()
	{

	}

	public static void Connect(Observer observer) {
		observers.add(observer);
		
		for(Signal signal : signals) {
			try {
				Method update = signal.getClass().getDeclaredMethod("Update");
				update.setAccessible(true);
				update.invoke(signal);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean AddSignal(Signal signal) {
		for(Signal s : signals) {
			if(signal.GetName() == s.GetName()) {
				return false;
			}
		}
		
		signals.add(signal);
		return true;
	}
	
	public static ArrayList<Observer> GetObservers(String signalName) {
		ArrayList<Observer> result = new ArrayList<Observer>();
		
		for(Observer observer : observers) {
			if(observer.GetConnectSignal() == signalName) {
				result.add(observer);
			}
		}
		
		return result;
	}
}