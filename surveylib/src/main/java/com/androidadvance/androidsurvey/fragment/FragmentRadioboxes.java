package com.androidadvance.androidsurvey.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.androidadvance.androidsurvey.Answers;
import com.androidadvance.androidsurvey.R;
import com.androidadvance.androidsurvey.SurveyActivity;
import com.androidadvance.androidsurvey.models.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FragmentRadioboxes extends Fragment {

    private final ArrayList<RadioButton> allRb = new ArrayList<>();
    private Question q_data;
    private FragmentActivity mContext;
    private Button button_continue;
    private TextView textview_q_title;
    private RadioGroup radioGroup;
    private boolean at_leaset_one_checked = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_radioboxes, container, false);

        button_continue = (Button) rootView.findViewById(R.id.button_continue);
        textview_q_title = (TextView) rootView.findViewById(R.id.textview_q_title);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SurveyActivity) mContext).go_to_next();
            }
        });

        return rootView;
    }


    private void collect_data(Question.MultipleChoice choice) {

        //----- collection & validation for is_required
        //change to int and string
        ArrayList<Question.MultipleChoice> value = new ArrayList<>();
        String the_choice = "";
        at_leaset_one_checked = false;
        for (RadioButton rb : allRb) {
            if (rb.isChecked()) {
                at_leaset_one_checked = true;
                the_choice = rb.getText().toString();
            }
        }
        if (the_choice.length() > 0) {
            //Answers.getInstance().put_answer(textview_q_title.getText().toString(), choice.getIdChoice()+","+choice.getValueChoice());
            value.add(new Question.MultipleChoice(choice.getIdChoice(), choice.getValueChoice()));
            Answers.getInstance().put_answer(q_data.getQuestionId(), textview_q_title.getText().toString(), value);
        }


        if (q_data.getRequired()) {
            if (at_leaset_one_checked) {
                button_continue.setVisibility(View.VISIBLE);
            } else {
                button_continue.setVisibility(View.GONE);
            }
        }

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);

        mContext = getActivity();
        q_data = (Question) getArguments().getSerializable("data");

        textview_q_title.setText(q_data.getQuestionTitle());


        // List<String> qq_data = q_data.getChoices();//dirubah array int and string
        List<Question.MultipleChoice> qq_data = q_data.getChoices();
        if (q_data.getRandomChoices()) {
            Collections.shuffle(qq_data);
        }

        for (final Question.MultipleChoice choice : qq_data) {
            RadioButton rb = new RadioButton(mContext);
            rb.setText(Html.fromHtml(choice.getValueChoice()));
            rb.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            rb.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            radioGroup.addView(rb);
            allRb.add(rb);

            rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        collect_data(choice);
                    //Toast.makeText(getActivity(),"you clicked "+ choice.getIdChoice()+" "+choice.getValueChoice(),Toast.LENGTH_SHORT).show();

                }
            });
        }
        if (q_data.getRequired()) {
            if (at_leaset_one_checked) {
                button_continue.setVisibility(View.VISIBLE);
            } else {
                button_continue.setVisibility(View.GONE);
            }
        }


    }


}