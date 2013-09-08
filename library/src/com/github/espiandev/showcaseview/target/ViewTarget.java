package com.github.espiandev.showcaseview.target;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;

public class ViewTarget implements Target {

    final View mView;
    private boolean mInsertToDecor;

    public ViewTarget(View view) {
        mView = view;
    }

    public ViewTarget(Activity activity, int viewId) {
        mView = activity.findViewById(viewId);
    }

    public void setInsertToDecor(boolean insertToDecor) {
        mInsertToDecor = insertToDecor;
    }

    @Override
    public Point getTargetPoint() {
        Point topLeft = getTopLeftOfView();
        return new Point(topLeft.x + mView.getWidth() / 2, topLeft.y + mView.getHeight() / 2);
    }

    Point getTopLeftOfView() {
        if (mInsertToDecor) {
            int[] coordinates = new int[2];
            mView.getLocationInWindow(coordinates);
            return new Point(coordinates[0], coordinates[1]);
        } else {
            return new Point(mView.getLeft(), mView.getTop());
        }
    }

}
