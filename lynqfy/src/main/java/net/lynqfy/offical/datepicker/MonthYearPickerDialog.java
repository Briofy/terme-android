package net.lynqfy.offical.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import net.lynqfy.offical.R;
import net.lynqfy.offical.datepicker.listeners.GridChangeListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import timber.log.Timber;

public class MonthYearPickerDialog extends DialogFragment {

    MonthYearPickerDialog(Date date) {
        mDate = date;
        generateYears();
    }

    private static final String[] Months = new String[]{"January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    private static final int MAX_YEAR = 2099;
    private int indexOfMapData = -1;
    private GridAdapter adapter;
    private final Date mDate;
    private TextView title;
    private DatePickerDialog.OnDateSetListener listener;

    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    private final HashMap<String, ArrayList<String>> years = new HashMap<>();
    private final ArrayList<String> keys = new ArrayList<>();

    private void generateYears() {
        years.clear();
        int STEP = 11;
        for (int i = 1900; i <= MAX_YEAR; i += (STEP + 1)) {
            String key = String.format("%s-%s", i, i + STEP);
            years.put(key, generateYears(i, i + STEP));
            keys.add(key);
        }
    }

    private ArrayList<String> generateYears(int start, int end) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(Integer.toString(i));
        }
        return list;
    }

    private void updateGrid() {
        if (indexOfMapData >= 0 && indexOfMapData < keys.size()) {
            String key = keys.get(indexOfMapData);
            if (years.containsKey(key)) {
                adapter.replaceItems(years.get(key));
            }
            title.setText(key);
        }
        Timber.e("updateGrid : %s", adapter.getSelectedItem());
    }

    private String findSuitableKey(String y) {
        for (String key : keys) {
            ArrayList<String> list = years.get(key);
            if (list == null) {
                continue;
            }
            for (String v : list) {
                if (Objects.equals(v, y)) {
                    return key;
                }
            }
        }
        return null;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.LyAlertDialogStyle);
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View dialog = inflater.inflate(R.layout.ly_month_year_picker_dialog_ui, null);

        Calendar calendar = Calendar.getInstance();

        Date currentTime = calendar.getTime();
        calendar.setTime(mDate);

        String cy = Integer.toString(calendar.get(android.icu.util.Calendar.YEAR));
        String selectedYears = findSuitableKey(cy);

        calendar.setTime(currentTime);
        calendar.clear();

        Timber.e("Selected Years %s", selectedYears);

        GridView gv = dialog.findViewById(R.id.grid);
        adapter = new GridAdapter(requireActivity(), R.layout.ly_calendar_item, cy, years.get(selectedYears),
                (position, value) -> {
                    Timber.e("onItemSelect %s-> %s", position, value);
                    String selectedItem = adapter.mSelectedItem;

                    adapter.notifyDataSetChanged();
                });
        gv.setAdapter(adapter);

        title = dialog.findViewById(R.id.title);
        title.setText(selectedYears);
        indexOfMapData = keys.indexOf(selectedYears);

        dialog.findViewById(R.id.btnMonthNext).setOnClickListener(v -> {
            if (indexOfMapData < keys.size() - 1) {
                indexOfMapData += 1;
            }
            updateGrid();
        });

        dialog.findViewById(R.id.btnMonthPrev).setOnClickListener(v -> {
            if (indexOfMapData >= 1) {
                indexOfMapData -= 1;
            }
            updateGrid();
        });

        dialog.findViewById(R.id.txtToday).setOnClickListener(v -> {
            String toDay = findSuitableKey(Integer.toString(Calendar.getInstance().get(android.icu.util.Calendar.YEAR)));
            adapter.mSelectedItem = adapter.mActiveItem;
            indexOfMapData = keys.indexOf(toDay);
            updateGrid();
        });
        dialog.findViewById(R.id.txtCancel).setOnClickListener(v -> Objects.requireNonNull(MonthYearPickerDialog.this.getDialog()).cancel());

        return builder.setView(dialog).create();
    }


    public static class GridAdapter extends ArrayAdapter<String> {
        private final LayoutInflater inflater;
        private final ArrayList<String> items = new ArrayList<>();
        private final OnItemSelectListener listener;
        //        private int mLastSelectedPosition = -1;
        private final String mActiveItem;
        private String mSelectedItem;
        private final LayerDrawable shape = (LayerDrawable) ContextCompat.getDrawable(getContext(), R.drawable.calender_selected_item);

        public GridAdapter(@NonNull Context context,
                           int resource, String year,
                           ArrayList<String> years,
                           OnItemSelectListener gridListener) {
            super(context, resource);
            inflater = LayoutInflater.from(context);
            listener = gridListener;
            mSelectedItem  = mActiveItem = year;
            items.addAll(years);
        }

        public void replaceItems(ArrayList<String> years) {
            items.clear();
            notifyDataSetChanged();
            items.addAll(years);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                v = inflater.inflate(R.layout.ly_calendar_item, parent, false);
            }
            String item = items.get(position);

            ((TextView) v.findViewById(R.id.txtDate)).setText(item);

            FrameLayout sV = v.findViewById(R.id.frameSelected);

            if (Objects.equals(item, mSelectedItem)) {
                sV.setBackground(shape);
            } else {
                sV.setBackground(null);
            }
            sV.setOnClickListener(v1 -> {
                mSelectedItem = item;
                listener.onItemSelect(position, mSelectedItem);
            });
            return v;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Nullable
        @Override
        public String getItem(int position) {
            return items.get(position);
        }

        public String getSelectedItem() {
            return mSelectedItem;
        }

        public String getActiveItem() {
            return mActiveItem;
        }

        public interface OnItemSelectListener {
            void onItemSelect(int position, String value);
        }
    }

    public static MonthYearPickerDialog createDialogWithoutDateField(Date date) {
        return new MonthYearPickerDialog(date);
    }
}
