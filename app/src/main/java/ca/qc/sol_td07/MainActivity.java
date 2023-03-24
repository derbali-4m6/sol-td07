package ca.qc.sol_td07;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ca.qc.sol_td07.entities.Material;
import ca.qc.sol_td07.entities.Materials;
import ca.qc.sol_td07.entities.Student;

public class MainActivity extends AppCompatActivity {

    private TextView demoLblText;
    private Button demoBtnClick;
    private EditText editTextNumber;
    private EditText editTextTextPersonName;
    private Spinner spinner;

    List<Material> materialList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMaterials();
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

    public void GetHardwares(View view) {
        Materials materials = new Materials();
        materials.setMaterials(materialList.stream().filter(m -> m.getCategory().equals("Hardware")).collect(Collectors.toList()));
        Intent intent = new Intent(this, MaterialsActivity.class);
        intent.putExtra("materials", materials);
        startActivity(intent);
    }

    public void GetSoftwares(View view) {
        Materials materials = new Materials();
        materials.setMaterials(materialList.stream().filter(m -> m.getCategory().equals("Software")).collect(Collectors.toList()));
        Intent intent = new Intent(this, MaterialsActivity.class);
        intent.putExtra("materials", materials);
        startActivity(intent);
    }

    private void initMaterials(){
        materialList = new ArrayList<>();
        materialList.add(new Material(1, "PC", "Hardware"));
        materialList.add(new Material(2, "Winrar", "Software"));
        materialList.add(new Material(3, "Android Studio", "Software"));
        materialList.add(new Material(4, "Mouse", "Hardware"));
        materialList.add(new Material(5, "Keyboard", "Hardware"));
        materialList.add(new Material(6, "IntelliJ", "Software"));
        materialList.add(new Material(7, "Monitor", "Hardware"));
        materialList.add(new Material(8, "7-zip", "Software"));
        materialList.add(new Material(9, "Printer", "Hardware"));
    }



}