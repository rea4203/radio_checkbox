package com.example.button;

import androidx.annotation.CheckResult;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rb_gender;
    private RadioButton rb_man, rb_wom;
    private Button bt_result;
    private String str_result;

    private CheckBox chk_red, chk_blue, chk_green;
    private TextView tv_chkresult;
    private Button bt_chkresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb_gender = findViewById(R.id.rg_gender);
        rb_man = findViewById(R.id.rb_man);
        rb_wom = findViewById(R.id.rb_wom);
        bt_result = findViewById(R.id.bt_result);
        tv_chkresult = findViewById(R.id.tv_chkresult);

        rb_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {  // 라디오 버튼들의 상태 값의 변경됨을 감지
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rb_man) {
                    Toast.makeText(MainActivity.this, "남자 라디오 버튼", Toast.LENGTH_SHORT).show();
                    str_result = rb_man.getText().toString();
                } else if( checkedId == R.id.rb_wom) {
                    Toast.makeText(MainActivity.this, "여자 라디오 버튼", Toast.LENGTH_SHORT).show();
                    str_result = rb_wom.getText().toString();
                }

            }
        });

        bt_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(str_result != null) {
                    Toast.makeText(MainActivity.this, str_result, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "성별을 선택해 주세요", Toast.LENGTH_SHORT).show();
                }

            }
        });

        chk_red = findViewById(R.id.chk_red);
        chk_blue = findViewById(R.id.chk_blue);
        chk_green = findViewById(R.id.chk_green);
        bt_chkresult = findViewById(R.id.bt_chkresult);
        tv_chkresult = findViewById(R.id.tv_chkresult);

        bt_chkresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str_chkresult = "";  // null X String 값 초기화

                if (chk_red.isChecked()) {  // chk_red가 체크 되었다면
                    str_chkresult += chk_red.getText().toString(); // chk_red의 텍스트 값을 가져와
                }
                if (chk_blue.isChecked()) {
                    str_chkresult += chk_blue.getText().toString();
                }
                if (chk_green.isChecked()) {
                    str_chkresult += chk_green.getText().toString();
                }

                tv_chkresult.setText(str_chkresult);  // String의 초기화가 없으면 값이 계속 추가됨

            }
        });

    }
}