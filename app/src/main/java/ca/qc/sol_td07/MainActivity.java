package ca.qc.sol_td07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ca.qc.sol_td07.entities.Student;

public class MainActivity extends AppCompatActivity {

    private TextView demoLblText;
    private Button demoBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        demoLblText = (TextView) findViewById(R.id.demo_lbl_text);
        demoBtnClick = (Button) findViewById(R.id.demo_btn_click);

        demoBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setId(1);
                student.setName("Alex Lajoie");
                student.setGrade(Student.Grade.ADVANCED);

                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                intent.putExtra("student", student);
                startActivity(intent);
            }
        });
    }
}