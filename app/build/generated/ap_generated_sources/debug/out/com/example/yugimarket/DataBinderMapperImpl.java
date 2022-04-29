package com.example.yugimarket;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.yugimarket.databinding.FragmentFindCardsBindingImpl;
import com.example.yugimarket.databinding.FragmentUploadCardsBindingImpl;
import com.example.yugimarket.databinding.HeaderBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTFINDCARDS = 1;

  private static final int LAYOUT_FRAGMENTUPLOADCARDS = 2;

  private static final int LAYOUT_HEADER = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.yugimarket.R.layout.fragment_find_cards, LAYOUT_FRAGMENTFINDCARDS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.yugimarket.R.layout.fragment_upload_cards, LAYOUT_FRAGMENTUPLOADCARDS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.yugimarket.R.layout.header, LAYOUT_HEADER);
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
        case  LAYOUT_FRAGMENTFINDCARDS: {
          if ("layout/fragment_find_cards_0".equals(tag)) {
            return new FragmentFindCardsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_find_cards is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTUPLOADCARDS: {
          if ("layout/fragment_upload_cards_0".equals(tag)) {
            return new FragmentUploadCardsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_upload_cards is invalid. Received: " + tag);
        }
        case  LAYOUT_HEADER: {
          if ("layout/header_0".equals(tag)) {
            return new HeaderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for header is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/fragment_find_cards_0", com.example.yugimarket.R.layout.fragment_find_cards);
      sKeys.put("layout/fragment_upload_cards_0", com.example.yugimarket.R.layout.fragment_upload_cards);
      sKeys.put("layout/header_0", com.example.yugimarket.R.layout.header);
    }
  }
}
