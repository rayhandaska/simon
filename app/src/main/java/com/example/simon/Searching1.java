package com.example.simon;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Searching1 extends AppCompatActivity {

    EditText editTextImage;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    ImageView imageView;
    Button getImage, detect;
    String dateTime;
    SimpleDateFormat simpleDateFormat;
    Calendar calendar;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_searching1);
        getImage = (Button) findViewById(R.id.getImage);
        detect = (Button) findViewById(R.id.detect);
        editTextImage = (EditText) findViewById(R.id.editTextImage);
        imageView = (ImageView) findViewById(R.id.imageView);


        getImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                progressDialog = new ProgressDialog(Searching1.this);
                progressDialog.setMessage("Fetching image....");
                progressDialog.setCancelable(false);
                progressDialog.show();


                String imageID = editTextImage.getText().toString();

                storageReference = FirebaseStorage.getInstance().getReference("image_cam1/"+imageID+".png");
                try{
                    File localfile = File.createTempFile("Tempfile",".jpg");
                    storageReference.getFile(localfile)
                            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                    if (progressDialog.isShowing())
                                        progressDialog.dismiss();

                                    Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                                    imageView.setImageBitmap(bitmap);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    if (progressDialog.isShowing())
                                        progressDialog.dismiss();
                                    Toast.makeText(Searching1.this, "Failed to retrieve", Toast.LENGTH_SHORT);
                                }
                            });
                } catch (IOException e){
                    e.printStackTrace();
                }

            }

        });
        ref = FirebaseDatabase.getInstance().getReference().child("channel");
        detect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calendar = Calendar.getInstance();
                simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm aaa z");
                dateTime = simpleDateFormat.format(calendar.getTime()).toString();

                ref.push().setValue("Channel 1 Detect Person     "+dateTime);
                Toast.makeText(Searching1.this, "Data Input Successful", Toast.LENGTH_SHORT).show();
            }

        });
    }
}