package Game;

import ReNAQH.Core.Component;
import ReNAQH.Core.GameObject;
import ReNAQH.Events.Input;
import ReNAQH.Events.Signal;

public class Test extends Component {
	private Signal sig = new Signal("Test", String.class);
	GameObject rect = GetObject("MyRect");
	
	
	public void Start() {
		
	}
	
	public void Update() {
		if(Input.IsButtonPressed(Input.BUTTON_Left)) {
			sig.Invoke("Hi!!");
			
			if(rect.IsEnabled()) {
				rect.Disable();
			}
			else {
				rect.Enable();
			}
		}
	}
}