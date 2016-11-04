package com.ar.math.geom;

import com.ar.core.utils.IDisposable;

/**
 * @author Alan Ross
 * @version 0.1
 */
public interface IShape extends IDisposable
{
	/**
	 * Move the shape to given position.
	 */
	void moveTo( double x, double y );

	/**
	 * Resize the shape to the new width and height values.
	 */
	void resizeTo( double width, double height );

	/**
	 * Returns true if the shape contains the given x and y values, false otherwise.
	 */
	boolean contains( double x, double y );

	/**
	 * Return the bounds of the shape.
	 */
	Rect getBounds();
}

