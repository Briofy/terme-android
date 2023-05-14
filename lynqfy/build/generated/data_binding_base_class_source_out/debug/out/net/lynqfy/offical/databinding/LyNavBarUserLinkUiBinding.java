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
import net.lynqfy.offical.LyButton;
import net.lynqfy.offical.R;

public final class LyNavBarUserLinkUiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final View line;

  @NonNull
  public final ShapeableImageView navLogo;

  @NonNull
  public final LyButton navLogout;

  @NonNull
  public final MaterialTextView navTitle;

  @NonNull
  public final ShapeableImageView userImage;

  private LyNavBarUserLinkUiBinding(@NonNull ConstraintLayout rootView, @NonNull View line,
      @NonNull ShapeableImageView navLogo, @NonNull LyButton navLogout,
      @NonNull MaterialTextView navTitle, @NonNull ShapeableImageView userImage) {
    this.rootView = rootView;
    this.line = line;
    this.navLogo = navLogo;
    this.navLogout = navLogout;
    this.navTitle = navTitle;
    this.userImage = userImage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LyNavBarUserLinkUiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LyNavBarUserLinkUiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ly_nav_bar_user_link_ui, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LyNavBarUserLinkUiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.line;
      View line = ViewBindings.findChildViewById(rootView, id);
      if (line == null) {
        break missingId;
      }

      id = R.id.nav_logo;
      ShapeableImageView navLogo = ViewBindings.findChildViewById(rootView, id);
      if (navLogo == null) {
        break missingId;
      }

      id = R.id.nav_logout;
      LyButton navLogout = ViewBindings.findChildViewById(rootView, id);
      if (navLogout == null) {
        break missingId;
      }

      id = R.id.nav_title;
      MaterialTextView navTitle = ViewBindings.findChildViewById(rootView, id);
      if (navTitle == null) {
        break missingId;
      }

      id = R.id.user_image;
      ShapeableImageView userImage = ViewBindings.findChildViewById(rootView, id);
      if (userImage == null) {
        break missingId;
      }

      return new LyNavBarUserLinkUiBinding((ConstraintLayout) rootView, line, navLogo, navLogout,
          navTitle, userImage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
