package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText editTextAddress;
    ImageView avatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }

    private void findViews() {
        editTextAddress = findViewById(R.id.et_address);
        avatarImage = findViewById(R.id.imageView);
    }

    public void onOpenInGoogleMaps(View view) {
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + editTextAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void onSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

        switch (data.getIntExtra("imageID", R.drawable.svg_hello)) {


            case R.id.svg_browser:
                avatarImage.setImageResource(R.drawable.svg_browser);
                break;
            case R.id.svg_camera:
                avatarImage.setImageResource(R.drawable.svg_camera);
                break;
            case R.id.svg_game:
                avatarImage.setImageResource(R.drawable.svg_game);
                break;
            case R.id.svg_letter:
                avatarImage.setImageResource(R.drawable.svg_letter);
                break;
            case R.id.svg_mobile:
                avatarImage.setImageResource(R.drawable.svg_mobile);
                break;
            case R.id.svg_rocket:
                avatarImage.setImageResource(R.drawable.svg_rocket);
                break;

            default:
                avatarImage.setImageResource(R.drawable.svg_hello);
                break;
        }

    }
}