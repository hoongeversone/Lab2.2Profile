package com.example.user.lab22profile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public static final int REQUEST_PROFILE_UPDATE = 1;
    public static final String PROFILE_NAME = "com.example.user.lab22profile.name";
    public static final String PROFILE_EMAIL = "com.example.user.lab22profile.email";
    private TextView textViewName, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = (TextView)findViewById(R.id.textViewName);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);
    }

    public void updateProfile(View view)
    {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivityForResult(intent, REQUEST_PROFILE_UPDATE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //RequestCode = a unique code to identify an intent
        //ResultCode = result of an intent call; either OK or Cancel
        //data = the actual data returned by an intent
       //if (requestCode == REQUEST_PROFILE_UPDATE && resultCode == RESULT_OK){ }
        if (requestCode == REQUEST_PROFILE_UPDATE)
        {
            String name, email;

            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.Name) + " " + name);
            textViewEmail.setText(getString(R.string.Email) + " " + email);
        }
    }

    public void visitTARUC(View view)
    {
        String uri = "http://tarc.edu.my";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public void showMain(View view)
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDial(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "0123801349"));
        startActivity(intent);
    }

    public void showSendTo(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:" + "seekt@tarc.edu.my"));
        startActivity(intent);
    }
}
