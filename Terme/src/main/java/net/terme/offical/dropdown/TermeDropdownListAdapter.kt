package net.terme.offical.dropdown

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import net.terme.offical.databinding.TermeDopdownListItemBinding


class TermeDropdownListAdapter(
    val mContext: Context,
    private val mList: List<TermeDropItem>
) : BaseAdapter() {
    override fun getCount(): Int = mList.size
    override fun getItem(position: Int) = mList[position]

    override fun getItemId(position: Int): Long = mList[position].id

    override fun getView(position: Int, cView: View?, parent: ViewGroup?): View {
        var viewHolder: ViewHolder? = null
        var convertView = cView

        convertView?.also {
            viewHolder = it.tag as ViewHolder
        } ?: run {
            val binder = TermeDopdownListItemBinding.inflate(LayoutInflater.from(mContext))
            viewHolder = ViewHolder(binder)
            convertView = binder.root
            convertView?.tag = viewHolder
        }
        viewHolder?.bind(getItem(position))
        return convertView!!
    }

    internal class ViewHolder internal constructor(private val binder: TermeDopdownListItemBinding) {

        fun bind(item: TermeDropItem) {
            binder.dropdownListItemText.text = item.text
            binder.dropdownListItemIcon.setImageDrawable(item.icon)
        }
    }

}