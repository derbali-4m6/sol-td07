package ca.qc.sol_td07;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ca.qc.sol_td07.entities.Student;

public class StudentActivity extends AppCompatActivity {

    private TextView studentLblId;
    private TextView studentLblName;
    private TextView studentLblGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initView();

        Student student = getIntent().getParcelableExtra("student");
        studentLblId.setText(String.valueOf(student.getId()));
        studentLblName.setText(student.getName());
        studentLblGrade.setText(String.valueOf(student.getGrade()));
    }

    private void initView() {
        studentLblId = (TextView) findViewById(R.id.student_lbl_id);
        studentLblName = (TextView) findViewById(R.id.student_lbl_name);
        studentLblGrade = (TextView) findViewById(R.id.student_lbl_grade);
    }
}