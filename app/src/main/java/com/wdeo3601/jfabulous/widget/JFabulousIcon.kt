package com.wdeo3601.jfabulous.widget

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.wdeo3601.jfabulous.R

/**
 * Created by wendong on 2017/10/18 0018.
 * Email:       wdeo3601@163.com
 * Description:点赞图标的自定义view
 */
class JFabulousIcon : RelativeLayout {
    private lateinit var unSelectImageView: ImageView
    private lateinit var selectedImageView: ImageView
    private lateinit var selectedShineImageView: ImageView
    private lateinit var selectedRippleView: RippleView

    private var unSelectMaxSize: Int = 0
    private var selectMaxSize: Int = 0
    private var totalselectSize: Float = 0F

    private lateinit var mAnimatorSet: AnimatorSet
    private lateinit var mValueAnimator: ValueAnimator

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        unSelectImageView = ImageView(context)
        unSelectImageView.setImageResource(R.drawable.ic_messages_like_unselected)

        selectedShineImageView = ImageView(context)
        selectedShineImageView.setImageResource(R.drawable.ic_messages_like_selected_shining)

        selectedImageView = ImageView(context)
        selectedImageView.setImageResource(R.drawable.ic_messages_like_selected)

        selectedRippleView = RippleView(context)

        addView(selectedRippleView)
        addView(selectedShineImageView)
        addView(selectedImageView)
        addView(unSelectImageView)

        calculateSize()
        initAnim()
    }

    private fun calculateSize() {
        val unSelectBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_messages_like_unselected)
        unSelectMaxSize = Math.max(unSelectBitmap.width, unSelectBitmap.height)
        val selectBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_messages_like_selected)
        selectMaxSize = Math.max(selectBitmap.width, selectBitmap.height)
        unSelectBitmap.recycle()
        selectBitmap.recycle()
        totalselectSize = (unSelectMaxSize + selectMaxSize).toFloat()
    }

    private fun initAnim() {
        mAnimatorSet = AnimatorSet()
        mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        var j = measuredWidth;
        var k = measuredHeight;
        var m = paddingLeft - paddingRight;
        var n = paddingTop - paddingBottom;
        var i1 = (unSelectMaxSize * getFavorScale()).toInt();
        var i2 = (j - i1) / 2;
        var i3 = (k - i1) / 2;
        var i4 = i2 + i1;
        var i5 = i3 + i1;
        unSelectImageView.layout(i2 + m, i3 + n, m + (i2 + i1), n + (i3 + i1));
        selectedImageView.layout(i2 + m, i3 + n, m + (i2 + i1), n + (i3 + i1));
        var i6 = (selectMaxSize * getFavorScale()).toInt();
        var i7 = i2 + (i1 - i6) / 2;
        var i8 = i3 - i6 / 2;
        selectedShineImageView.layout(i7 + m, i8 + n, m + (i7 + i6), n + (i6 + i8));
        selectedRippleView.layout(m + (i2 - i1 / 4), n + (i3 - i1 / 4), m + (i4 + i1 / 4), n + (i5 + i1 / 4));
    }

    private fun getFavorScale(): Float {
        return Math.max(measuredHeight, measuredWidth) / totalselectSize
    }

    class RippleView : View {
        private var mStrokeWidth: Float = 2.0F
        private lateinit var mCirclePaint: Paint

        constructor(context: Context?) : super(context) {
            init()
        }

        private fun init() {
            mCirclePaint = Paint(Paint.ANTI_ALIAS_FLAG)
            mCirclePaint.style = Paint.Style.STROKE
            mCirclePaint.color = Color.RED
            mCirclePaint.strokeWidth = mStrokeWidth

        }

        fun setRippleStrokeWidth(strokeWidth: Float) {
            mCirclePaint.strokeWidth = strokeWidth
            invalidate()
        }

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            canvas?.drawCircle(width / 2F, height / 2F, Math.min(width / 2, height / 2) - mStrokeWidth, mCirclePaint)
        }
    }
}