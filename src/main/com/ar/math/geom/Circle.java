package com.ar.math.geom;

import com.ar.core.error.MissingImplementationError;
import com.ar.core.error.ValueError;
import com.ar.math.Maths;

/**
 * @author Alan Ross
 * @version 0.1
 */
public final class Circle implements IShape
{
	private Rect _bounds;
	private Point2D _center;
	private double _radius;

	/**
	 * Creates a new instance of Circle.
	 */
	public Circle( double x, double y, double radius )
	{
		_bounds = new Rect();
		_center = new Point2D();

		moveTo( x, y );

		this.setRadius( radius );
	}

	/**
	 * Creates a new instance of Circle.
	 */
	public Circle()
	{
		_bounds = new Rect();
		_center = new Point2D();

		moveTo( 0.0, 0.0 );

		this.setRadius( 0.0 );
	}

	/**
	 * @inheritDoc
	 */
	public void moveTo( double x, double y )
	{
		_center.x = Maths.round( x );
		_center.y = Maths.round( y );

		_bounds.setX( _center.x - _radius );
		_bounds.setY( _center.y - _radius );
	}

	/**
	 * @inheritDoc
	 */
	public void resizeTo( double width, double height )
	{
		throw new MissingImplementationError();
	}

	/**
	 * Returns the (number)area value.
	 */
	public double getArea()
	{
		return Math.PI * _radius * _radius;
	}

	/**
	 * Returns the perimeter.
	 */
	public double getPermieter()
	{
		return 2.0 * Math.PI * _radius;
	}

	/**
	 * @inheritDoc
	 */
	public boolean contains( double x, double y )
	{
		double xd = _center.x - x;
		double yd = _center.y - y;

		return ( Math.sqrt( xd * xd + yd * yd ) <= _radius );
	}

	/**
	 * @inheritDoc
	 */
	public boolean containsPoint( Point2D p )
	{
		return contains( p.x, p.y );
	}

	/**
	 * @inheritDoc
	 */
	public Rect getBounds()
	{
		return _bounds;
	}

	/**
	 * @inheritDoc
	 */
	public void dispose()
	{
		_bounds = null;
		_center = null;
	}

	/**
	 * The X coordinate of the circle.
	 */
	public double getX()
	{
		return _center.x;
	}

	/**
	 * The X coordinate of the circle.
	 */
	public void setX( double value )
	{
		_center.x = value;
	}

	/**
	 * The Y coordinate of the circle.
	 */
	public double getY()
	{
		return _center.y;
	}

	/**
	 * The Y coordinate of the circle.
	 */
	public void setY( double value )
	{
		_center.y = value;
	}

	/**
	 * The width of the circle.
	 */
	public double getWidth()
	{
		return _radius * 2;
	}

	/**
	 * The height of the circle.
	 */
	public double getHeight()
	{
		return _radius * 2;
	}

	/**
	 * The radius of the circle.
	 */
	public double getRadius()
	{
		return _radius;
	}

	/**
	 * The radius of the circle.
	 */
	public void setRadius( double value )
	{
		if( value < 0 )
		{
			throw new ValueError( "Radius can not be less than zero" );
		}

		_radius = value;

		_bounds.setWidth( _radius * 2 );
		_bounds.setHeight( _radius * 2 );
	}

	/**
	 * Creates and returns a string representation of the Circle object.
	 */
	@Override
	public String toString()
	{
		return "[Circle" +
				", x: " + getX() +
				", y: " + getY() +
				", radius: " + getRadius() + "]";
	}
}

