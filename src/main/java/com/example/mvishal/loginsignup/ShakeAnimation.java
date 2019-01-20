package com.example.mvishal.loginsignup;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/**
 * Created by MVishal on 1/20/2019.
 */

public class ShakeAnimation {


    public static void shakeAnim(View view) {
        Animation shake = AnimationUtils.loadAnimation(view.getContext(), R.anim.shake);
        view.startAnimation(shake);

    }

    public static Animation expandCollapse(final View v, final boolean expand,
                                           final int duration) {
        int currentHeight = v.getLayoutParams().height;
        v.measure(
                View.MeasureSpec.makeMeasureSpec(
                        ((View) v.getParent()).getMeasuredWidth(),
                        View.MeasureSpec.AT_MOST), View.MeasureSpec.makeMeasureSpec(0,
                        View.MeasureSpec.UNSPECIFIED));
        final int initialHeight = v.getMeasuredHeight();
        if ((expand && currentHeight == initialHeight)
                || (!expand && currentHeight == 0))
            return null;
        if (expand)
            v.getLayoutParams().height = 0;
        else
            v.getLayoutParams().height = initialHeight;
        v.setVisibility(View.VISIBLE);

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime,
                                               Transformation t) {
                int newHeight = 0;
                if (expand)
                    newHeight = (int) (initialHeight * interpolatedTime);
                else
                    newHeight = (int) (initialHeight * (1 - interpolatedTime));
                v.getLayoutParams().height = newHeight;
                v.requestLayout();

                if (interpolatedTime == 1 && !expand)
                    v.setVisibility(View.GONE);
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration(duration);
        v.startAnimation(a);
        return a;
    }
}

