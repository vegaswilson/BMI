package com.noppadol.gametest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_cal = (Button)findViewById(R.id.button_cal);
        button_cal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                calBMI();
            }
        });
    }

    private void calBMI() {
        EditText textw = (EditText)findViewById(R.id.editText_wight);
        EditText texth = (EditText)findViewById(R.id.editText_hight);

        double w = Double.parseDouble(textw.getText().toString());
        double h = Double.parseDouble(texth.getText().toString());

        h = h/100; // cm-->m

        double bmi = w / (h*h);

        DecimalFormat decFoormat = new DecimalFormat("##.##");
        String msg = "ค่า BMI ตือ:" + decFoormat.format(bmi) + "\n";
        msg += "ลักษณะรูปร่างคือ:";
        if (bmi >= 40) msg += "อ้วนขั้นสูงสุด สมควรตาย";
        else if (bmi >=  35) msg += "อ้วนขั้นที่2 มึงพิการเเน่";
        else if (bmi >=  28.5) msg += "อ้วนขั้นที่1 ลดน้ำหนักซะ";
        else if (bmi >=  23.5) msg += "น้ำหนักเกิน ควบคุมการกิน";
        else if (bmi >=  18.5) msg += "หุ่นดีไอ่สัสเอ้ย อิจฉา";
        else msg += "ไม้เสียบผี";
        Toast.makeText(getBaseContext(),msg, Toast.LENGTH_LONG).show();


    }

}
