package net.lynqfy.offical;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.lynqfy.offical.databinding.ButtonBindingImpl;
import net.lynqfy.offical.databinding.LyEditTextBindingImpl;
import net.lynqfy.offical.databinding.LyLayoutBindingImpl;
import net.lynqfy.offical.databinding.ProgressButtonBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_BUTTON = 1;

  private static final int LAYOUT_LYEDITTEXT = 2;

  private static final int LAYOUT_LYLAYOUT = 3;

  private static final int LAYOUT_PROGRESSBUTTON = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(net.lynqfy.offical.R.layout.button, LAYOUT_BUTTON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(net.lynqfy.offical.R.layout.ly_edit_text, LAYOUT_LYEDITTEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(net.lynqfy.offical.R.layout.ly_layout, LAYOUT_LYLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(net.lynqfy.offical.R.layout.progress_button, LAYOUT_PROGRESSBUTTON);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_BUTTON: {
          if ("layout/button_0".equals(tag)) {
            return new ButtonBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for button is invalid. Received: " + tag);
        }
        case  LAYOUT_LYEDITTEXT: {
          if ("layout/ly_edit_text_0".equals(tag)) {
            return new LyEditTextBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for ly_edit_text is invalid. Received: " + tag);
        }
        case  LAYOUT_LYLAYOUT: {
          if ("layout/ly_layout_0".equals(tag)) {
            return new LyLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for ly_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_PROGRESSBUTTON: {
          if ("layout/progress_button_0".equals(tag)) {
            return new ProgressButtonBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for progress_button is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/button_0", net.lynqfy.offical.R.layout.button);
      sKeys.put("layout/ly_edit_text_0", net.lynqfy.offical.R.layout.ly_edit_text);
      sKeys.put("layout/ly_layout_0", net.lynqfy.offical.R.layout.ly_layout);
      sKeys.put("layout/progress_button_0", net.lynqfy.offical.R.layout.progress_button);
    }
  }
}
