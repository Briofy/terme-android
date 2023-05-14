// Generated by view binder compiler. Do not edit!
package net.lynqfy.offical.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import net.lynqfy.offical.R;
import net.lynqfy.offical.progress.LyBaseProgressBar;

public final class LyProgressBarBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final LyBaseProgressBar progressBar;

  @NonNull
  public final LinearLayoutCompat progressBarParent;

  @NonNull
  public final MaterialTextView progressBarTxt;

  private LyProgressBarBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull LyBaseProgressBar progressBar, @NonNull LinearLayoutCompat progressBarParent,
      @NonNull MaterialTextView progressBarTxt) {
    this.rootView = rootView;
    this.progressBar = progressBar;
    this.progressBarParent = progressBarParent;
    this.progressBarTxt = progressBarTxt;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static LyProgressBarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LyProgressBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ly_progress_bar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LyProgressBarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.progressBar;
      LyBaseProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      LinearLayoutCompat progressBarParent = (LinearLayoutCompat) rootView;

      id = R.id.progressBar_txt;
      MaterialTextView progressBarTxt = ViewBindings.findChildViewById(rootView, id);
      if (progressBarTxt == null) {
        break missingId;
      }

      return new LyProgressBarBinding((LinearLayoutCompat) rootView, progressBar, progressBarParent,
          progressBarTxt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
