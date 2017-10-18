package com.wdeo3601.jfabulous.widget

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.util.AttributeSet
import android.view.animation.DecelerateInterpolator
import android.widget.TextView

/**
 * Created by wendong on 2017/10/18 0018.
 * Email:       wdeo3601@163.com
 * Description:放置变化的数量的textview（带出场入场动画）
 */
class JFabulousSwitcher : TextView, Animator.AnimatorListener {


    //选中的文本
    private var mSelectedText = "1"
    //未选中的文本
    private var mUnselectedText = "0"
    //是否已经选中
    private var hasSelected = false

    private var isAnimRunning = false

    //选中时显示数字需要用到的path
    private lateinit var mSelectedPath: Path
    //未选中时显示数字需要用到的path
    private lateinit var mUnselectedPath: Path

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    /**
     * 初始化操作
     */
    private fun init() {
        paint.isAntiAlias = true
        paint.textSize = 16f
        paint.color = Color.BLACK

        textSize = paint.textSize
        text = "9999"

        post {
            mSelectedPath = Path()
            mUnselectedPath = Path()

            if (hasSelected) {
                mSelectedPath.moveTo(0.0f, height - paint.fontMetrics.bottom)
                mSelectedPath.lineTo(width.toFloat(), height - paint.fontMetrics.bottom)

                mUnselectedPath.moveTo(0.0f, -paint.fontMetrics.bottom)
                mUnselectedPath.lineTo(width.toFloat(), -paint.fontMetrics.bottom)
            } else {
                mUnselectedPath.moveTo(0.0f, height - paint.fontMetrics.bottom)
                mUnselectedPath.lineTo(width.toFloat(), height - paint.fontMetrics.bottom)

                mSelectedPath.moveTo(0.0f, (2 * height) - paint.fontMetrics.bottom)
                mSelectedPath.lineTo(width.toFloat(), (2 * height) - paint.fontMetrics.bottom)
            }
        }
        invalidate()
    }

    fun initData(mFabulousTextColor: Int, mFabulousTextSize: Float) {
        paint.color = mFabulousTextColor
        paint.textSize = mFabulousTextSize
        invalidate()
    }


    fun setSelectAndText(mHasFabulous: Boolean, selectedText: String, unSelectedText: String) {
        hasSelected = mHasFabulous
        mSelectedText = selectedText
        mUnselectedText = unSelectedText
        invalidate()
    }


    fun setSelect() {
        if (!isAnimRunning) {
            doAnimation()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawTextOnPath(mSelectedText, mSelectedPath, 0.0f, 0.0f, paint)
        canvas?.drawTextOnPath(mUnselectedText, mUnselectedPath, 0.0f, 0.0f, paint)
    }

    private fun doAnimation() {
        val animator = ValueAnimator.ofFloat(0.0f, height.toFloat())
        animator.addUpdateListener { valueAnimator ->
            if (hasSelected) {
                //选中状态时点击，都是向下的动画
                mSelectedPath.reset()
                mSelectedPath.moveTo(0.0f, height - paint.fontMetrics.bottom + valueAnimator.animatedValue as Float)
                mSelectedPath.lineTo(width.toFloat(), height - paint.fontMetrics.bottom + valueAnimator.animatedValue as Float)

                mUnselectedPath.reset()
                mUnselectedPath.moveTo(0.0f, -paint.fontMetrics.bottom + valueAnimator.animatedValue as Float)
                mUnselectedPath.lineTo(width.toFloat(), -paint.fontMetrics.bottom + valueAnimator.animatedValue as Float)
            } else {
                //未选中状态时点击，都是向上的动画
                mUnselectedPath.reset()
                mUnselectedPath.moveTo(0.0f, height - paint.fontMetrics.bottom - valueAnimator.animatedValue as Float)
                mUnselectedPath.lineTo(width.toFloat(), height - paint.fontMetrics.bottom - valueAnimator.animatedValue as Float)

                mSelectedPath.reset()
                mSelectedPath.moveTo(0.0f, (2 * height) - paint.fontMetrics.bottom - valueAnimator.animatedValue as Float)
                mSelectedPath.lineTo(width.toFloat(), (2 * height) - paint.fontMetrics.bottom - valueAnimator.animatedValue as Float)
            }
            invalidate()
        }
        animator.interpolator = DecelerateInterpolator()
        animator.duration = 500
        animator.addListener(this)
        animator.start()
    }

    //region animation listener
    override fun onAnimationEnd(animation: Animator?) {
        hasSelected = !hasSelected
        isAnimRunning = false
    }

    override fun onAnimationStart(animation: Animator?) {
        isAnimRunning = true
    }

    override fun onAnimationRepeat(animation: Animator?) {
    }

    override fun onAnimationCancel(animation: Animator?) {
        isAnimRunning = false
    }

    //endregion

}