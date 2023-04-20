package ReNAQH.Events;

import java.lang.reflect.Method;

public class Observer {
	private Method subscriber;
	private final Object object;
	private final String connectedSignal;
	private final Class<?>[] arguments;
	private boolean isConnected = false;
	
	public Observer(String signalName, Object classObject, String methodName, Class<?>... args) {
		try {
			subscriber = classObject.getClass().getDeclaredMethod(methodName, args);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		object = classObject;
		connectedSignal = signalName;
		arguments = args;
	}
	
	protected void finalize() {
		Destroy();
	}
	
	public static void Destroy() {

	}
	
	public void Connect() {
		if(!isConnected) {
			SignalManger.Connect(this);
			isConnected = true;
		}
	}
	
	public String GetConnectSignal() {
		return connectedSignal;
	}
	
	public Object GetObject() {
		return object;
	}
	
	public Method GetSubscriber() {
		return subscriber;
	}
	
	public Class<?>[] GetArgumentTypes() {
		return arguments;
	}
}