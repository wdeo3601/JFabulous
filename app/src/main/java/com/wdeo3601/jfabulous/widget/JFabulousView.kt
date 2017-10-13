package com.wdeo3601.jfabulous.widget

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

/**
 * Created by wendong on 2017/10/13 0013.
 * Email:       wdeo3601@163.com
 * Description:
 */
class JFabulousView : LinearLayout, View.OnClickListener {

    private lateinit var ivFabulous: ImageView
    private lateinit var tvFabulousCount: TextView

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

        //创建 点赞图标的imageview
        ivFabulous = ImageView(context)

        //创建 点赞数量的textview
        tvFabulousCount = TextView(context)

        //设置水平布局
        orientation = HORIZONTAL

        

    }

    /**
     * 初始化数据
     */
    private fun initData(attrs: AttributeSet?) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }

    override fun onClick(v: View?) {
        Toast.makeText(context,"click",Toast.LENGTH_LONG).show()
    }
}