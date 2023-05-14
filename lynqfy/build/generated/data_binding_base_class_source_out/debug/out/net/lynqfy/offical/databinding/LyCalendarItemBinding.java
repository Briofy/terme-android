// Generated by view binder compiler. Do not edit!
package net.lynqfy.offical.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import net.lynqfy.offical.R;

public final class LyCalendarItemBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout cellView;

  @NonNull
  public final FrameLayout frameSelected;

  @NonNull
  public final TextView txtDate;

  private LyCalendarItemBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout cellView,
      @NonNull FrameLayout frameSelected, @NonNull TextView txtDate) {
    this.rootView = rootView;
    this.cellView = cellView;
    this.frameSelected = frameSelected;
    this.txtDate = txtDate;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LyCalendarItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LyCalendarItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ly_calendar_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LyCalendarItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout cellView = (FrameLayout) rootView;

      id = R.id.frameSelected;
      FrameLayout frameSelected = ViewBindings.findChildViewById(rootView, id);
      if (frameSelected == null) {
        break missingId;
      }

      id = R.id.txtDate;
      TextView txtDate = ViewBindings.findChildViewById(rootView, id);
      if (txtDate == null) {
        break missingId;
      }

      return new LyCalendarItemBinding((FrameLayout) rootView, cellView, frameSelected, txtDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
