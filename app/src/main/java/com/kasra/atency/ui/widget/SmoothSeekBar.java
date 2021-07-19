package com.kasra.atency.ui.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.SeekBar;

import androidx.appcompat.widget.AppCompatSeekBar;

public class SmoothSeekBar extends AppCompatSeekBar implements SeekBar.OnSeekBarChangeListener {

    private OnSeekBarChangeListener mOnSeekBarChangeListener;

    private boolean mNeedCallListener = true;

    private ValueAnimator mAnimator;

    public SmoothSeekBar(Context context) {
        super(context);

    }

    public SmoothSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public SmoothSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public void setThumb(Drawable thumb) {
        super.setThumb(thumb);
    }



    @Override
    public void setOnSeekBarChangeListener(
            OnSeekBarChangeListener onSeekBarChangeListener) {
        mOnSeekBarChangeListener = onSeekBarChangeListener;
        super.setOnSeekBarChangeListener(this);
    }

    @Override
    public void setProgress(final int progress) {
        final int currentProgress = getProgress();
        if (mAnimator != null) {
            mAnimator.cancel();
            mAnimator.removeAllUpdateListeners();
            mAnimator.removeAllListeners();
            mAnimator = null;
            mNeedCallListener = true;
        }
        mAnimator = ValueAnimator.ofInt(currentProgress, progress);
        mAnimator.setDuration(getResources().getInteger(android.R.integer.config_longAnimTime));
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.addUpdateListener(animation -> {
            int value = (int) animation.getAnimatedValue();
            mNeedCallListener = value == progress;
            SmoothSeekBar.super.setProgress(value);
        });
        mAnimator.start();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser || mNeedCallListener) {
            if (mOnSeekBarChangeListener != null) {
                mOnSeekBarChangeListener.onProgressChanged(seekBar, progress, fromUser);
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (mOnSeekBarChangeListener != null) {
            mOnSeekBarChangeListener.onStartTrackingTouch(seekBar);
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (mOnSeekBarChangeListener != null) {
            mOnSeekBarChangeListener.onStopTrackingTouch(seekBar);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                final int width = getWidth();
                final int available = width - getPaddingLeft() - getPaddingRight();
                int x = (int) event.getX();
                float scale;
                float progress = 0;
                if (x < getPaddingLeft()) {
                    scale = 0.0f;
                } else if (x > width - getPaddingRight()) {
                    scale = 1.0f;
                } else {
                    scale = (float) (x - getPaddingLeft()) / (float) available;
                }
                final int max = getMax();
                progress += scale * max;
                if (progress < 0) {
                    progress = 0;
                } else if (progress > max) {
                    progress = max;
                }

                if (Math.abs(progress - getProgress()) < 10)
                    return super.onTouchEvent(event);
                else
                    return false;
            default:
                return super.onTouchEvent(event);
        }

    }

}
