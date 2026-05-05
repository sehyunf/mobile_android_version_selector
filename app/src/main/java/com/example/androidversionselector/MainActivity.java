package com.example.androidversionselector;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    Switch onOffSwitch;
    RadioGroup versionGroup;
    ImageView versionImage;
    Button endButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        onOffSwitch = findViewById(R.id.onOffSwitch);
        versionGroup = findViewById(R.id.versionGroup);
        versionImage = findViewById(R.id.versionImage);
        endButton = findViewById(R.id.endButton);
        resetButton = findViewById(R.id.resetButton);

        versionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if(!onOffSwitch.isChecked()) {
                    Toast.makeText(getApplicationContext(), "시작함을 체크해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton selectedButton = findViewById(checkedId);
                switch (checkedId) {
                    case 2131231227:
//                        Log.d("테스트", "이미지1" + checkedId);
                        versionImage.setImageResource(R.drawable.img_source1);
                        break;
                    case 2131231228:
                        versionImage.setImageResource(R.drawable.img_source2);
                        break;
                    case 2131231229:
                        versionImage.setImageResource(R.drawable.img_source3);
                        break;
                    default:
                        break;
                }
//                Log.d("선택버튼", "onCheckedChanged: " + checkedId);
            }
        });

        endButton.setOnClickListener(v -> finish());
        resetButton.setOnClickListener(v -> restartActivity());

        Log.d("스위치", "" + onOffSwitch.isChecked());

    }
    public void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}