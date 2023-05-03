package net.lynqfy.offical.navbar.type.simple

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import net.lynqfy.offical.databinding.LyCryptoUiBinding

internal class SimpleMegaMenu(
    private var parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int
) : Simple {










    private val ui by lazy {
        //Ly.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    override fun initTheme(attrs: AttributeSet?, defStyleAttr: Int) {
        TODO("Not yet implemented")
    }

    override fun initUI() {
        TODO("Not yet implemented")
    }

}