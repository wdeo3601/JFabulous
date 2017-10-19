package com.wdeo3601.jfabulous

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import android.widget.RadioGroup
import com.wdeo3601.jfabulous.widget.JFabulousView

class MainActivity : AppCompatActivity() {

    private lateinit var jFabulousView: JFabulousView
    private lateinit var etFabulousCount: EditText
    private lateinit var rgSelect: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jFabulousView = findViewById(R.id.j_fabulous_view)
        etFabulousCount = findViewById(R.id.et_fabulous_count)
        rgSelect = findViewById(R.id.rg_select)

        jFabulousView.setCurrentFabulousCount(etFabulousCount.text.toString().toInt())
        jFabulousView.setSelect(false)

        etFabulousCount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s) || s.toString().toInt() == 0) {
                    jFabulousView.setCurrentFabulousCount(0)
                    jFabulousView.setSelect(false)

                    rgSelect.check(R.id.rb_unselect)
                } else {
                    jFabulousView.setCurrentFabulousCount(s.toString().toInt())
                }
            }

        })

        rgSelect.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_unselect -> {
                    jFabulousView.setSelect(false)
                }
                R.id.rb_selected -> {
                    jFabulousView.setSelect(true)
                }
            }
            jFabulousView.setCurrentFabulousCount(etFabulousCount.text.toString().toInt())
        }
    }
}
