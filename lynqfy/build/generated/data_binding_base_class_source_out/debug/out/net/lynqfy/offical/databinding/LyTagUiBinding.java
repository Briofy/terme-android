// Generated by view binder compiler. Do not edit!
package net.lynqfy.offical.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import net.lynqfy.offical.R;

public final class LyTagUiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ShapeableImageView clear;

  @NonNull
  public final MaterialTextView tagTv;

  private LyTagUiBinding(@NonNull ConstraintLayout rootView, @NonNull ShapeableImageView clear,
      @NonNull MaterialTextView tagTv) {
    this.rootView = rootView;
    this.clear = clear;
    this.tagTv = tagTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LyTagUiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LyTagUiBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.ly_tag_ui, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LyTagUiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clear;
      ShapeableImageView clear = ViewBindings.findChildViewById(rootView, id);
      if (clear == null) {
        break missingId;
      }

      id = R.id.tag_tv;
      MaterialTextView tagTv = ViewBindings.findChildViewById(rootView, id);
      if (tagTv == null) {
        break missingId;
      }

      return new LyTagUiBinding((ConstraintLayout) rootView, clear, tagTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
