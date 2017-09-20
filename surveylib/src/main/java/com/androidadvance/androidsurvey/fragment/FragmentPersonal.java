package com.androidadvance.androidsurvey.fragment;


import android.app.Service;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.androidadvance.androidsurvey.Answers;
import com.androidadvance.androidsurvey.R;
import com.androidadvance.androidsurvey.SurveyActivity;
import com.androidadvance.androidsurvey.models.Personal;
import com.androidadvance.androidsurvey.models.SurveyPersonal;

import java.util.ArrayList;
import java.util.List;

public class FragmentPersonal extends Fragment {

    SurveyPersonal q_data;
    List<TextInputEditText> allTI = new ArrayList<>();
    List<String> asks = new ArrayList<>();
    List<Boolean> required = new ArrayList<>();
    private FragmentActivity mContext;
    private Button button_continue;
    private LinearLayout contentline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_personal, container, false);
        contentline = (LinearLayout) rootView.findViewById(R.id.contentline);

        button_continue = (Button) rootView.findViewById(R.id.button_continue);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRequired();
            }
        });


        return rootView;
    }

    private void checkRequired() {
        boolean cancel = false;
        View focusView = null;
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        for (int i = 0; i < allTI.size(); i++) {
            if (TextUtils.isEmpty(allTI.get(i).getEditableText()) && required.get(i)) {
                allTI.get(i).setError(getString(R.string.error_field_required));
                focusView = allTI.get(i);
                cancel = true;
                break;
            }
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            if (q_data != null) {
                ArrayList<Personal> value = new ArrayList<>();
                for (int i = 0; i < allTI.size(); i++) {
                    String ask, answer = "";
                    ask = asks.get(i);
                    if (!TextUtils.isEmpty(allTI.get(i).getEditableText())) {
                        answer = allTI.get(i).getEditableText().toString();
                    }
                    value.add(new Personal(ask, answer));
                }
                Answers.getInstance().put_answer(q_data.getPersonalId(), value);
            }
            ((SurveyActivity) mContext).go_to_next();
        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mContext = getActivity();
        q_data = (SurveyPersonal) getArguments().getSerializable("SurveryPersonal");
        if (q_data != null) {
            if (q_data.getPersonal() != null && q_data.getPersonal().size() > 0) {
                for (Personal personal : q_data.getPersonal()) {
                    LinearLayout newLL = new LinearLayout(mContext);
                    newLL.setOrientation(LinearLayout.VERTICAL);
                    final TextInputLayout newTiL = new TextInputLayout(mContext);
                    newTiL.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    newTiL.setHintTextAppearance(R.style.TextAppearence_App_TextInputLayout);
                    final TextInputEditText newTi = new TextInputEditText(mContext);
                    newTi.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    newTi.setHint(personal.getTitle());
                    if (personal.getType() != null) {
                        if (personal.getType().equalsIgnoreCase("number")) {
                            newTi.setInputType(InputType.TYPE_CLASS_NUMBER);
                        } else if (personal.getType().equalsIgnoreCase("decimal")) {
                            newTi.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        } else if (personal.getType().equalsIgnoreCase("StringMultiline")) {
                            newTi.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                            newTi.setMaxLines(5);
                            newTi.setMinLines(3);
                        } else {
                            newTi.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                            newTi.setMaxLines(1);
                        }
                    }
                    newTiL.addView(newTi);
                    allTI.add(newTi);
                    required.add(personal.getRequired());
                    asks.add(personal.getTitle());
                    newLL.addView(newTiL);
                    contentline.addView(newLL);
                }
            }
        }

        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);


    }
}