package com.github.espiandev.showcaseview.target;

import android.graphics.Point;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class XyTargetTests {

    @Test
    public void xyTargetReturnsCorrectPoint() throws Exception {
        int x = 56, y = 919;
        XyTarget xy = new XyTarget(x, y);
        Point p = xy.getTargetPoint();
        assertEquals(x, p.x);
        assertEquals(y, p.y);
    }

}
