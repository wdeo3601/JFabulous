package com.wdeo3601.jfabulous.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

/**
 * Created by wendong on 2017/10/18 0018.
 * Email:       wdeo3601@163.com
 * Description:点赞图标的自定义view
 */
class JFabulousIcon : RelativeLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {

    }
}