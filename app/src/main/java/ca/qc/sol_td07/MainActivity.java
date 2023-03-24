package ca.qc.sol_td07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ca.qc.sol_td07.entities.Student;

public class MainActivity extends AppCompatActivity {

    private TextView demoLblText;
    private Button demoBtnClick;
    private EditText editTextNumber;
    private EditText editTextTextPersonName;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        demoLblText = (TextView) findViewById(R.id.demo_lbl_text);
        demoBtnClick = (Button) findViewById(R.id.demo_btn_click);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        spinner = (Spinner) findViewById(R.id.spinner);

        demoBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setId(Integer.parseInt(editTextNumber.getText().toString()));
                student.setName(editTextTextPersonName.getText().toString());
                String grade = getResources().getStringArray(R.array.grades)[spinner.getSelectedItemPosition()];
                switch (grade) {
                    case "BEGINNER": student.setGrade(Student.Grade.BEGINNER); break;
                    case "INTERMEDIATE": student.setGrade(Student.Grade.INTERMEDIATE); break;
                    case "ADVANCED": student.setGrade(Student.Grade.ADVANCED); break;
                }
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                intent.putExtra("student", student);
                startActivity(intent);
            }
        });

    }
}