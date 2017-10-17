package com.wdeo3601.jfabulous.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.wdeo3601.jfabulous.R

/**
 * Created by wendong on 2017/10/13 0013.
 * Email:       wdeo3601@163.com
 * Description:
 */
class JFabulousView : View, View.OnClickListener {

    //点赞图标的颜色
    private var mFabulousIconColor = Color.RED
    //点赞数量文字的颜色
    private var mFabulousTextColor = Color.BLACK
    //点赞数量文字的大小
    private var mFabulousTextSize = 0F
    //是否显示点赞图标动画
    private var mShowIconAnimation = true
    //是否显示点赞数量变化时的动画
    private var mShowTextAnimation = true
    //当前显示的点赞数量
    private var mCurrentFabulousCount = 0
    private var mBeforeFabulousCount: CharArray? = null
    //是否已经点过赞了
    private var mHasFabulous = false

    //画图标的画笔
    lateinit var mIconPaint: Paint
    //画点赞数量的画笔
    lateinit var mTextPaint: Paint


    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
        initData(attrs)
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        //设置点击事件
        this.setOnClickListener(this)
    }

    /**
     * 初始化数据
     */
    private fun initData(attrs: AttributeSet?) {
        //拿到自定义的属性
        val attr = context.theme.obtainStyledAttributes(attrs, R.styleable.JFabulousView, 0, 0)
        mFabulousIconColor = attr.getColor(R.styleable.JFabulousView_fabulousIconColor, Color.RED)
        mFabulousTextColor = attr.getColor(R.styleable.JFabulousView_fabulousTextColor, Color.BLACK)
        mFabulousTextSize = attr.getDimension(R.styleable.JFabulousView_fabulousTextSize, 16F)
        mShowIconAnimation = attr.getBoolean(R.styleable.JFabulousView_showIconAnimation, true)
        mShowTextAnimation = attr.getBoolean(R.styleable.JFabulousView_showTextAnimation, true)
        mCurrentFabulousCount = attr.getInt(R.styleable.JFabulousView_currentFabulousNumber, 0)
        mHasFabulous = attr.getBoolean(R.styleable.JFabulousView_hasFabulous, false)

        //初始化图标画笔
        mIconPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mIconPaint.style = Paint.Style.STROKE
        mIconPaint.strokeWidth = 3F
        mIconPaint.color = mFabulousIconColor

        //初始化文本画笔
        mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mTextPaint.color = mFabulousTextColor
        mTextPaint.textSize = mFabulousTextSize
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //画数字
        drawFabulousCount(0F, canvas)
    }

    /**
     * 画点赞数量
     */
    private fun drawFabulousCount(startX: Float, canvas: Canvas?) {
        //拿到上次绘制的字符串长度
        val beforeLength = mBeforeFabulousCount?.size

        //把将要绘制的数字转化成字符串，并计算长度
        val countString = mCurrentFabulousCount.toString().toCharArray()
        val length = countString.size

        //计算开始绘制文字的起始位置
        var textX = startX
        val textY = mTextPaint.fontSpacing

        //找出变动的字符
        var startPosition = 0
        if (beforeLength != null && beforeLength == length) {
            for (i in 0 until length) {
                if (mBeforeFabulousCount!![i] != countString[i]) {
                    startPosition = i
                    break
                }
//                } else {
//                    textX += mTextPaint.measureText(countString[i].toString())
//                }
            }
        } else {
            startPosition = 0
        }

        for (i in 0 until length) {
            val drawingChar = countString[i].toString()
            textX += mTextPaint.measureText(drawingChar)
            canvas?.drawText(drawingChar, textX, textY, mTextPaint)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }

    override fun onClick(v: View?) {
        mBeforeFabulousCount = mCurrentFabulousCount.toString().toCharArray()
        var fabulousState = ""
        if (mHasFabulous) {
            fabulousState = "取消点赞，-1"
            reduceOneNumber()
        } else {
            fabulousState = "成功点赞，+1"
            addOneNumber()
        }
        mHasFabulous = !mHasFabulous
        Toast.makeText(context, fabulousState, Toast.LENGTH_LONG).show()
    }

    private fun reduceOneNumber() {
        mCurrentFabulousCount--
        invalidate()
    }

    private fun addOneNumber() {
        mCurrentFabulousCount++
        invalidate()
    }
}