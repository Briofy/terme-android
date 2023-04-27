package net.lynqfy.offical.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseAlert<VB : ViewBinding>(private val inflate: Inflate<VB>) :
    DialogFragment() {

    protected lateinit var viewBinding: VB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = inflate.invoke(inflater, container, false)
        return viewBinding.root
    }


}