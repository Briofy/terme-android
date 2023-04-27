package net.lynqfy.offical.card.typed.crypto

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import net.lynqfy.offical.R
import net.lynqfy.offical.callbacks.OnItemClickListener
import net.lynqfy.offical.card.LyCardAction
import com.google.android.material.R as MR
import net.lynqfy.offical.databinding.LyCryptoUiBinding
import net.lynqfy.offical.databinding.LyItemUiBinding
import net.lynqfy.offical.model.Badge
import net.lynqfy.offical.model.Header
import net.lynqfy.offical.model.Item

internal class CryptoIm(
    private var parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int
) : Crypto  {

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

    override fun addWallets(wallets: List<Item>) {
        wallets.forEach {
            createItemsUi(it)
        }
    }

    override fun onBadgeClicked(callback: () -> Unit) {
        if (mItemUis.isEmpty()) {
            throw IllegalStateException("Wallet list is Empty ... ")
        }
        mItemUis[0].badge.setOnClickListener {
            callback.invoke()
        }
    }

    override fun onOnItemClickListener(listener: OnItemClickListener) {
        mOnItemClickListener = listener
    }

    fun getItemCount() = mItemUis.size

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
        for (i in 0 until 5) {
            createItemsUi(Item(
                AppCompatResources
                    .getDrawable(parent.context, if (i%2==0) R.drawable.ic_help else R.drawable.external_link),"Sample Text $i", badge = Badge("Popular")
            ))
        }
    }

    private fun createItemsUi(item: Item) {
        mItems.add(item)

        LyItemUiBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {

            root.setOnClickListener {
                val index = mItemUis.indexOf(this)
                mOnItemClickListener?.onItemClicked(index, mItems[index])
            }
            content.text = item.name
            item.badge?.let {
                if (mItemUis.size == 0) {
                    badge.visibility = View.VISIBLE
                }
                badge.text = it.text
            }
            item.logo?.let {
                icon.setImageDrawable(it)
            }

            ui.listItem.addView(root)
            mItemUis.add(this)
        }
    }

    private val ui by lazy {
        LyCryptoUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }
    private val mItemUis: MutableList<LyItemUiBinding> = mutableListOf()
    private val mItems: MutableList<Item> = mutableListOf()
    private var mOnItemClickListener: OnItemClickListener? = null

    init {
        initCryptoTheme(attr, defStyleAttr)
    }
}