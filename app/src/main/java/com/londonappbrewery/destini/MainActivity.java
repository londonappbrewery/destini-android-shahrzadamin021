package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;
    int mArrayIndex=0;
    String mCurrentButtonText;
    StoryLine[] mStoryLine = new StoryLine[] {
            new StoryLine(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new StoryLine(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new StoryLine(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new StoryLine(R.string.T4_End,0,0),
            new StoryLine(R.string.T5_End,0,0),
            new StoryLine(R.string.T6_End,0,0),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView= (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mStoryIndex=(mStoryIndex+1);
                //update to T-3 story, T3-Ans1, T3-Ans2
                Log.d("Destini", "Top Button has been clicked!");
                //get the button id they clicked
                //mCurrentButtonID = mTopButton.getId();
                //mTopButton.getText();
                Log.d("Destini", "Top Button Text is: "+mTopButton.getText());
                mCurrentButtonText = (String) mTopButton.getText();
                updateStory (mCurrentButtonText);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBottomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                //update to T-2 story
                Log.d("Destini", "Bottom button has been clicked!");
                //Log.d("Destini", "Bottom button ID is: "+mBottomButton.getId());
                Log.d("Destini", "Top Button Text is: "+mBottomButton.getText());
                mCurrentButtonText = (String) mBottomButton.getText();
                updateStory (mCurrentButtonText);

            }
        });
    }


    private void updateStory (String buttonTxt) {
        if (buttonTxt.equals(getString(R.string.T1_Ans1)) || buttonTxt.equals(getString(R.string.T2_Ans1))){
            mStoryTextView.setText(mStoryLine[2].getStoryID());
            mTopButton.setText(mStoryLine[2].getAnswerOne());
            mBottomButton.setText(mStoryLine[2].getAnswerTwo());
        }
        else if (buttonTxt.equals(getString(R.string.T1_Ans2))){
            mStoryTextView.setText(mStoryLine[1].getStoryID());
            mTopButton.setText(mStoryLine[1].getAnswerOne());
            mBottomButton.setText(mStoryLine[1].getAnswerTwo());
        }
        else if (buttonTxt.equals(getString(R.string.T3_Ans1))) {
            mStoryTextView.setText(mStoryLine[5].getStoryID());
            mTopButton.setVisibility(View.INVISIBLE);
            mBottomButton.setVisibility(View.INVISIBLE);
        }
        else if (buttonTxt.equals(getString(R.string.T3_Ans2))) {
            mStoryTextView.setText(mStoryLine[4].getStoryID());
            mTopButton.setVisibility(View.INVISIBLE);
            mBottomButton.setVisibility(View.INVISIBLE);
        }
        else {
            mStoryTextView.setText(mStoryLine[3].getStoryID());
            mTopButton.setVisibility(View.INVISIBLE);
            mBottomButton.setVisibility(View.INVISIBLE);
        }


    }
}
