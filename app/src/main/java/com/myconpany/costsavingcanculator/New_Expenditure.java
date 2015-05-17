package com.myconpany.costsavingcanculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Armando on 16/05/2015.
 */
public class New_Expenditure extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_expenditure);
        Intent intent = getIntent();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public  void Save_File(View view)
    {
        String Line=null;
        String Name=null;
        String Cost=null;
        String Description=null;
        EditText editText_name;
        EditText editText_cost;
        EditText editText_description;

        try {
            OutputStreamWriter fout= new OutputStreamWriter(openFileOutput("File.txt", Context.MODE_PRIVATE));
            editText_name=(EditText) findViewById(R.id.edit_text_name);
            Name=editText_name.getText().toString();

            editText_cost=(EditText) findViewById(R.id.edit_text_name);
            Cost=editText_cost.getText().toString();

            editText_description=(EditText) findViewById(R.id.edit_text_name);
            Description=editText_description.getText().toString();

            Line=Name+" "+Cost+" "+Description;
            fout.write(Line);
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }


    }
}
