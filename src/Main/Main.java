package Main;

import Game.GameManger;
import Game.Test;
import ReNAQH.Components.Renderer.SpriteRenderer;
import ReNAQH.Core.Application;
import ReNAQH.Core.ApplicationSpec;
import ReNAQH.Core.GameObject;
import ReNAQH.Math.Vector2;

public class Main {
	public static void main(String[] args) {
		ApplicationSpec appSpec = new ApplicationSpec();
		appSpec.name = "NAQH";
		appSpec.size = new Vector2(600, 600);

		Application.Create(appSpec);

		GameObject rect = new GameObject("MyRect");
		rect.AddComponent(SpriteRenderer.class);

		GameObject gameManger = new GameObject("Game Manger");
		gameManger.AddComponent(GameManger.class);
		
		GameObject observerTest = new GameObject("Observer");
		observerTest.AddComponent(Test.class);

		Application.Run();
	}
}