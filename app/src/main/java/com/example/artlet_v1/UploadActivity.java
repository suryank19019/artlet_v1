package com.example.artlet_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UploadActivity extends AppCompatActivity {

    boolean clicked=false;
    private EditText auth_name;
    private EditText title;
    private EditText Genre;
    private EditText FileType;
    private EditText Tags;
    private Button File;
    private Button Upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
    }
    public void buttonUpload(View v)
    {
        auth_name=(EditText)findViewById(R.id.edit1);
        title=(EditText)findViewById(R.id.edit2);
        Genre=(EditText) findViewById(R.id.edit3);
        FileType=(EditText)findViewById(R.id.edit4);
        Tags=(EditText)findViewById(R.id.edit5);
        File=(Button)findViewById(R.id.filebutton);
        Upload=(Button)findViewById(R.id.finalbutton);
        File.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked=true;
            }
        });
        Upload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String aname=auth_name.getText().toString();
                String ttle=title.getText().toString();
                String gnre=Genre.getText().toString();
                String ftype=FileType.getText().toString();
                String tgs=Tags.getText().toString();

                if(!(aname.matches("") || ttle.matches("" )||gnre.matches("")||ftype.matches("")||tgs.matches("")))
                {
                    if(clicked)
                    {
                        /*Intent i =new Intent(view.getContext(), newActivity.class);
                    startActivity(i);*/
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter all values",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
