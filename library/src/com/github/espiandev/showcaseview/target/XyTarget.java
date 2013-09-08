package com.github.espiandev.showcaseview.target;

import android.graphics.Point;

public class XyTarget implements Target {

    final Point mPoint;

    public XyTarget(int x, int y) {
        mPoint = new Point(x, y);
    }

    @Override
    public Point getTargetPoint() {
        return mPoint;
    }

    public int getX() {
        return mPoint.x;
    }

    public void setX(int x) {
        mPoint.x = x;
    }

    public int getY() {
        return mPoint.y;
    }

    public void setY(int y) {
        mPoint.y = y;
    }
}
