package com.myconpany.costsavingcanculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Cost_Saving extends ActionBarActivity {

    static double Estimate=10;
    static double Contador=0;
    static String[] arreglo=new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Load_Expenditures();
        setContentView(R.layout.activity_cost__saving);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_New)
        {
            New_Expenditure();
        }

        return super.onOptionsItemSelected(item);
    }

    public void New_Expenditure()
    {
        Intent intent = new Intent(this, New_Expenditure.class);
        startActivity(intent);
    }

    public void Load_Expenditures()
    {
        try{
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("File.txt")));
            String Line=null;

            Line=fin.readLine();
            while(Line != null )
            {

                arreglo=Line.split(" ");
                //Acumula nuevo gasto en contador
                Contador+=Double.parseDouble(arreglo[1]  );

                TextView textview_Total =(TextView) findViewById(R.id.textview_Total );
                textview_Total.setText(Double.toString(Contador)  );

                //si contador es mayor al presupuesto imprime un mensage de error
                TextView textview_Message=(TextView) findViewById(R.id.textview_Menssage);
                if(Contador  <= Estimate)
                {
                    textview_Message.setText("@string/In_Estimate");
                }
                else
                {
                    textview_Message.setText("@string/Out_Estimate");
                }

            }
            fin.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }
    }
}
