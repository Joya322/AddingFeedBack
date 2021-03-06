package com.example.addingfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendButton, clearButton;
    private EditText nameEditText, messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sendButton = findViewById(R.id.btnsendId);
        clearButton = findViewById(R.id.btnclearId);

        nameEditText = findViewById(R.id.nameEditTextId);
        messageEditText = findViewById(R.id.messageId);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {//alt+ctrl+l...click korle auto format hoye jay

        try {
            String name = nameEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (v.getId() == R.id.btnsendId) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("Text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jannatferdoush1212@gmail.com"});//j email account a feedback pabo

                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n Message : " + message);

                startActivity(Intent.createChooser(intent, "Feedback with"));
            } else if (v.getId() == R.id.btnclearId) {
                nameEditText.setText("");
                messageEditText.setText("");
            }

        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "Exception : " + e, Toast.LENGTH_SHORT).show();
        }


    }
}