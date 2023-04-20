package Game;

import ReNAQH.Core.Application;
import ReNAQH.Core.Component;
import ReNAQH.Events.Observer;
import ReNAQH.Renderer.Window;

public class GameManger extends Component {
	private Observer observer = new Observer("Test", this, "printer", String.class);

	public void Start() {
		observer.Connect();
	}
	
	public void Update() {
		Window.SetTitle("ReNAQH | FPS: " + Application.GetFrames());
	}
	
	public void printer(String str) {
		System.out.println(str + ", " + Application.GetFrames());
	}
}