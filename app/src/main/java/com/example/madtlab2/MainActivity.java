package com.example.madtlab2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText textInput;
    private Spinner countSpinner;
    private Button countButton;
    private TextView resultText;
    private boolean countWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = findViewById(R.id.text_input);
        countSpinner = findViewById(R.id.count_spinner);
        countButton = findViewById(R.id.count_button);
        resultText = findViewById(R.id.result_text);

        // Set up the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countSpinner.setAdapter(adapter);
        countSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countWords = position == 0; // 0 = Words, 1 = Characters
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = textInput.getText().toString();
                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.empty_text_warning, Toast.LENGTH_SHORT).show();
                    return;
                }
                int result = countWords ? WordCounter.countWords(inputText) : WordCounter.countCharacters(inputText);
                resultText.setText("Count: " + result);
            }
        });
    }
}