package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    int id = -1;
    ListView listSinhVien ;
    EditText editTen ;
    EditText editSDT ;
    Button btnThem, btnSua, btnXoa;
    ArrayList <sinhvien> arrSinhVien;
    customAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        arrSinhVien = new ArrayList<sinhvien>();
        arrSinhVien.add(new sinhvien(R.mipmap.ic_launcher_round,"Phan Thi Thuan","0356785649"));
        arrSinhVien.add(new sinhvien(R.mipmap.ic_launcher_round,"Le Van Nhan","035678568"));
        arrSinhVien.add(new sinhvien(R.mipmap.ic_launcher_round,"Nguyen Duc Tai","0356784568"));

        myadapter = new customAdapter(this, R.layout.item_layout,arrSinhVien);
        listSinhVien.setAdapter(myadapter);
        listSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                id = position;
                editTen.setText(arrSinhVien.get(position).getTenSinhVien());
                editSDT.setText(arrSinhVien.get(position).getSdtSinhVien());
            }
        });
        listSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrSinhVien.remove(position);
                myadapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Da xoa",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    private void anhxa (){
        listSinhVien = (ListView) findViewById(R.id.list_sinhvien );
        editTen = (EditText) findViewById(R.id.edit_ten);
        editSDT = (EditText) findViewById(R.id.edit_sdt);
        btnThem = (Button) findViewById(R.id.btn_them);
        btnSua = (Button) findViewById(R.id.btn_sua);
        btnXoa = (Button) findViewById(R.id.btn_xoa);

        btnThem.setOnClickListener(this);
        btnSua.setOnClickListener(this);
        btnXoa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.btn_them:
                Toast.makeText(this,"click vao button them",Toast.LENGTH_SHORT).show();

                String ten = editTen.getText().toString();
                String sdt = editSDT.getText().toString();
                sinhvien temp = new sinhvien(R.mipmap.ic_launcher,ten,sdt);
                arrSinhVien.add(temp);
                myadapter.notifyDataSetChanged();
            break;
            case R.id.btn_sua:
                String tenDaSua = editTen.getText().toString();
                String sdtDaSua = editSDT.getText().toString();
                sinhvien svDaSua = new sinhvien(R.mipmap.ic_launcher,tenDaSua,sdtDaSua);
                arrSinhVien.set(id,svDaSua);
                id = -1;
                myadapter.notifyDataSetChanged();
                break;

        }
    }
}