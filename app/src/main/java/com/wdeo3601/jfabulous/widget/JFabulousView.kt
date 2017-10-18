package com.wdeo3601.jfabulous.widget

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.wdeo3601.jfabulous.R

/**
 * Created by wendong on 2017/10/13 0013.
 * Email:       wdeo3601@163.com
 * Description:
 */
class JFabulousView : LinearLayout, View.OnClickListener {

    private val normalTextView = TextView(context)
    private val jFabulousTextWitcher = JFabulousSwitcher(context)

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

    //是否已经点过赞了
    private var mHasFabulous = false

    //画图标的画笔
    lateinit var mIconPaint: Paint

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
        mFabulousTextColor = attr.getColor(R.styleable.JFabulousView_fabulousTextColor, Color.BLACK)
        mFabulousTextSize = attr.getDimension(R.styleable.JFabulousView_fabulousTextSize, 18F)
        mShowIconAnimation = attr.getBoolean(R.styleable.JFabulousView_showIconAnimation, true)
        mShowTextAnimation = attr.getBoolean(R.styleable.JFabulousView_showTextAnimation, true)
        mCurrentFabulousCount = attr.getInt(R.styleable.JFabulousView_currentFabulousNumber, 0)
        mHasFabulous = attr.getBoolean(R.styleable.JFabulousView_hasFabulous, false)

        //点赞图标


        normalTextView.setTextColor(mFabulousTextColor)
        normalTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mFabulousTextSize)
        jFabulousTextWitcher.initData(mFabulousTextColor, mFabulousTextSize)

        divideTextIndex(mCurrentFabulousCount)


        addView(normalTextView)
        addView(jFabulousTextWitcher)
    }

    /**
     * 划分文本为需要变换的和不需要变换的
     */
    private fun divideTextIndex(number: Int) {
        //计算将要变成的下一个数
        val nextNumber: Int = if (mHasFabulous) {
            number - 1
        } else {
            number + 1
        }

        //转换成字符串进行比较
        val currentNumberStr = number.toString()
        val nextNumberStr = nextNumber.toString()

        var unSelectedText: String
        var selectedText: String
        if (currentNumberStr.length != nextNumberStr.length) {
            if (mHasFabulous) {
                selectedText = currentNumberStr
                unSelectedText = nextNumberStr
            } else {
                selectedText = nextNumberStr
                unSelectedText = currentNumberStr
            }
            normalTextView.text = ""
            jFabulousTextWitcher.setSelectAndText(mHasFabulous, selectedText, unSelectedText)
        } else {
            for (i in 0 until currentNumberStr.length) {
                if (currentNumberStr[i] != nextNumberStr[i]) {
                    if (mHasFabulous) {
                        selectedText = currentNumberStr.substring(i)
                        unSelectedText = nextNumberStr.substring(i)
                    } else {
                        selectedText = nextNumberStr.substring(i)
                        unSelectedText = currentNumberStr.substring(i)
                    }
                    normalTextView.text = mCurrentFabulousCount.toString().substring(0, i)
                    jFabulousTextWitcher.setSelectAndText(mHasFabulous, selectedText, unSelectedText)
                    return
                }
            }
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }

    override fun onClick(v: View?) {
        jFabulousTextWitcher.setSelect()
    }

    fun setCurrentFabulousCount(fabulousCount: Int) {
        this.mCurrentFabulousCount = fabulousCount
        divideTextIndex(mCurrentFabulousCount)
        invalidate()
    }
    fun setSelect(isselect:Boolean){
        this.mHasFabulous = isselect
        divideTextIndex(mCurrentFabulousCount)
        invalidate()
    }

}