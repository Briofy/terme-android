// Generated by data binding compiler. Do not edit!
package net.lynqfy.offical.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import net.lynqfy.offical.R;

public abstract class LyEditTextBinding extends ViewDataBinding {
  @NonNull
  public final View bg;

  @NonNull
  public final EditText editText;

  @NonNull
  public final ImageView imgSeen;

  @NonNull
  public final TextView tvTitle;

  protected LyEditTextBinding(Object _bindingComponent, View _root, int _localFieldCount, View bg,
      EditText editText, ImageView imgSeen, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bg = bg;
    this.editText = editText;
    this.imgSeen = imgSeen;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static LyEditTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ly_edit_text, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LyEditTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LyEditTextBinding>inflateInternal(inflater, R.layout.ly_edit_text, root, attachToRoot, component);
  }

  @NonNull
  public static LyEditTextBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ly_edit_text, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LyEditTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LyEditTextBinding>inflateInternal(inflater, R.layout.ly_edit_text, null, false, component);
  }

  public static LyEditTextBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LyEditTextBinding bind(@NonNull View view, @Nullable Object component) {
    return (LyEditTextBinding)bind(component, view, R.layout.ly_edit_text);
  }
}
