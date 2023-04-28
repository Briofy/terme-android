package net.lynqfy.offical.toast

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.drawable.DrawableUtils
import com.google.android.material.imageview.ShapeableImageView
import net.lynqfy.offical.R
import net.lynqfy.offical.databinding.LyToastUiBinding

class LyToast(
    ctx: Context,
    image: Drawable? = null,
    title: String? = null,
    msg: String? = null,
    private val action: () -> Unit
) : Dialog(ctx) {
    init {

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(R.layout.ly_toast_ui)

        findViewById<TextView>(R.id.title).text = title
        findViewById<TextView>(R.id.content).text = msg

        image?.let {
            findViewById<ShapeableImageView>(R.id.icon).setImageDrawable(it)
        }
        findViewById<MaterialButton>(R.id.actionButton).setOnClickListener {
            action.invoke()
            dismiss()
        }

        findViewById<ShapeableImageView>(R.id.close).setOnClickListener {
            dismiss()
        }
        window?.apply {
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }
}