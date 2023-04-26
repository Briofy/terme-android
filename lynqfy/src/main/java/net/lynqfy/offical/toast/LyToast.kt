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
    private val context: Context,
    private val image: Drawable? = null,
    private val title: String? = null,
    private val msg: String? = null,
    private val action: () -> Unit
)  {

     fun show() {

         val dialog = Dialog(context)
         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
         dialog.setCancelable(false)
         dialog.setContentView(R.layout.ly_toast_ui)

         dialog.findViewById<TextView>(R.id.title).text = title
         dialog.findViewById<TextView>(R.id.content).text = msg

        image?.let {
            dialog.findViewById<ShapeableImageView>(R.id.icon).setImageDrawable(it)
        }
         dialog.findViewById<MaterialButton>(R.id.actionButton).setOnClickListener {
            action.invoke()
            dialog.dismiss()
        }

         dialog.findViewById<ShapeableImageView>(R.id.close).setOnClickListener {
             dialog.dismiss()
         }
         dialog.window?.apply {
             setLayout(
                 ViewGroup.LayoutParams.MATCH_PARENT,
                 ViewGroup.LayoutParams.WRAP_CONTENT)
             setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
         }
//         val body = dialog.findViewById(R.id.body) as TextView
//         body.text = title
//         val yesBtn = dialog.findViewById(R.id.yesBtn) as Button
//         val noBtn = dialog.findViewById(R.id.noBtn) as Button
//         yesBtn.setOnClickListener {
//             dialog.dismiss()
//         }
//         noBtn.setOnClickListener {
//             dialog.dismiss()
//         }
         dialog.show()
    }
}