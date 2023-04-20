package net.lynqfy.offical.card

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.google.android.material.card.MaterialCardView
import net.lynqfy.offical.R
import com.google.android.material.R as MR
import net.lynqfy.offical.databinding.LyCardUiBinding
import net.lynqfy.offical.databinding.LyItemUiBinding
import net.lynqfy.offical.model.Header
import net.lynqfy.offical.model.Item
import timber.log.Timber

class LyCrypto : LyCardView {

    constructor(ctx: Context) : super(ctx, null) {
        initTheme(null)
    }

    constructor(mContext: Context, attr: AttributeSet) : super(mContext, attr) {
        initTheme(attr)
    }

    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        ctx,
        attr,
        defStyleAttr
    ) {
        initTheme(attr, defStyleAttr)
    }

    private val ui by lazy {
        LyCardUiBinding.inflate(LayoutInflater.from(context), this, true)
    }


    fun setHeader(header: Header) {
        ui.title.text = header.title
        ui.body.text = header.body
    }

    private fun createItemUi(item: Item) {
        val card = MaterialCardView(context)

    }

    fun addWallet(item: Item) {

    }

    fun addWallets(wallets: List<Item>) {

    }

    fun setHelperMessage(helper: String) {
        ui.helper.text = helper
    }

    /* fun inflateHeaderView(@LayoutRes res: Int): View? {
         return presenter.inflateHeaderView(res)
     }*/
    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

        Timber.e("")
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att, R.styleable.LyCrypto, defStyleAttr, MR.style.Widget_MaterialComponents_CardView
            )
            attributes.getString(R.styleable.LyCrypto_headerTitle)?.let {
                ui.title.text = it
            }

            attributes.getString(R.styleable.LyCrypto_headerBody)?.let {
                ui.body.text = it
            }

            attributes.getString(R.styleable.LyCrypto_helperText)?.let {
                ui.helper.text = it
            }
            itemCount = attributes.getInteger(R.styleable.LyCrypto_itemCount, 0)

            attributes.recycle()
        }


        radius = 18f
        useCompatPadding = true

        for (i in 0 until itemCount) {
            LyItemUiBinding.inflate(LayoutInflater.from(context), this, false).apply {
                content.text = "M TEST ${i + 1}"
                root.setOnClickListener {
                    Toast.makeText(context, "You Clicked : ${content.text}", Toast.LENGTH_LONG)
                        .show()
                }
                mItemUis.add(this)
                if (i == 0) {
                    badge.visibility = View.VISIBLE
                }
                ui.listItem.addView(root)
            }
        }
        invalidate()
        requestLayout()
    }

    private val mItemUis: MutableList<LyItemUiBinding> = mutableListOf()

    private var itemCount = 0
}