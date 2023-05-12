// Generated by view binder compiler. Do not edit!
package net.lynqfy.offical.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import net.lynqfy.offical.R;

public final class LyNavBarTopLevelUiBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton carouselNav;

  @NonNull
  public final TextView cryptos;

  private LyNavBarTopLevelUiBinding(@NonNull LinearLayout rootView,
      @NonNull ImageButton carouselNav, @NonNull TextView cryptos) {
    this.rootView = rootView;
    this.carouselNav = carouselNav;
    this.cryptos = cryptos;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LyNavBarTopLevelUiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LyNavBarTopLevelUiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ly_nav_bar_top_level_ui, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LyNavBarTopLevelUiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.carousel_nav;
      ImageButton carouselNav = ViewBindings.findChildViewById(rootView, id);
      if (carouselNav == null) {
        break missingId;
      }

      id = R.id.cryptos;
      TextView cryptos = ViewBindings.findChildViewById(rootView, id);
      if (cryptos == null) {
        break missingId;
      }

      return new LyNavBarTopLevelUiBinding((LinearLayout) rootView, carouselNav, cryptos);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
