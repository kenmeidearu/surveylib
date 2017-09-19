Android Survey
==========================

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android%20Survey-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2780)

Special thanks to https://github.com/howettl  & https://github.com/AndreiD for his Repository.

this info still using origin repository from AndreiD, add for personal info and change output of data 

## A simple to use, survey library for collecting feedback from your users.


![alt text](https://github.com/AndreiD/surveylib/raw/master/app/surveygif.gif "Android Survey Gif")


### Instalation:

~~~~
compile 'com.androidadvance.surveylib:surveylib:0.0.1'
~~~~


### How to use it:

1. Take a look at the [example project](https://github.com/kenmeidearu/surveylib/blob/master/app/src/main/java/androidadvance/com/androidsurveyexample/MainActivity.java)


##### Step 1:

You will need:
A json file with the questions. Check the [assets folder](https://github.com/AndreiD/surveylib/tree/master/app/src/main/assets) to see 3 examples.


##### Step 2:

Call the class **SurveyActivity** and pass as an extra the json string.
~~~~
        private static final int SURVEY_REQUEST = 1337;
        a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_survey = new Intent(MainActivity.this, SurveyActivity.class);
                i_survey.putExtra("json_survey", loadSurveyJson("example_survey_1.json"));
                startActivityForResult(i_survey, SURVEY_REQUEST);
            }
        });
~~~~



What is loadSurveyJson ? check [this function.](https://github.com/kenmeidearu/surveylib/blob/master/app/src/main/java/androidadvance/com/androidsurveyexample/MainActivity.java#L77)


##### Step 3:

The activity is started with a request code. 

~~~~
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SURVEY_REQUEST) {
            if (resultCode == RESULT_OK) {

                String answers_json = data.getExtras().getString("answers");
                Log.d("****", "****************** WE HAVE ANSWERS ******************");
                Log.v("ANSWERS JSON", answers_json);
                Log.d("****", "*****************************************************");

                //do whatever you want with them...
            }
        }
    }
~~~~
example output: 
~~~~
[{"Answer":[{"idChoice":"2","selected":true,"valueChoice":"I use a \u003cfont color\u003d\u0027#00AA00\u0027\u003egreen product\u003c/font\u003e"}],"Ask":"Do you currently use one of these other software solutions?","idAsk":"3"},{"Answer":[{"idChoice":"0","selected":false,"valueChoice":"Busy"}],"Ask":"Why did you not subscribe at the end of your free trial ?","idAsk":"4"},{"Answer":[{"idChoice":"3","selected":false,"valueChoice":"30-40"}],"Ask":"What is your age group ?","idAsk":"2"},{"Answer":[{"idChoice":"1","selected":true,"valueChoice":"thing #1"},{"idChoice":"2","selected":true,"valueChoice":"thing #2"}],"Ask":"What were you hoping the XYZ mobile app would do?","idAsk":"1"},{"Answer":[{"idChoice":"1","selected":true,"valueChoice":"thing #1"},{"idChoice":"2","selected":true,"valueChoice":"thing #2"}],"Ask":"What were you hoping the XYZ mobile app would do?","idAsk":"1"},{"Answer":[{"idChoice":"3","selected":false,"valueChoice":"30-40"}],"Ask":"What is your age group ?","idAsk":"2"},{"Answer":[{"idChoice":"0","selected":false,"valueChoice":"12"}],"Ask":"If this app was paid, how much you would give to have it ?","idAsk":"5"},{"Answer":[{"idChoice":"0","selected":false,"valueChoice":"1"}],"Ask":"berapa istri yang sudah kamu miliki ?","idAsk":"6"},{"Answer":[{"idChoice":"0","selected":false,"valueChoice":"very well"}],"Ask":"We love feedback and if there is anything else you’d like us to improve please let us know.","idAsk":"7"}]
~~~~

##### Last step:

Add this activity to your manifest file.
~~~~
<activity android:name="com.androidadvance.androidsurvey.SurveyActivity"
            android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize"
            android:windowSoftInputMode="stateHidden"/>
~~~~

##### The Json format of the Questions.

You have couple of question types: String, StringMultiline, Number, Radioboxes, Checkboxes. They can be "required" or not, the choices can be random. Check the examples, everything is simple to use.


##### Customizations

###### Colors
Use html codes in your json question title, choices. You can see a [compiled list here](http://commonsware.com/blog/Android/2010/05/26/html-tags-supported-by-textview.html)

Define your material design colors in the style. 

Not enough ? You have to do it yourself. Simplest way is to [Fork this project](https://github.com/AndreiD/surveylib#fork-destination-box) and style, add, modify who you like.

###### More question types / Other Stuff

Fork this project

#### Troubleshooting 

1. Make sure you have the ***latest*** shit. At this moment: compileSdkVersion 23, targetSdkVersion 23, buildToolsVersion "23.0.1", compile 'com.android.support:appcompat-v7:23.1.0',   compile 'com.android.support:design:23.1.0' etc.
2. Feed a valid json! Otherwise you'll get errors.
3. Check the sample project.

#### Updates, Questions, and Requests

Ping me here :)


#### TODO://

* Offline mode storage.
* Sync with server example.
* Adding a sliding bar / stars question type
* Waiting for your suggestions


#### You like this library ? Check my other projects.

- https://github.com/AndreiD/UltimateAndroidAppTemplate
- https://github.com/AndreiD/TSnackBar

### If you use this library, please star this project.


#### License

~~~~
Copyright 2015 AndroidAdvance.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
~~~~
