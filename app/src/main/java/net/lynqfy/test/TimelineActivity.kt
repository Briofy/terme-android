package net.lynqfy.test

import TimelineAdapter
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import net.lynqfy.offical.timeline.LyTimelineView
import net.lynqfy.offical.timeline.TimelineDecorator

class TimelineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_time_line)

        findViewById<MaterialButton>(R.id.showList).setOnClickListener {
            findViewById<ConstraintLayout>(R.id.lll) .visibility = View.GONE
            findViewById<RecyclerView>(R.id.timeline_rv).let {
                it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                it.adapter = BaseAdapter((0..10).toList())

                val colorPrimary = TypedValue()
                val theme: Resources.Theme = theme
                theme.resolveAttribute(R.color.purple_200, colorPrimary, true)

                it.addItemDecoration(
                    TimelineDecorator(
                        position = TimelineDecorator.Position.Left,
                        indicatorColor = getColor(R.color.purple_200),
                        lineColor = getColor(R.color.purple_700)
                    )
                )

                it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        /* (it.layoutManager as? LinearLayoutManager)?.let {
                             if (it.findFirstCompletelyVisibleItemPosition() == 0)
                                 binding.fab.extend()
                             else
                                 binding.fab.shrink()
                         }*/
                    }
                })
            }
        }


    }
}


class BaseAdapter(private val items: List<Int>) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>(),
    TimelineAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.base_list_item, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.title.text = position.toString()
    }

    override fun getItemViewType(position: Int): Int {
        return 0;
    }

    override fun getItemCount(): Int = items.size

    override fun getIndicatorStyle(position: Int): LyTimelineView.IndicatorStyle{
        return if (position <= 1)
            LyTimelineView.IndicatorStyle.Checked
        else LyTimelineView.IndicatorStyle.Empty
    }

    override fun getLineStyle(position: Int): LyTimelineView.LineStyle? {
        if (position > 1)
            return LyTimelineView.LineStyle.Dashed
        return super.getLineStyle(position)
    }

    override fun getLinePadding(position: Int): Float? {
        if (position > 1)
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                16f,
                Resources.getSystem().displayMetrics
            )
        return super.getLinePadding(position)
    }

    class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
    }
}