package com.ar.math.geom;

/**
 * Wrapper class to provide easy access to setting x, y, width and height values.
 * Note that negative width and height values are converted to zero.
 *
 * @author Alan Ross
 * @version 0.1
 */
public class Rect implements IShape
{
	private double _x;
	private double _y;
	private double _width;
	private double _height;

	/**
	 * Creates a new instance of Rect.
	 */
	public Rect( double x, double y, double width, double height )
	{
		moveTo( x, y );
		resizeTo( width, height );
	}

	/**
	 * Creates a new instance of Rect.
	 */
	public Rect()
	{
		moveTo( 0.0, 0.0 );
		resizeTo( 0.0, 0.0 );
	}

	/**
	 * Set the x, y, width and height values of the Rectangle.
	 * Negative width or height values are converted to 0.0.
	 */
	public void setTo( double x, double y, double width, double height )
	{
		moveTo( x, y );
		resizeTo( width, height );
	}

	/**
	 * Set the width and height values of the Rectangle.
	 * Negative values are converted to 0.0
	 */
	public void resizeTo( double width, double height )
	{
		_width = ( 0 > width ) ? 0 : width;
		_height = ( 0 > height ) ? 0 : height;
	}

	/**
	 * @inheritDoc
	 */
	public void moveTo( double x, double y )
	{
		_x = x;
		_y = y;
	}

	/**
	 * @inheritDoc
	 */
	public boolean contains( double x, double y )
	{
		return ( x >= _x && x <= _x + _width && y >= _y && y <= _y + _height );
	}

	/**
	 * @inheritDoc
	 */
	public Rect getBounds()
	{
		return this;
	}

	/**
	 * Frees all references of the object.
	 */
	public void dispose()
	{
	}

	public double getX()
	{
		return _x;
	}

	public void setX( double value )
	{
		_x = value;
	}

	public double getY()
	{
		return _y;
	}

	public void setY( double value )
	{
		_y = value;
	}

	public double getWidth()
	{
		return _width;
	}

	public void setWidth( double value )
	{
		_width = ( 0 > value ) ? 0 : value;
	}

	public double getHeight()
	{
		return _height;
	}

	public void setHeight( double value )
	{
		_height = ( 0 > value ) ? 0 : value;
	}

	@Override
	public String toString()
	{
		return "[Rect" +
				", x: " + _x +
				", y: " + _y +
				", width: " + _width +
				", height: " + _height + "]";
	}
}

