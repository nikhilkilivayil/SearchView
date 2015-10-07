package com.lapism.searchview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewAnimationUtils;


public class SearchViewAnimation {

    public static final int ANIMATION_DURATION = 250;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void revealIn(final View view, int duration) {

        int cx = view.getRight();
        int cy = view.getBottom();

        int initialRadius = 0;
        int finalRadius = Math.max(view.getWidth(), view.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, finalRadius);
        //anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(duration);
        view.setVisibility(View.VISIBLE);
        anim.start();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void revealOut(final View view, int duration) {

        int cx = view.getRight();
        int cy = view.getBottom();

        int initialRadius = view.getWidth();
        int finalRadius = 0;

        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, finalRadius);
        //anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(duration);
        anim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.GONE);
            }
        });
        anim.start();
    }

    public static void fadeIn(final View view, int duration) {
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0f);
        ViewCompat.animate(view).alpha(1f).setDuration(duration);
    }

    public static void fadeOut(final View view, int duration) {
        ViewCompat.animate(view).alpha(0f).setDuration(duration);
    }

}