package com.mathsistor.m.mrpotato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MrPotatoActivity extends AppCompatActivity {

    private static SparseArray<ImageView> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mr_potato);

        images = new SparseArray<>();
        images.put(R.id.arms_checkbox, (ImageView) findViewById(R.id.arms));
        images.put(R.id.ears_checkbox, (ImageView) findViewById(R.id.ears));
        images.put(R.id.eyebrows_checkbox, (ImageView) findViewById(R.id.eyebrows));
        images.put(R.id.eyes_checkbox, (ImageView) findViewById(R.id.eyes));
        images.put(R.id.glasses_checkbox, (ImageView) findViewById(R.id.glasses));
        images.put(R.id.hat_checkbox, (ImageView) findViewById(R.id.hat));
        images.put(R.id.mouth_checkbox, (ImageView) findViewById(R.id.mouth));
        images.put(R.id.mustache_checkbox, (ImageView) findViewById(R.id.mustache));
        images.put(R.id.nose_checkbox, (ImageView) findViewById(R.id.nose));
        images.put(R.id.shoes_checkbox, (ImageView) findViewById(R.id.shoes));
    }

    public void showOrHidePart(View view) {
        CheckBox checkBox = (CheckBox) view;
        ImageView imageView = images.get(checkBox.getId());

        if (imageView == null) {
            return;
        }

        if (checkBox.isChecked()) {
            images.get(checkBox.getId()).setVisibility(View.VISIBLE);
        } else {
            images.get(checkBox.getId()).setVisibility(View.INVISIBLE);
        }
    }
}
