package com.lowpower.wanandroid.activity

import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager2.widget.ViewPager2
import com.lowpower.wanandroid.R
import com.lowpower.wanandroid.base.BaseActivity

class HomeActivity : BaseActivity() {
    private var TAG = "Demo#HomeActivity"
    private lateinit var llProject: LinearLayout
    private lateinit var llHome: LinearLayout
    private lateinit var llNavigation: LinearLayout
    private lateinit var llCollect: LinearLayout
    private lateinit var tvHint: AppCompatTextView
    private lateinit var viewPage: ViewPager2

    override fun initView() {
        llHome = findViewById(R.id.ll_home)
        llProject = findViewById(R.id.ll_project)
        llNavigation = findViewById(R.id.ll_navigation)
        llCollect = findViewById(R.id.ll_collect)
        tvHint = findViewById(R.id.tv_hint)
        viewPage = findViewById(R.id.viewpage)
        llHome?.isSelected = true

        llHome?.setOnClickListener {
            Log.w(TAG, "llHome isSelect ${llHome?.isSelected}")
            tvHint?.text = "首页"
            llHome?.isSelected = !llHome?.isSelected!!
            llProject?.isSelected = false
            llNavigation?.isSelected = false
            llCollect?.isSelected = false
        }

        llProject?.setOnClickListener {
            Log.w(TAG, "llProject isSelect ${llProject?.isSelected}")
            llProject?.isSelected = !llProject?.isSelected!!
            llHome?.isSelected = false
            llNavigation?.isSelected = false
            llCollect?.isSelected = false
            tvHint?.text = "项目"
        }
        llNavigation?.setOnClickListener {
            Log.w(TAG, "llNavigation isSelect ${llNavigation?.isSelected}")
            llNavigation?.isSelected = !llNavigation?.isSelected!!
            llHome?.isSelected = false
            llProject?.isSelected = false
            llCollect?.isSelected = false
            tvHint?.text = "导航"
        }
        llCollect?.setOnClickListener {
            Log.w(TAG, "llCollect isSelect ${llCollect?.isSelected}")
            llCollect?.isSelected = !llCollect?.isSelected!!
            llHome?.isSelected = false
            llProject?.isSelected = false
            llNavigation?.isSelected = false
            tvHint?.text = "收藏"

        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initData() {

    }
}