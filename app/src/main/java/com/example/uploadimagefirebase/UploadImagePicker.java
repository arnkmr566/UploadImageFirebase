package com.example.uploadimagefirebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class UploadImagePicker extends AppCompatActivity {

    ImageView imageView;
    FloatingActionButton  btnImageFb, btnProfileFb;
    CircleImageView profileImage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image_picker);
        


        imageView = findViewById(R.id.imageView);
        btnImageFb = findViewById(R.id.btnImageFb);
        btnProfileFb = findViewById(R.id.btnProfileFb);
        profileImage = findViewById(R.id.profileImage);

        btnImageFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(UploadImagePicker.this)
                        .crop()         //Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(10);
            }
        });

        btnProfileFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImagePicker.with(UploadImagePicker.this)
                        .crop()         //Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(20);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


                if (requestCode == 10){
                    Uri uri = data.getData();
                    imageView.setImageURI(uri);
                }else {
                    Uri uri = data.getData();
                    profileImage.setImageURI(uri);
                }
    }
}