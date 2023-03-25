package ReNAQH.Renderer;

public class Color {
	public float r, g, b, a;

	public Color() {
		this.r = 0.0f;
		this.g = 0.0f;
		this.b = 0.0f;
		this.a = 1.0f;
	}

	public Color(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 1.0f;
	}

	public Color(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public void Set(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 1.0f;
	}

	public void Set(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public void Add(float num) {
		r = r + num;
		b = b + num;
		g = g + num;
	}
	
	public void Add(Color color) {
		r = r + color.r;
		b = b + color.b;
		g = g + color.g;
	}
}