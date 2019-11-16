package me.saket.nestedscrollingbug;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;

public class RecyclerViewContainerLayout extends FrameLayout implements NestedScrollingParent {

  public RecyclerViewContainerLayout(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int nestedScrollAxes) {
    return true;
  }

  @Override
  public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed) {
    Log.i("RVCL", "onNestedPreScroll()");
  }
}
