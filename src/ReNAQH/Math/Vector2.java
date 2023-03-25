package ReNAQH.Math;

public class Vector2 {
	public float x, y;
	
	public Vector2() {
		x = 0.0f;
		y = 0.0f;
	}

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void Set(Vector2 vector) {
		this.x = vector.x;
		this.y = vector.y;
	}

	public void Set(float x, float y) {
		this.x = x;
		this.y = y;
	}
}