package com.github.amlcurran.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/**
 * This material style drawer will adjust the showcase to the size of the view
 */
public class MorphShowcaseDrawer implements ShowcaseDrawer {

	private final float DEFAULT_RADIUS;
    private float viewRadius;
	private float showcaseRadius;   // radius plus margin
    private final Paint basicPaint;
    private final Paint eraserPaint;
    private int backgroundColor;
	private final int margin;

    public MorphShowcaseDrawer(Resources resources) {
		this(resources, 0);
    }

	/**
	 * Showcase drawer that morphs to the size of the view + a margin
	 * @param resources context resources
	 * @param margin margin to be added to all sides
	 */
	public MorphShowcaseDrawer(Resources resources, int margin) {
		DEFAULT_RADIUS = resources.getDimension(R.dimen.showcase_radius_material);
		this.eraserPaint = new Paint();
		this.eraserPaint.setColor(0xFFFFFF);
		this.eraserPaint.setAlpha(0);
		this.eraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
		this.eraserPaint.setAntiAlias(true);
		this.basicPaint = new Paint();
		this.margin = margin;
	}

    @Override
    public void setShowcaseColour(int color) {
        // no-op
    }

    @Override
    public void drawShowcase(Bitmap buffer, float x, float y, float scaleMultiplier) {
        Canvas bufferCanvas = new Canvas(buffer);
        bufferCanvas.drawCircle(x, y, showcaseRadius, eraserPaint);
    }

    @Override
    public int getShowcaseWidth() {
        return (int) (showcaseRadius * 2);
    }

    @Override
    public int getShowcaseHeight() {
        return (int) (showcaseRadius * 2);
    }

    @Override
    public float getBlockedRadius() {
        return showcaseRadius;
    }

    @Override
    public void setBackgroundColour(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void erase(Bitmap bitmapBuffer) {
        bitmapBuffer.eraseColor(backgroundColor);
    }

    @Override
    public void drawToCanvas(Canvas canvas, Bitmap bitmapBuffer) {
        canvas.drawBitmap(bitmapBuffer, 0, 0, basicPaint);
    }

    @Override
    public void setShowcaseRadius(float radius)
    {
	    if (radius > 0)
	    {
		    this.viewRadius = radius;

	    }
	    else
	    {
		    this.viewRadius = DEFAULT_RADIUS;
	    }
	    this.showcaseRadius = viewRadius + margin;
    }
}
