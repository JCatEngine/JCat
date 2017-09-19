package JGame.RenderSystem.Math;

public class Matrix {

	public double x1;
	public double y1;
	public double x2;
	public double y2;
	public double tx;
	public double ty;

	public Matrix(double x1,double y1,double x2,double y2,double tx,double ty) {
		
        this.x1 = x1;
      
        this.y1 = y1;
       
        this.x2 = x2;

        this.y2 = y2;
  
        this.tx = tx;
  
        this.ty = ty;

	}
	
	public Matrix()
	{
		this(1, 0, 0, 1, 0, 0);
	}
	
    public Matrix translate(double x, double y)
    {
        this.tx += x;
        this.ty += y;

        return this;
    }
    
    
    public Matrix scale(double x, double y)
    {
        this.x1 *= x;
        this.y1 *= y;
        this.x2 *= x;
        this.y2 *= y;
        this.tx *= x;
        this.ty *= y;

        return this;
    }
    
    /**
     * Applies a rotation transformation to the matrix.
     * @param angle The angle in radians.
     * @return
     */
    public Matrix rotate(double angle)
    {
    	double cos = Math.cos(angle);
    	double sin = Math.sin(angle);

    	double a1 = this.x1;
    	double c1 = this.x2;
    	double tx1 = this.tx;

        this.x1 = (a1 * cos) - (this.y1 * sin);
        this.y1 = (a1 * sin) + (this.y1 * cos);
        this.x2 = (c1 * cos) - (this.y2 * sin);
        this.y2 = (c1 * sin) + (this.y2 * cos);
        this.tx = (tx1 * cos) - (this.ty * sin);
        this.ty = (tx1 * sin) + (this.ty * cos);

        return this;
    }
	
    
    /**
     * Appends the given Matrix to this Matrix.
     * @param matrix
     * @return
     */
    public Matrix append(Matrix matrix)
    {
        double a1 = this.x1;
        double b1 = this.y1;
        double c1 = this.x2;
        double d1 = this.y2;

        this.x1 = (matrix.x1 * a1) + (matrix.y1 * c1);
        this.y1 = (matrix.x1 * b1) + (matrix.y1 * d1);
        this.x2 = (matrix.x2 * a1) + (matrix.y2 * c1);
        this.y2 = (matrix.x2 * b1) + (matrix.y2 * d1);

        this.tx = (matrix.tx * a1) + (matrix.ty * c1) + this.tx;
        this.ty = (matrix.tx * b1) + (matrix.ty * d1) + this.ty;

        return this;
    }
    
    /**
     * Resets this Matix to an identity (default) matrix.
     *
     */
    public Matrix identity()
    {
        this.x1 = 1;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 1;
        this.tx = 0;
        this.ty = 0;

        return this;
    }
    
    
    /**
     * Creates a new Matrix object with the same values as this one.
     *
     */
    public Matrix clone()
    {
        Matrix matrix = new Matrix();

        
        matrix.x1 = this.x1;
        matrix.y1 = this.y1;
        matrix.x2 = this.x2;
        matrix.y2 = this.y2;
        matrix.tx = this.tx;
        matrix.ty = this.ty;

        return matrix;
    }
}
