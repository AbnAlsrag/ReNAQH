package ReNAQH.Math;

public class Vector3 {
	public float x, y, z;
	
	public Vector3() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float Length()
	{
		return (float)Math.sqrt(x * x + y * y + z * z);
	}

	public float Max()
	{
		return Math.max(x, Math.max(y, z));
	}

	public float Dot(Vector3 r)
	{
		return x * r.x + y * r.y + z * r.z;
	}
	
	public Vector3 Cross(Vector3 r)
	{
		float x_ = y * r.z - z * r.y;
		float y_ = z * r.x - x * r.z;
		float z_ = x * r.y - y * r.x;
		
		return new Vector3(x_, y_, z_);
	}
	
	public Vector3 Normalized()
	{
		float length = Length();
		
		return new Vector3(x / length, y / length, z / length);
	}

	public Vector3 Rotate(Vector3 axis, float angle)
	{
		float sinAngle = (float)Math.sin(-angle);
		float cosAngle = (float)Math.cos(-angle);

		return this.Cross(axis.Mul(sinAngle)).Add(           //Rotation on local X
				(this.Mul(cosAngle)).Add(                     //Rotation on local Z
						axis.Mul(this.Dot(axis.Mul(1 - cosAngle))))); //Rotation on local Y
	}

//	public Vector3 Rotate(Quaternion rotation)
//	{
//		Quaternion conjugate = rotation.Conjugate();
//
//		Quaternion w = rotation.Mul(this).Mul(conjugate);
//
//		return new Vector3(w.x, w.y, w.z);
//	}

	public Vector3 Lerp(Vector3 dest, float lerpFactor)
	{
		return dest.Sub(this).Mul(lerpFactor).Add(this);
	}

	public Vector3 Add(Vector3 r)
	{
		return new Vector3(x + r.x, y + r.y, z + r.z);
	}
	
	public Vector3 Add(float r)
	{
		return new Vector3(x + r, y + r, z + r);
	}
	
	public Vector3 Sub(Vector3 r)
	{
		return new Vector3(x - r.x, y - r.y, z - r.z);
	}
	
	public Vector3 Sub(float r)
	{
		return new Vector3(x - r, y - r, z - r);
	}
	
	public Vector3 Mul(Vector3 r)
	{
		return new Vector3(x * r.x, y * r.y, z * r.z);
	}
	
	public Vector3 Mul(float r)
	{
		return new Vector3(x * r, y * r, z * r);
	}
	
	public Vector3 Div(Vector3 r)
	{
		return new Vector3(x / r.x, y / r.y, z / r.z);
	}
	
	public Vector3 Div(float r)
	{
		return new Vector3(x / r, y / r, z / r);
	}
	
	public Vector3 Abs()
	{
		return new Vector3(Math.abs(x), Math.abs(y), Math.abs(z));
	}
	
	public String ToString()
	{
		return "(" + x + ", " + y + ", " + z + ")";
	}

	public boolean Equals(Vector3 r)
	{
		return x == r.x && y == r.y && z == r.z;
	}
}