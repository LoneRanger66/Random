package com.zhaoyang.random;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Random random = null;
    private Button minLeftBtn;
    private Button minRightBtn;
    private Button maxLeftBtn;
    private Button maxRightBtn;
    private Button genBtn;
    private Button clearBtn;
    private EditText minText;
    private EditText maxText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        random = new Random();
    }

    private void init() {
        minLeftBtn = (Button) findViewById(R.id.minLeftBtn);
        minRightBtn = (Button) findViewById(R.id.minRightBtn);
        maxLeftBtn = (Button) findViewById(R.id.maxLeftBtn);
        maxRightBtn = (Button) findViewById(R.id.maxRightBtn);
        genBtn = (Button) findViewById(R.id.genBtn);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        minText = (EditText) findViewById(R.id.minText);
        maxText = (EditText) findViewById(R.id.maxText);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        minLeftBtn.setOnClickListener(this);
        minRightBtn.setOnClickListener(this);
        maxLeftBtn.setOnClickListener(this);
        maxRightBtn.setOnClickListener(this);
        genBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int min = 0;
        if (!minText.getText().toString().equals("")) {
            min = Integer.parseInt(minText.getText().toString());
        }
        int max = 0;
        if (!maxText.getText().toString().equals("")) {
            max = Integer.parseInt(maxText.getText().toString());
        }
        switch (v.getId()) {
            case R.id.minLeftBtn:
                if (min > 0) {
                    minText.setText(String.valueOf(min - 1));
                }
                break;
            case R.id.minRightBtn:
                if (min < 99999) {
                    minText.setText(String.valueOf(min + 1));
                }
                break;
            case R.id.maxLeftBtn:
                if (max > 0) {
                    maxText.setText(String.valueOf(max - 1));
                }
                break;
            case R.id.maxRightBtn:
                if (max < 99999) {
                    maxText.setText(String.valueOf(max + 1));
                }
                break;
            case R.id.genBtn:
                if (max >= min) {
                    int result = random.nextInt(max - min + 1) + min;
                    resultTextView.setText(String.valueOf(result));
                }
                break;
            case R.id.clearBtn:
                resultTextView.setText("");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (random != null) {
            random = null;
        }
    }

}
