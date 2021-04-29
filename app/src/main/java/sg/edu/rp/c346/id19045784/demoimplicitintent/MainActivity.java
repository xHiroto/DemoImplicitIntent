package sg.edu.rp.c346.id19045784.demoimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnEmail, btnRP;
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage =  findViewById(R.id.editTextMessage);
        btnEmail = findViewById(R.id.buttonEmail);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the action wants this intent to do
                //Action_Send is sued to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);

                //put essentials like email address, subject and body text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from c347");
                email.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText());
                //this MINE type indicate email
                email.setType("message/rfc822");
                //createchooser shows user a list of app that can handel
                //this MINE type which is, email
                startActivity(Intent.createChooser(email,"Choose an Email client :"));
            }
        });

        btnRP = findViewById(R.id.btnRP);
        btnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                //set the URL to be used
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

    }
}
