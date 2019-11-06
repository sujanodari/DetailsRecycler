package com.sujan.detailsrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.sujan.detailsrecycler.adapter.UserDetailAdapter;
import com.sujan.detailsrecycler.model.UserDetail;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName,etAge;
    RadioButton rbMale, rbFemale, rbOthers;
    Spinner spinner;
    Button btnSave;
    RadioGroup rg;
    RecyclerView recyclerView;
    String gen;
    int img;
    List<UserDetail> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etAge=findViewById(R.id.etAge);
        rbMale=findViewById(R.id.rbMale);
        rbFemale=findViewById(R.id.rbFemale);
        rbOthers=findViewById(R.id.rbOthers);
        btnSave=findViewById(R.id.btnSave);
        spinner=findViewById(R.id.spinner);
        rg=findViewById(R.id.rg);


        btnSave.setOnClickListener(this);



        String images []={"Select Image","Birat","Model","Old","Four","Five","Six"};
        ArrayAdapter adapter= new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,images

        );
        spinner.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if(TextUtils.equals(etName.getText().toString(),"")){
            return;
        }
        if(TextUtils.equals(etAge.getText().toString(),"")){
            return;
        }

        recyclerView = findViewById(R.id.recyclerView);

        if(rbMale.isChecked()){
            gen="Male";
        }
        if(rbFemale.isChecked()){
            gen="Female";
        }
        if(rbOthers.isChecked()){
            gen="Others";
        }
        String image=spinner.getSelectedItem().toString();
        if(image=="Birat"){
            img=  R.drawable.three ;
        }
        if(image=="Model"){
             img=  R.drawable.two ;
        }
        if(image=="Old"){
            img=  R.drawable.one ;
        }
        if(image=="Four"){
            img=  R.drawable.four ;
        }
        if(image=="Five"){
            img=  R.drawable.five ;
        }
        if(image=="Six"){
            img=  R.drawable.six ;
        }

        int age=Integer.parseInt(etAge.getText().toString());

        userList.add(new UserDetail(etName.getText().toString(), age, gen, img));
           UserDetailAdapter userDetailAdapter = new UserDetailAdapter(this, userList);
           recyclerView.setAdapter(userDetailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));






        etName.setText("");
        etAge.setText("");
        rbFemale.clearFocus();
        rbOthers.clearFocus();
        rbMale.clearFocus();
        spinner.clearFocus();

    }
}
