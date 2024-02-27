package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class tp3 extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure2);

        editText = findViewById(R.id.t1);
        button = findViewById(R.id.b);
        textView = findViewById(R.id.v1);

        Intent intent = getIntent();
        String receivedMessage = intent.getStringExtra("message");
        String message = "Message reçu: " + receivedMessage;
        if (message != null) {
            textView.setText(message);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String replyMessage = editText.getText().toString().trim();
                Intent replyIntent = new Intent();
                replyIntent.putExtra("reply", replyMessage);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}
