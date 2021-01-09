package com.example.Devina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView txtJumlah, txtHarga, txtGetNama;
    TextView edtNama;
    CheckBox cbx_tomat, cbx_bawang;
    int jumlah, total, harga=10, tomat, bawang;
    String nama, statusTomat = "tidak",statusBawang="tidak";
    boolean iscbx_tomat, iscbx_bawang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtJumlah = (TextView) findViewById(R.id.txt_jumlah);
        txtHarga = (TextView) findViewById(R.id.txt_price);
        edtNama = (TextView) findViewById(R.id.txt_nama);
        txtGetNama = (TextView) findViewById(R.id.txt_getNama);
        cbx_tomat = (CheckBox) findViewById(R.id.cbx_tomat);
        cbx_bawang = (CheckBox) findViewById(R.id.cbx_bawang);

        Button btnShare = (Button) findViewById (R.id.btnShare);
        btnShare.setOnClickListener((view -> {share();}));
    }

    public void sambal(){
        if (cbx_tomat.isChecked()){
            iscbx_tomat=true;
            statusTomat="Sambal Tomat";
            tomat=1;
        }else {
            iscbx_tomat=false;
            statusTomat="";
            tomat=0;

        }
        if (cbx_bawang.isChecked()){
            iscbx_bawang=true;
            statusBawang = "Sambal Bawang";
            bawang=2;
        }else {
            iscbx_bawang=false;
            statusBawang="";
            bawang=0;
        }
    }
    public void tambah(View view){
        jumlah = jumlah + 1;
        txtJumlah.setText("" + jumlah);
    }
    public void kurang(View view){
        jumlah = jumlah - 1;
        txtJumlah.setText("" + jumlah);
    }
    public  void order(View view) { display(harga);}
    public void display(int harga) {
        sambal();
        total = jumlah * harga;
        if (iscbx_tomat) {
            total += (jumlah * tomat);
        }
        if (iscbx_bawang) {
            total += (jumlah * bawang);
        }
        Log.i( "harga :", "" + total);
        nama = edtNama.getText().toString();
        txtGetNama.setText("Nama :" + nama +
                "\n" + statusTomat +
                "\n" + statusBawang +
                "\nTerimakasih");
        txtHarga.setText("Harga : Rp. " + total +"000");
    }
    public void  share(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text");
        intent.putExtra(Intent.EXTRA_EMAIL, "rhefiyanaocki2001@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Ayam Kaka");
        intent.putExtra(Intent.EXTRA_TEXT, "Nama : "+ nama +
                "\n" + statusTomat +
                "\n" + statusBawang +
                "\n" + "Harga : Rp. " + total + "000" +
                "\n"+"Terimakasih");
        startActivity(Intent.createChooser(intent,"Send Email"));
    }
}