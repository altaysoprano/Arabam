package com.example.arabamapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FilterBottomSheet extends BottomSheetDialogFragment implements AdapterView.OnItemSelectedListener {

    private BottomSheetListener mListener;
    String maxYear;
    String minYear;
    String categoryId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.filter_bottom_sheet_layout, container, false);

        EditText editText = v.findViewById(R.id.category_id_edit_text);
        Spinner spinnerMaxYear = v.findViewById(R.id.spinner_max_year);
        Spinner spinnerMinYear = v.findViewById(R.id.spinner_min_year);

        ArrayAdapter<CharSequence> spinnerMaxYearAdapter = ArrayAdapter.createFromResource(getContext(), R.array.years, android.R.layout.simple_spinner_item);
        spinnerMaxYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaxYear.setAdapter(spinnerMaxYearAdapter);
        spinnerMaxYear.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> spinnerMinYearAdapter = ArrayAdapter.createFromResource(getContext(), R.array.years, android.R.layout.simple_spinner_item);
        spinnerMinYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinYear.setAdapter(spinnerMinYearAdapter);
        spinnerMinYear.setOnItemSelectedListener(this);


        Button button = v.findViewById(R.id.filter_ok_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryId = editText.getText().toString().trim();
                mListener.onButtonClicked(categoryId, maxYear, minYear);
                dismiss();
            }
        });

        return v;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId() == R.id.spinner_max_year)
        {
            maxYear = adapterView.getItemAtPosition(i).toString();
        }
        else if(adapterView.getId() == R.id.spinner_min_year)
        {
            minYear = adapterView.getItemAtPosition(i).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public interface BottomSheetListener {
        void onButtonClicked(String categoryId, String maxYear, String minYear);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mListener = (BottomSheetListener) context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement BottomSheetListener");
        }
    }
}
