package com.lowpower.wanandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open abstract class BaseFragment : Fragment() {
    abstract fun initView(view: View)

    abstract fun getLayoutId(): Int

    abstract fun initData()

    abstract fun release()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(getLayoutId(), null, false)
        initView(view)
        initData()
        return view
    }

    override fun onDestroyView() {
        release()
        super.onDestroyView()
    }
}