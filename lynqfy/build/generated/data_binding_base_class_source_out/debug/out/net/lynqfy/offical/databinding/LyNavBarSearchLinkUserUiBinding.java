// Generated by view binder compiler. Do not edit!
package net.lynqfy.offical.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import net.lynqfy.offical.LyButton;
import net.lynqfy.offical.R;

public final class LyNavBarSearchLinkUserUiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LyButton createPost;

  @NonNull
  public final ShapeableImageView navButton;

  @NonNull
  public final ShapeableImageView navLogo;

  @NonNull
  public final AppCompatImageButton navMenu;

  @NonNull
  public final FrameLayout navMenuParent;

  @NonNull
  public final MaterialTextView navTitle;

  @NonNull
  public final ShapeableImageView navUserImage;

  @NonNull
  public final TextInputEditText searchInput;

  @NonNull
  public final LinearLayoutCompat searchParent;

  private LyNavBarSearchLinkUserUiBinding(@NonNull ConstraintLayout rootView,
      @NonNull LyButton createPost, @NonNull ShapeableImageView navButton,
      @NonNull ShapeableImageView navLogo, @NonNull AppCompatImageButton navMenu,
      @NonNull FrameLayout navMenuParent, @NonNull MaterialTextView navTitle,
      @NonNull ShapeableImageView navUserImage, @NonNull TextInputEditText searchInput,
      @NonNull LinearLayoutCompat searchParent) {
    this.rootView = rootView;
    this.createPost = createPost;
    this.navButton = navButton;
    this.navLogo = navLogo;
    this.navMenu = navMenu;
    this.navMenuParent = navMenuParent;
    this.navTitle = navTitle;
    this.navUserImage = navUserImage;
    this.searchInput = searchInput;
    this.searchParent = searchParent;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LyNavBarSearchLinkUserUiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LyNavBarSearchLinkUserUiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ly_nav_bar_search_link_user_ui, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LyNavBarSearchLinkUserUiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.create_post;
      LyButton createPost = ViewBindings.findChildViewById(rootView, id);
      if (createPost == null) {
        break missingId;
      }

      id = R.id.nav_button;
      ShapeableImageView navButton = ViewBindings.findChildViewById(rootView, id);
      if (navButton == null) {
        break missingId;
      }

      id = R.id.nav_logo;
      ShapeableImageView navLogo = ViewBindings.findChildViewById(rootView, id);
      if (navLogo == null) {
        break missingId;
      }

      id = R.id.nav_menu;
      AppCompatImageButton navMenu = ViewBindings.findChildViewById(rootView, id);
      if (navMenu == null) {
        break missingId;
      }

      id = R.id.nav_menu_parent;
      FrameLayout navMenuParent = ViewBindings.findChildViewById(rootView, id);
      if (navMenuParent == null) {
        break missingId;
      }

      id = R.id.nav_title;
      MaterialTextView navTitle = ViewBindings.findChildViewById(rootView, id);
      if (navTitle == null) {
        break missingId;
      }

      id = R.id.nav_user_image;
      ShapeableImageView navUserImage = ViewBindings.findChildViewById(rootView, id);
      if (navUserImage == null) {
        break missingId;
      }

      id = R.id.search_input;
      TextInputEditText searchInput = ViewBindings.findChildViewById(rootView, id);
      if (searchInput == null) {
        break missingId;
      }

      id = R.id.search_parent;
      LinearLayoutCompat searchParent = ViewBindings.findChildViewById(rootView, id);
      if (searchParent == null) {
        break missingId;
      }

      return new LyNavBarSearchLinkUserUiBinding((ConstraintLayout) rootView, createPost, navButton,
          navLogo, navMenu, navMenuParent, navTitle, navUserImage, searchInput, searchParent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
