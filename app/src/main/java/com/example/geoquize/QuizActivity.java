package com.example.geoquize;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mButtonTrue;
    private Button mButtonFalse;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        findViwes();
        setListeners();
    }

    private void findViwes() {
        mButtonTrue = findViewById(R.id.btn_true);
        mButtonFalse = findViewById(R.id.btn_false);
        mTextView = findViewById(R.id.txt);


    }

    private void setListeners() {

        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toastMessage = Toast.makeText(QuizActivity.this, R.string.toast_correct,
                        Toast.LENGTH_LONG);

                View toastView = toastMessage.getView();
                toastView.setBackgroundResource(R.drawable.toast_bachgrand);

                ViewGroup viewGroup = (ViewGroup) toastMessage.getView();
                TextView messageTextView = (TextView) viewGroup.getChildAt(0);
                messageTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_check, 0, 0, 0);
                messageTextView.setTextSize(25);

                toastMessage.show();

                mTextView.setTextColor(Color.parseColor("#00ff00"));
            }
        });

        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toastMessage = Toast.makeText(QuizActivity.this, R.string.toast_incorrect,
                        Toast.LENGTH_LONG);
                View toastView = toastMessage.getView();
                toastView.setBackgroundResource(R.drawable.toast_false_backgrand);

                ViewGroup viewGroup = (ViewGroup) toastMessage.getView();
                TextView messageTextView = (TextView) viewGroup.getChildAt(0);
                messageTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_clear_24, 0, 0, 0);
                messageTextView.setTextSize(25);

                toastMessage.show();

                mTextView.setTextColor(Color.RED);
            }
        });
    }


}