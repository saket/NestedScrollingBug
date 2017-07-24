package me.saket.nestedscrollingbug;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

public class RecyclerViewContainerLayout extends FrameLayout implements NestedScrollingParent {

  public RecyclerViewContainerLayout(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
    return true;
  }

  @Override
  public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
    Log.i("RVCL", "onNestedPreScroll()");
//    flingScroller.forceFinished(true);
//    float consumedY = attemptToConsumeScrollY(dy);
//    consumed[1] = (int) consumedY;
  }
}
