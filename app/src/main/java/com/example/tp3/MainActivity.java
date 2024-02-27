package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    static final int REQUEST_CODE_TP3 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure1);

        editText = findViewById(R.id.t1);
        button = findViewById(R.id.b);
        textView = findViewById(R.id.v1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString().trim();
                if (message.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez saisir un message", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, tp3.class);
                    intent.putExtra("message", message);
                    startActivityForResult(intent, REQUEST_CODE_TP3);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TP3 && resultCode == RESULT_OK) {
            String replyMessage = data.getStringExtra("reply");
            if (!replyMessage.isEmpty()) {
                textView.setText(replyMessage);
            } else {
                Toast.makeText(MainActivity.this, "Réponse vide", Toast.LENGTH_LONG).show();
            }
        }
    }
}
