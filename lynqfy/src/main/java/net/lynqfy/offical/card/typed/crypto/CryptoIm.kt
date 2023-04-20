package net.lynqfy.offical.card.typed.crypto

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import net.lynqfy.offical.R
import com.google.android.material.R as MR
import net.lynqfy.offical.databinding.LyCryptoUiBinding
import net.lynqfy.offical.databinding.LyItemUiBinding
import net.lynqfy.offical.model.Badge
import net.lynqfy.offical.model.Header
import net.lynqfy.offical.model.Item

internal class CryptoIm(
    private  var parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int) : Crypto{

    override fun setHeaderInfo(header: Header) {
        ui.title.text = header.title
        ui.body.text = header.body
    }
    override fun setHelperMessage(helper: String) {
        ui.helper.text = helper
    }
    override fun addWallet(item: Item) {
        createItemsUi(item)
    }
    override  fun addWallets(wallets: List<Item>) {
        wallets.forEach {
            createItemsUi(it)
        }
    }
    fun getItemCount() = itemCount

    private fun initCryptoTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att, R.styleable.LyCrypto, defStyleAttr, MR.style.Widget_MaterialComponents_CardView
            )
            typedArray.getString(R.styleable.LyCardView_header)?.let {
                ui.title.text = it
            }
            typedArray.getString(R.styleable.LyCardView_body)?.let {
                ui.body.text = it
            }
            attributes.getString(R.styleable.LyCrypto_helperText)?.let {
                ui.helper.text = it
            }
            attributes.recycle()
        }
        generateTestContent()
    }

    private fun generateTestContent() {
        val item = Item(
            AppCompatResources
                .getDrawable(parent.context, R.drawable.ic_help), badge = Badge("Popular")
        )
        for (i in 0 until 5) {
            item.name = "Sample Text ${i + 1}"
            createItemsUi(item)
        }
    }

    private fun createItemsUi(item: Item) {
        LyItemUiBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            root.setOnClickListener {
                Toast.makeText(it.context, "You Clicked : ${content.text}", Toast.LENGTH_LONG).show()
            }
            content.text = item.name
            item.badge?.let {
                if (itemCount == 0) {
                    badge.visibility = View.VISIBLE
                }
                badge.text = it.text
            }
            item.logo?.let {
                icon.setImageDrawable(it)
            }

            ui.listItem.addView(root)
            mItemUis.add(this)
            itemCount++
        }
    }

    private val ui by lazy {
        LyCryptoUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }
    private val mItemUis: MutableList<LyItemUiBinding> = mutableListOf()
    private var itemCount = 0

    init {
        initCryptoTheme(attr, defStyleAttr)
    }
}