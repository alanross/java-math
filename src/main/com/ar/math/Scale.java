package com.ar.math;

import com.ar.core.error.ValueError;
import com.ar.math.geom.Point2D;
import com.ar.math.geom.Rect;

/**
 * @author Alan Ross
 * @version 0.1
 */
public final class Scale
{
	public static final int TYPE_FILL = 0;
	public static final int TYPE_FIT = 1;
	public static final int TYPE_STRETCH = 2;

	/**
	 * Returns the scale, whereas the scale.x is the horizontal scale and scale.y the vertical scale.
	 */
	public static Point2D getScale( double sw, double sh, double dw, double dh, int scaleType )
	{
		if( scaleType == TYPE_FILL )
		{
			double ratioFill = Math.max( dw / sw, dh / sh );

			return new Point2D( ratioFill, ratioFill );
		}
		else if( scaleType == TYPE_FIT )
		{
			double ratioFit = Math.min( dw / sw, dh / sh );

			return new Point2D( ratioFit, ratioFit );
		}
		else if( scaleType == TYPE_STRETCH )
		{
			return new Point2D( ( dw / sw ), ( dh / sh ) );
		}

		throw new ValueError( "Scale type is unknown." );
	}

	/**
	 * Returns a new rectangle holding the new width and height and a centered x/y relative to
	 * the given dest x/y.
	 */
	public static Rect getRect( Rect source, Rect dest, int scaleType )
	{
		final Rect result = new Rect();

		if( scaleType == TYPE_FILL )
		{
			double ratioFill = Math.max( dest.getWidth() / source.getWidth(), dest.getHeight() / source.getHeight() );

			result.setWidth( ratioFill * source.getWidth() );
			result.setHeight( ratioFill * source.getHeight() );
		}
		else if( scaleType == TYPE_FIT )
		{
			double ratioFit = Math.min( dest.getWidth() / source.getWidth(), dest.getHeight() / source.getHeight() );

			result.setWidth( ratioFit * source.getWidth() );
			result.setHeight( ratioFit * source.getHeight() );
		}
		else if( scaleType == TYPE_STRETCH )
		{
			result.setWidth( ( dest.getWidth() / source.getWidth() ) * source.getWidth() );
			result.setHeight( ( dest.getHeight() / source.getHeight() ) * source.getHeight() );
		}
		else
		{
			throw new ValueError( "Scale type is unknown." );
		}

		result.setX( dest.getX() + ( dest.getWidth() - result.getWidth() ) * 0.5 );
		result.setY( dest.getY() + ( dest.getHeight() - result.getHeight() ) * 0.5 );

		return result;
	}

	/**
	 * Creates a new instance of Scale.
	 */
	private Scale()
	{
	}

	/**
	 * Generates and returns the string representation of the Scale object.
	 */
	@Override
	public String toString()
	{
		return "[Scale]";
	}
}

