package com.pratik.mxplayertest1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.editText);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() > 0) {
                    TextView resultView = findViewById(R.id.textView);
                    resultView.setText(showResult(editText.getText().toString()));
                }
            }
        });
    }

    private String showResult(String string) {

        boolean isMatched = false;
        int count = 0;

        int openRoundBracketCount = 0;
        int openSquareBracketCount = 0;
        int closeRoundBracketCount = 0;
        int closeSquareBracketCount = 0;

        // look for all bracket
        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == '(') {
                openRoundBracketCount++;
            } else if (string.charAt(i) == '[') {
                openSquareBracketCount++;
            } else if (string.charAt(i) == ')') {
                closeRoundBracketCount++;
            } else if (string.charAt(i) == ']') {
                closeSquareBracketCount++;
            }
        }

        if (openRoundBracketCount == closeRoundBracketCount && openSquareBracketCount == closeSquareBracketCount) {
            isMatched = true;
            count = openRoundBracketCount + openSquareBracketCount;
        }

        return isMatched ? (1 + " " + count) : "0";
    }
}
