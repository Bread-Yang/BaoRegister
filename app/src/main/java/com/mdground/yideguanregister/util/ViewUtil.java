package com.mdground.yideguanregister.util;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class ViewUtil {

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        if (listAdapter == null || listAdapter.getCount() == 0) {
            params.height = 0;
        } else {
            int totalHeight = 0;
            for (int i = 0; i < listAdapter.getCount(); i++) {
                View listItem = listAdapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
//				TextView tv_comment = (TextView) listItem.findViewById(R.id.tv_comment);
//				if (tv_comment != null && tv_comment.getVisibility() == View.VISIBLE) {
//                    tv_comment.measure(0, 0);
//                    totalHeight += tv_comment.getMeasuredHeight() + PxUtil.dip2px(tv_comment.getContext(), 5);
//				}
            }

            params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        }

        listView.setLayoutParams(params);
    }

    public static View getViewByPosition(int pos, ListView listView) {
        try {
            final int firstListItemPosition = listView
                    .getFirstVisiblePosition();
            final int lastListItemPosition = firstListItemPosition
                    + listView.getChildCount() - 1;

            if (pos < firstListItemPosition || pos > lastListItemPosition) {
                //This may occure using Android Monkey, else will work otherwise
                return listView.getAdapter().getView(pos, null, listView);
            } else {
                final int childIndex = pos - firstListItemPosition;
                return listView.getChildAt(childIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setLoseFocusWhenDoneButtonPress(final EditText editText) {
        editText.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // Clear focus here from edittext
                    editText.clearFocus();

                    InputMethodManager imm = (InputMethodManager) editText.getContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                }
                return false;
            }
        });
    }

    public static void AddUnitWhenEditTextOnFocusChange(final EditText editText) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = editText.getText().toString();

                if (hasFocus) {
                    ((EditText) v).setText(StringUtils.trimUnit(text));
                    editText.selectAll();
                } else {
                    editText.setText(text + "元");
                }
            }
        });
    }
}
