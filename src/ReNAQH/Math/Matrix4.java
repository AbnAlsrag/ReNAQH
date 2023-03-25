package ReNAQH.Math;

public class Matrix4 {
	private float[][] matrix;
	
	public Matrix4() {
		matrix = new float[4][4];
	}
	
	public Matrix4 InitIdentity()
	{
		matrix[0][0] = 1;	matrix[0][1] = 0;	matrix[0][2] = 0;	matrix[0][3] = 0;
		matrix[1][0] = 0;	matrix[1][1] = 1;	matrix[1][2] = 0;	matrix[1][3] = 0;
		matrix[2][0] = 0;	matrix[2][1] = 0;	matrix[2][2] = 1;	matrix[2][3] = 0;
		matrix[3][0] = 0;	matrix[3][1] = 0;	matrix[3][2] = 0;	matrix[3][3] = 1;

		return this;
	}
	
	public Matrix4 InitTranslation(float x, float y, float z)
	{
		matrix[0][0] = 1;	matrix[0][1] = 0;	matrix[0][2] = 0;	matrix[0][3] = x;
		matrix[1][0] = 0;	matrix[1][1] = 1;	matrix[1][2] = 0;	matrix[1][3] = y;
		matrix[2][0] = 0;	matrix[2][1] = 0;	matrix[2][2] = 1;	matrix[2][3] = z;
		matrix[3][0] = 0;	matrix[3][1] = 0;	matrix[3][2] = 0;	matrix[3][3] = 1;
		
		return this;
	}
	
	public Matrix4 InitRotation(float x, float y, float z)
	{
		Matrix4 rx = new Matrix4();
		Matrix4 ry = new Matrix4();
		Matrix4 rz = new Matrix4();
		
		x = (float)Math.toRadians(x);
		y = (float)Math.toRadians(y);
		z = (float)Math.toRadians(z);
		
		rz.matrix[0][0] = (float)Math.cos(z);rz.matrix[0][1] = -(float)Math.sin(z);rz.matrix[0][2] = 0;				rz.matrix[0][3] = 0;
		rz.matrix[1][0] = (float)Math.sin(z);rz.matrix[1][1] = (float)Math.cos(z);rz.matrix[1][2] = 0;					rz.matrix[1][3] = 0;
		rz.matrix[2][0] = 0;					rz.matrix[2][1] = 0;					rz.matrix[2][2] = 1;					rz.matrix[2][3] = 0;
		rz.matrix[3][0] = 0;					rz.matrix[3][1] = 0;					rz.matrix[3][2] = 0;					rz.matrix[3][3] = 1;
		
		rx.matrix[0][0] = 1;					rx.matrix[0][1] = 0;					rx.matrix[0][2] = 0;					rx.matrix[0][3] = 0;
		rx.matrix[1][0] = 0;					rx.matrix[1][1] = (float)Math.cos(x);rx.matrix[1][2] = -(float)Math.sin(x);rx.matrix[1][3] = 0;
		rx.matrix[2][0] = 0;					rx.matrix[2][1] = (float)Math.sin(x);rx.matrix[2][2] = (float)Math.cos(x);rx.matrix[2][3] = 0;
		rx.matrix[3][0] = 0;					rx.matrix[3][1] = 0;					rx.matrix[3][2] = 0;					rx.matrix[3][3] = 1;
		
		ry.matrix[0][0] = (float)Math.cos(y);ry.matrix[0][1] = 0;					ry.matrix[0][2] = -(float)Math.sin(y);ry.matrix[0][3] = 0;
		ry.matrix[1][0] = 0;					ry.matrix[1][1] = 1;					ry.matrix[1][2] = 0;					ry.matrix[1][3] = 0;
		ry.matrix[2][0] = (float)Math.sin(y);ry.matrix[2][1] = 0;					ry.matrix[2][2] = (float)Math.cos(y);ry.matrix[2][3] = 0;
		ry.matrix[3][0] = 0;					ry.matrix[3][1] = 0;					ry.matrix[3][2] = 0;					ry.matrix[3][3] = 1;
		
		matrix = rz.Mul(ry.Mul(rx)).GetMatrix();
		
		return this;
	}
	
	public Matrix4 InitScale(float x, float y, float z)
	{
		matrix[0][0] = x;	matrix[0][1] = 0;	matrix[0][2] = 0;	matrix[0][3] = 0;
		matrix[1][0] = 0;	matrix[1][1] = y;	matrix[1][2] = 0;	matrix[1][3] = 0;
		matrix[2][0] = 0;	matrix[2][1] = 0;	matrix[2][2] = z;	matrix[2][3] = 0;
		matrix[3][0] = 0;	matrix[3][1] = 0;	matrix[3][2] = 0;	matrix[3][3] = 1;
		
		return this;
	}
	
	public Matrix4 InitPerspective(float fov, float aspectRatio, float zNear, float zFar)
	{
		float tanHalfFOV = (float)Math.tan(fov / 2);
		float zRange = zNear - zFar;
		
		matrix[0][0] = 1.0f / (tanHalfFOV * aspectRatio);	matrix[0][1] = 0;					matrix[0][2] = 0;	matrix[0][3] = 0;
		matrix[1][0] = 0;						matrix[1][1] = 1.0f / tanHalfFOV;	matrix[1][2] = 0;	matrix[1][3] = 0;
		matrix[2][0] = 0;						matrix[2][1] = 0;					matrix[2][2] = (-zNear -zFar)/zRange;	matrix[2][3] = 2 * zFar * zNear / zRange;
		matrix[3][0] = 0;						matrix[3][1] = 0;					matrix[3][2] = 1;	matrix[3][3] = 0;
		
		
		return this;
	}

	public Matrix4 InitOrthographic(float left, float right, float bottom, float top, float near, float far)
	{
		float width = right - left;
		float height = top - bottom;
		float depth = far - near;

		matrix[0][0] = 2/width;matrix[0][1] = 0;	matrix[0][2] = 0;	matrix[0][3] = -(right + left)/width;
		matrix[1][0] = 0;	matrix[1][1] = 2/height;matrix[1][2] = 0;	matrix[1][3] = -(top + bottom)/height;
		matrix[2][0] = 0;	matrix[2][1] = 0;	matrix[2][2] = -2/depth;matrix[2][3] = -(far + near)/depth;
		matrix[3][0] = 0;	matrix[3][1] = 0;	matrix[3][2] = 0;	matrix[3][3] = 1;

		return this;
	}

	public Matrix4 InitRotation(Vector3 forward, Vector3 up)
	{
		Vector3 f = forward.Normalized();
		
		Vector3 r = up.Normalized();
		r = r.Cross(f);
		
		Vector3 u = f.Cross(r);

		return InitRotation(f, u, r);
	}

	public Matrix4 InitRotation(Vector3 forward, Vector3 up, Vector3 right)
	{
		Vector3 f = forward;
		Vector3 r = right;
		Vector3 u = up;

		matrix[0][0] = r.x;	matrix[0][1] = r.x;	matrix[0][2] = r.x;	matrix[0][3] = 0;
		matrix[1][0] = u.x;	matrix[1][1] = u.x;	matrix[1][2] = u.x;	matrix[1][3] = 0;
		matrix[2][0] = f.x;	matrix[2][1] = f.x;	matrix[2][2] = f.x;	matrix[2][3] = 0;
		matrix[3][0] = 0;		matrix[3][1] = 0;		matrix[3][2] = 0;		matrix[3][3] = 1;

		return this;
	}

	public Vector3 Transform(Vector3 r)
	{
		return new Vector3(matrix[0][0] * r.x + matrix[0][1] * r.x + matrix[0][2] * r.x + matrix[0][3],
		                    matrix[1][0] * r.x + matrix[1][1] * r.x + matrix[1][2] * r.x + matrix[1][3],
		                    matrix[2][0] * r.x + matrix[2][1] * r.x + matrix[2][2] * r.x + matrix[2][3]);
	}
	
	public Matrix4 Mul(Matrix4 r)
	{
		Matrix4 res = new Matrix4();
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				res.Set(i, j, matrix[i][0] * r.Get(0, j) +
						matrix[i][1] * r.Get(1, j) +
						matrix[i][2] * r.Get(2, j) +
						matrix[i][3] * r.Get(3, j));
			}
		}
		
		return res;
	}
	
	public void SetMatrix(float[][] matrix) {
		this.matrix = matrix;
	}
	
	public float[][] GetMatrix(){
		return matrix;
	}
	
	public void Set(int x, int y, float value) {
		matrix[x][y] = value;
	}
	
	public float Get(int x, int y) {
		return matrix[x][y];
	}
}