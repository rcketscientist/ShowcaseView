package com.github.espiandev.showcaseview;

import android.content.Context;
import android.widget.Button;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ConfigOptionsTests {

    ShowcaseView mShowcaseView;

    @Mock
    Context mMockContext;
    @Mock
    Button mMockButton;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mShowcaseView = new ShowcaseView(mMockContext);
        mShowcaseView.mEndButton = mMockButton;
    }

}
