package com.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHello=findViewById(R.id.txtHello);
        MyDatabase myDatabase= new MyDatabase(this);

        String sqlInsert= "INSERT INTO "+ MyDatabase.TABLE_NAME+ " VALUES(null, 'PHP', 100, 10000, 'abcd')";
        myDatabase.excuteSQL(sqlInsert);

        sqlInsert= "INSERT INTO "+ MyDatabase.TABLE_NAME+ " VALUES(null, 'PHP1', 200, 10000, 'abcd')";
        myDatabase.excuteSQL(sqlInsert);

        String sqlSelect= "SELECT * FROM "+MyDatabase.TABLE_NAME;
        Cursor cs= myDatabase.selectSQL(sqlSelect);
        String str="";
        while (cs.moveToNext()){
            int id= cs.getInt(0);
            String name=cs.getString(1);
            int page= cs.getInt(2);
            float price=cs.getFloat(3);
            String descr= cs.getString(4);
            str= id+" "+name+ " "+page+" "+price+" "+descr+"\n";
            //Toast.makeText(this, ""+id+name+page+price+descr, Toast.LENGTH_SHORT).show();


        }
        txtHello.setText(str);
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }
}