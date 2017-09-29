package com.androidadvance.androidsurvey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.androidadvance.androidsurvey.adapters.AdapterFragmentQ;
import com.androidadvance.androidsurvey.fragment.FragmentCheckboxes;
import com.androidadvance.androidsurvey.fragment.FragmentEnd;
import com.androidadvance.androidsurvey.fragment.FragmentMultiline;
import com.androidadvance.androidsurvey.fragment.FragmentNumber;
import com.androidadvance.androidsurvey.fragment.FragmentPersonal;
import com.androidadvance.androidsurvey.fragment.FragmentRadioboxes;
import com.androidadvance.androidsurvey.fragment.FragmentStart;
import com.androidadvance.androidsurvey.fragment.FragmentTextSimple;
import com.androidadvance.androidsurvey.models.Question;
import com.androidadvance.androidsurvey.models.Survey;
import com.androidadvance.androidsurvey.models.SurveyPojo;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SurveyActivity extends AppCompatActivity {

    public final static String SESSIONSURVEY = "SESSIONSURVEY";
    public final static String SESSIONJSONSURVEY = "JsonSurvey";
    public final static String ANSWERSOBJECT = "AnswerSurvey";
    public final static String ANSWERSSTRING = "answers";
    public final static String STYLE = "style";
    private SurveyPojo mSurveyPojo;
    private Survey mSurvey = null;
    private ViewPager mPager;
    private String style_string = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_survey);



        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            mSurveyPojo = new Gson().fromJson(bundle.getString(SESSIONJSONSURVEY), SurveyPojo.class);
            if (bundle.containsKey(STYLE)) {
                style_string = bundle.getString(STYLE);
            }
            if (bundle.getSerializable(SESSIONSURVEY) != null) {
                mSurvey = (Survey) bundle.getSerializable(SESSIONSURVEY);
            }
        }

        // Log.e("json Object = ", String.valueOf(mSurveyPojo.getQuestions()));

        final ArrayList<Fragment> arraylist_fragments = new ArrayList<>();

        if (mSurvey != null) {
            //- START -
            if (!mSurvey.getSurveyProperties().getSkipIntro()) {
                FragmentStart frag_start = new FragmentStart();
                Bundle sBundle = new Bundle();
                sBundle.putSerializable("SurveryProperties", mSurvey.getSurveyProperties());
                sBundle.putString("style", style_string);
                frag_start.setArguments(sBundle);
                arraylist_fragments.add(frag_start);
            }

            //- PERSONAL -
            if (!mSurvey.getPersonalInformation().getSkipPersonal()) {
                FragmentPersonal frag_start = new FragmentPersonal();
                Bundle sBundle = new Bundle();
                sBundle.putSerializable("SurveryPersonal", mSurvey.getPersonalInformation());
                sBundle.putString("style", style_string);
                frag_start.setArguments(sBundle);
                arraylist_fragments.add(frag_start);
            }

            //- FILL -
            for (Question mQuestion : mSurvey.getQuestions()) {

                if (mQuestion.getQuestionType().equals("String")) {
                    FragmentTextSimple frag = new FragmentTextSimple();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

                if (mQuestion.getQuestionType().equals("Checkboxes")) {
                    FragmentCheckboxes frag = new FragmentCheckboxes();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

                if (mQuestion.getQuestionType().equals("Radioboxes")) {
                    FragmentRadioboxes frag = new FragmentRadioboxes();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

                if (mQuestion.getQuestionType().equals("Number")) {
                    FragmentNumber frag = new FragmentNumber();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

                if (mQuestion.getQuestionType().equals("StringMultiline")) {
                    FragmentMultiline frag = new FragmentMultiline();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

            }

            //- END -
            FragmentEnd frag_end = new FragmentEnd();
            Bundle eBundle = new Bundle();
            eBundle.putSerializable("SurveryProperties", mSurvey.getSurveyProperties());
            eBundle.putString("style", style_string);
            frag_end.setArguments(eBundle);
            arraylist_fragments.add(frag_end);
        } else {
            //- START -
            if (!mSurveyPojo.getSurveyProperties().getSkipIntro()) {
                FragmentStart frag_start = new FragmentStart();
                Bundle sBundle = new Bundle();
                sBundle.putSerializable("SurveryProperties", mSurveyPojo.getSurveyProperties());
                sBundle.putString("style", style_string);
                frag_start.setArguments(sBundle);
                arraylist_fragments.add(frag_start);
            }

            //- PERSONAL -
            if (!mSurveyPojo.getSurveyPersonal().getSkipPersonal()) {
                FragmentPersonal frag_start = new FragmentPersonal();
                Bundle sBundle = new Bundle();
                sBundle.putSerializable("SurveryPersonal", mSurveyPojo.getSurveyPersonal());
                sBundle.putString("style", style_string);
                frag_start.setArguments(sBundle);
                arraylist_fragments.add(frag_start);
            }

            //- FILL -
            for (Question mQuestion : mSurveyPojo.getQuestions()) {

                if (mQuestion.getQuestionType().equals("String")) {
                    FragmentTextSimple frag = new FragmentTextSimple();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

                if (mQuestion.getQuestionType().equals("Checkboxes")) {
                    FragmentCheckboxes frag = new FragmentCheckboxes();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

                if (mQuestion.getQuestionType().equals("Radioboxes")) {
                    FragmentRadioboxes frag = new FragmentRadioboxes();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

                if (mQuestion.getQuestionType().equals("Number")) {
                    FragmentNumber frag = new FragmentNumber();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

                if (mQuestion.getQuestionType().equals("StringMultiline")) {
                    FragmentMultiline frag = new FragmentMultiline();
                    Bundle xBundle = new Bundle();
                    xBundle.putSerializable("data", mQuestion);
                    xBundle.putString("style", style_string);
                    frag.setArguments(xBundle);
                    arraylist_fragments.add(frag);
                }

            }

            //- END -
            FragmentEnd frag_end = new FragmentEnd();
            Bundle eBundle = new Bundle();
            eBundle.putSerializable("SurveryProperties", mSurveyPojo.getSurveyProperties());
            eBundle.putString("style", style_string);
            frag_end.setArguments(eBundle);
            arraylist_fragments.add(frag_end);
        }


        mPager = (ViewPager) findViewById(R.id.pager);
        AdapterFragmentQ mPagerAdapter = new AdapterFragmentQ(getSupportFragmentManager(), arraylist_fragments);
        mPager.setAdapter(mPagerAdapter);


    }

    public void go_to_next() {
        mPager.setCurrentItem(mPager.getCurrentItem() + 1);
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public void event_survey_completed(Answers instance) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(ANSWERSSTRING, instance.get_json_object());
        returnIntent.putExtra(ANSWERSOBJECT, instance.getAnswer());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
