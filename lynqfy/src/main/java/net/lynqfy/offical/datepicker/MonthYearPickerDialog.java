package net.lynqfy.offical.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.button.MaterialButton;

import net.lynqfy.offical.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import timber.log.Timber;

public class MonthYearPickerDialog extends DialogFragment {


    MonthYearPickerDialog(Date date){
        mDate = date;
    }
    private static final int MAX_YEAR = 2099;
    private final int STEP = 12;

    private final Date mDate ;
    private DatePickerDialog.OnDateSetListener listener;

    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    private final ArrayList<String> years = new ArrayList<>();

    private boolean updateItems(int start, int end) {
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        if (start == thisYear) {
            return false;
        }
        years.clear();
        for (int i = 2012; i <= end; i++) {
            years.add(Integer.toString(i));
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.LyAlertDialogStyle);
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        //Calendar cal = Calendar.getInstance();

        View dialog = inflater.inflate(R.layout.ly_month_year_picker_dialog_ui, null);

        ArrayList<String> years = new ArrayList<>();
        for (int i = 1900; i <= MAX_YEAR; i++) {
            years.add(Integer.toString(i));
        }
//        Calendar.getInstance().get(Calendar.YEAR) - 1900
//        mDate.getYear()
        GridView gv = (GridView) dialog.findViewById(R.id.grid);
        GridAdapter adapter = new GridAdapter(requireActivity(), R.layout.ly_calendar_single_cell, years);
        gv.setAdapter(adapter);
        builder.setView(dialog);
        TextView tv = ((TextView) dialog.findViewById(R.id.title));

        tv.setText(String.format("%s-%s", years.get(0), years.get(years.size() - 1)));

        ((ImageView) dialog.findViewById(R.id.btnMonthNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ((ImageView) dialog.findViewById(R.id.btnMonthPrev)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ((MaterialButton) dialog.findViewById(R.id.txtToday)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ((MaterialButton) dialog.findViewById(R.id.txtCancel)).setOnClickListener(v -> Objects.requireNonNull(MonthYearPickerDialog.this.getDialog()).cancel());

        //.setPositiveButton(Html.fromHtml("<font color='#FF4081'>Ok</font>"), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int id) {
//               // listener.onDateSet(null, yearPicker.getValue(), monthPicker.getValue(), 0);
//            }
//        }).setNegativeButton(Html.fromHtml("<font color='#FF4081'>Cancel</font>"), new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                MonthYearPickerDialog.this.getDialog().cancel();
//            }
//        });
        return builder.create();
    }

    private static class GridAdapter extends ArrayAdapter<String> {
        private final LayoutInflater inflater;
        private final ArrayList<String> items = new ArrayList<>();

        public GridAdapter(@NonNull Context context, int resource, ArrayList<String> years) {
            super(context, resource);
            inflater = LayoutInflater.from(context);
            items.addAll(years);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View v = convertView;
            if (v == null) {
                v = inflater.inflate(R.layout.ly_calendar_single_cell, parent, false);
            }
            TextView tv = v.findViewById(R.id.txtDate);
            tv.setText(items.get(position));

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
    }

    public static MonthYearPickerDialog createDialogWithoutDateField(Date date) {

        MonthYearPickerDialog dpd = new MonthYearPickerDialog(date);
        try {
            java.lang.reflect.Field[] datePickerDialogFields = dpd.getClass().getDeclaredFields();
            for (java.lang.reflect.Field datePickerDialogField : datePickerDialogFields) {
                if (datePickerDialogField.getName().equals("mDatePicker")) {
                    datePickerDialogField.setAccessible(true);
                    DatePicker datePicker = (DatePicker) datePickerDialogField.get(dpd);
                    java.lang.reflect.Field[] datePickerFields = datePickerDialogField.getType().getDeclaredFields();
                    for (java.lang.reflect.Field datePickerField : datePickerFields) {
                        Timber.i(datePickerField.getName());
                        if ("mDaySpinner".equals(datePickerField.getName())) {
                            datePickerField.setAccessible(true);
                            Object dayPicker = datePickerField.get(datePicker);
                            assert dayPicker != null;
                            ((View) dayPicker).setVisibility(View.GONE);
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return dpd;
    }
}
