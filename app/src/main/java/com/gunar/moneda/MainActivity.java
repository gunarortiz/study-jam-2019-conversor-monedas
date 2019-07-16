package com.gunar.moneda;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        EditText a = (EditText) findViewById(R.id.editText1);

        a.addTextChangedListener(new TextWatcher() {

            // the user's changes are saved here
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                if (!c.toString().equals(""))
                    calcular(Double.parseDouble(c.toString()));
                else
                    calcular(0.0);
            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
                // this one too
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                String a = ((EditText) findViewById(R.id.editText1)).getText().toString();
                aux = pos;
                if (!a.equals(""))
                    calcular(Double.parseDouble(a));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void calcular(View view) {
        String a = ((EditText) findViewById(R.id.editText1)).getText().toString();

        if (!a.equals("")) {

            Double b = Double.parseDouble(a);

            Double c = 0.0;

            switch (aux) {

                case 0:
                    c = 1.0;
                    break;
                case 1:
                    c = 6.96;
                    break;
                case 2:
                    c = 7.52;
                    break;
                case 3:
                    c = 2.23;
                    break;
                case 4:
                    c = 0.011354;
                    break;
                case 5:
                    c = 2.2852;
                    break;
                case 6:
                    c = 1.1379;
                    break;
                case 7:
                    c = 0.05849034;
                    break;

            }

            ((TextView) findViewById(R.id.textView3)).setText((b * c / 6.96) + " Dolares");
            ((TextView) findViewById(R.id.textView4)).setText((b * c / 7.52) + " Euros");
            ((TextView) findViewById(R.id.textView5)).setText((b * c / 2.23) + " Soles");
            ((TextView) findViewById(R.id.textView6)).setText((b * c / 0.011354) + " Pesos Chile");
            ((TextView) findViewById(R.id.textView7)).setText((b * c / 2.2852) + " Reales Brasil");
            ((TextView) findViewById(R.id.textView8)).setText((b * c / 1.1379) + " Yuan China");
            ((TextView) findViewById(R.id.textView9)).setText((b * c / 0.05849034) + " Yen Japon");
        }
    }

    public void calcular(Double b) {


        Double c = 0.0;

        switch (aux) {

            case 0:
                c = 1.0;
                break;
            case 1:
                c = 6.96;
                break;
            case 2:
                c = 7.52;
                break;
            case 3:
                c = 2.23;
                break;
            case 4:
                c = 0.011354;
                break;
            case 5:
                c = 2.2852;
                break;
            case 6:
                c = 1.1379;
                break;
            case 7:
                c = 0.05849034;
                break;

        }

        ((TextView) findViewById(R.id.textView3)).setText((b * c / 6.96) + " Dolares");
        ((TextView) findViewById(R.id.textView4)).setText((b * c / 7.52) + " Euros");
        ((TextView) findViewById(R.id.textView5)).setText((b * c / 2.23) + " Soles");
        ((TextView) findViewById(R.id.textView6)).setText((b * c / 0.011354) + " Pesos Chile");
        ((TextView) findViewById(R.id.textView7)).setText((b * c / 2.2852) + " Reales Brasil");
        ((TextView) findViewById(R.id.textView8)).setText((b * c / 1.1379) + " Yuan China");
        ((TextView) findViewById(R.id.textView9)).setText((b * c / 0.05849034) + " Yen Japon");
        ((TextView) findViewById(R.id.textView10)).setText((b * c) + " Bolivianos");

    }

    public void resetear(View view) {
        ((EditText) findViewById(R.id.editText1)).setText("");

        ((TextView) findViewById(R.id.textView3)).setText("");
        ((TextView) findViewById(R.id.textView4)).setText("");
        ((TextView) findViewById(R.id.textView5)).setText("");
        ((TextView) findViewById(R.id.textView6)).setText("");
        ((TextView) findViewById(R.id.textView7)).setText("");
        ((TextView) findViewById(R.id.textView8)).setText("");
        ((TextView) findViewById(R.id.textView9)).setText("");
        ((TextView) findViewById(R.id.textView10)).setText("");
    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}
