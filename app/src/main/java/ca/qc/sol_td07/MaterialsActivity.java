package ca.qc.sol_td07;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ca.qc.sol_td07.entities.Materials;

public class MaterialsActivity extends AppCompatActivity {

    private TextView matrialsLblNb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);
        Materials materials = getIntent().getParcelableExtra("materials");
        initView();

        matrialsLblNb.setText("We have " + materials.getMaterials().size() + " items");
    }

    private void initView() {
        matrialsLblNb = (TextView) findViewById(R.id.matrials_lbl_nb);
    }
}