package com.example.wordcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerMetric;
    private Button buttonCount;
    private TextView textViewResult;
    private TextMetricsCounter metricsCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerMetric = findViewById(R.id.spinnerMetric);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);

        metricsCounter = new TextMetricsCounter();
        setupSpinner();

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countSelectedMetric();
            }
        });
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.metric_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMetric.setAdapter(adapter);
    }

    private void countSelectedMetric() {
        String inputText = editTextInput.getText().toString().trim();

        if (inputText.isEmpty()) {
            Toast.makeText(this, getString(R.string.toast_empty_text), Toast.LENGTH_SHORT).show();
            textViewResult.setText(getString(R.string.result_placeholder));
            return;
        }

        int selectedPosition = spinnerMetric.getSelectedItemPosition();
        int result;

        switch (selectedPosition) {
            case 0:
                result = metricsCounter.countSentences(inputText);
                break;
            case 1:
                result = metricsCounter.countWords(inputText);
                break;
            case 2:
                result = metricsCounter.countCharacters(inputText);
                break;
            case 3:
                result = metricsCounter.countNumbers(inputText);
                break;
            default:
                result = 0;
        }

        textViewResult.setText(String.valueOf(result));
    }
}