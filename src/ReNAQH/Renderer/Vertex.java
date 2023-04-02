package ReNAQH.Renderer;

import ReNAQH.Math.Vector2;
import ReNAQH.Math.Vector3;

public class Vertex {
	private Vector3 position;
	private Color color;
	private Vector2 uvCoords;

	public Vertex() {
		
	}

	public Vertex(Vector3 position, Vector2 uvCoords) {
		this.position = position;
		this.uvCoords = uvCoords;
	}

	public void SetPosition(Vector3 position) {
		this.position = position;
	}

	public void SetColor(Color color) {
		this.color = color;
	}

	public void SetUVCoords(Vector2 vector) {
		uvCoords = vector;
	}

	public Vector3 GetPosition() {
		return position;
	}

	public Color GetColor() {
		return color;
	}

	public Vector2 GetUVCoords() {
		return uvCoords;
	}
}