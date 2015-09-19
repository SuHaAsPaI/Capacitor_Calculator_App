package com.suhaas.capacitorcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eCode, eMicro, eNano, ePico;
    Button b_Code, b_Micro, b_Nano, b_Pico;
    int val[] = {10, 12, 15, 18, 22, 27, 33, 47, 58, 68, 82};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eCode = (EditText) findViewById(R.id.e_code);
        eMicro = (EditText) findViewById(R.id.e_micrp);
        eNano = (EditText) findViewById(R.id.e_nano);
        ePico = (EditText) findViewById(R.id.e_pico);

        b_Code = (Button) findViewById(R.id.bcode);
        b_Micro = (Button) findViewById(R.id.bmicro);
        b_Nano = (Button) findViewById(R.id.bnano);
        b_Pico = (Button) findViewById(R.id.bpico);


        b_Code.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                from_code();
            }
        });

        b_Micro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                from_micro();
            }
        });

        b_Nano.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                from_nano();
            }
        });

        b_Pico.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                from_pico();
            }
        });
    }


    private void from_code() {
        try {
            String z = eCode.getText().toString();
            int a = Integer.parseInt(z);
            int b = eCode.getText().toString().length();
            int c = a % 10;
            int d = a / 10;
            if (b == 3 & c == 0) {

                ePico.setHint(String.valueOf(d));
                eNano.setHint("0.0" + String.valueOf(d));
                eMicro.setHint("0.0000" + String.valueOf(d));
            } else if (b == 3 & c == 1) {
                ePico.setHint(String.valueOf(d * 10));
                eNano.setHint("0." + String.valueOf(d * 10));
                eMicro.setHint("0.000" + String.valueOf(d * 10));
            } else if (b == 3 & c == 2) {
                ePico.setHint(String.valueOf(d * 100));
                eNano.setHint(String.valueOf(d * 0.1));
                eMicro.setHint("0.00" + String.valueOf(d));
            } else if (b == 3 & c == 3) {
                ePico.setText(String.valueOf(d * 1000));
                eNano.setText(String.valueOf(d));
                eMicro.setText("0.0" + String.valueOf(d));
            } else if (b == 3 & c == 4) {
                ePico.setHint(String.valueOf(d * 10000));
                eNano.setHint(String.valueOf(d * 10));
                eMicro.setHint("0." + String.valueOf(d));
            } else if (b == 3 & c == 5) {
                if (d == 10) {
                    ePico.setHint(String.valueOf(d * 100000));
                    eNano.setHint(String.valueOf(d * 1000));
                    eMicro.setHint(String.valueOf(d * 0.1));
                } else {
                    Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT)
                            .show();
                }
            } else {
                Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT)
                        .show();
            }
        } catch (NumberFormatException e) {
            System.out.print(e);
            Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
        }

    }

    private void from_nano() {
        try {
            String z = eNano.getText().toString();
            float a = Float.parseFloat(z);
            double micro = a * 0.001;
            float pico = a * 1000;
            eMicro.setHint(String.valueOf(micro));
            ePico.setHint(String.valueOf(pico));

            if (pico < 100.0) {
                // xx
                int h = (int) (pico * 10);
                eCode.setHint(String.valueOf(h));
            } else if (pico >= 100 & pico < 1000.0) {
                // xx0
                int h = (int) (pico / 10);
                eCode.setHint(String.valueOf(h) + "1");
            } else if (pico >= 1000.0 & pico < 10000.0) {
                // xx00
                int h = (int) (pico / 100);
                eCode.setHint(String.valueOf(h) + "2");
            } else if (pico >= 10000.0 & pico < 100000.0) {
                // xx000
                int h = (int) (pico / 1000);
                eCode.setHint(String.valueOf(h) + "3");

            } else if (pico >= 100000.0 & pico < 1000000.0) {
                // xx0000
                int h = (int) (pico / 10000);
                eCode.setHint(String.valueOf(h) + "4");
            } else if (pico == 1000000.0) {
                // 1000000
                eCode.setHint("105");
            } else {
                Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            System.out.print(e);
            Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void from_pico() {

        try {
            String z = ePico.getText().toString();
            float a = Float.parseFloat(z);
            float pico = a;
            double micro = a * 0.000001;
            double nano = a * 0.001;
            eMicro.setHint(String.valueOf(micro));
            eNano.setHint(String.valueOf(nano));

            if (pico < 100.0) {
                // xx
                int h = (int) (pico * 10);
                eCode.setHint(String.valueOf(h));
            } else if (pico >= 100 & pico < 1000.0) {
                // xx0
                int h = (int) (pico / 10);
                eCode.setHint(String.valueOf(h) + "1");
            } else if (pico >= 1000.0 & pico < 10000.0) {
                // xx00
                int h = (int) (pico / 100);
                eCode.setHint(String.valueOf(h) + "2");
            } else if (pico >= 10000.0 & pico < 100000.0) {
                // xx000
                int h = (int) (pico / 1000);
                eCode.setHint(String.valueOf(h) + "3");

            } else if (pico >= 100000.0 & pico < 1000000.0) {
                // xx0000
                int h = (int) (pico / 10000);
                eCode.setHint(String.valueOf(h) + "4");
            } else if (pico == 1000000.0) {
                // 1000000
                eCode.setHint("105");
            } else {
                Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            System.out.print(e);
            Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void from_micro() {
        try {
            String z = eMicro.getText().toString();
            float a = Float.parseFloat(z);
            float nano = a * 1000;
            float pico = a * 1000000;
            eNano.setHint(String.valueOf(nano));
            ePico.setHint(String.valueOf(pico));

            if (pico < 100.0) {
                // xx
                int h = (int) (pico * 10);
                eCode.setHint(String.valueOf(h));
            } else if (pico >= 100 & pico < 1000.0) {
                // xx0
                int h = (int) (pico / 10);
                eCode.setHint(String.valueOf(h) + "1");
            } else if (pico >= 1000.0 & pico < 10000.0) {
                // xx00
                int h = (int) (pico / 100);
                eCode.setHint(String.valueOf(h) + "2");
            } else if (pico >= 10000.0 & pico < 100000.0) {
                // xx000
                int h = (int) (pico / 1000);
                eCode.setHint(String.valueOf(h) + "3");

            } else if (pico >= 100000.0 & pico < 1000000.0) {
                // xx0000
                int h = (int) (pico / 10000);
                eCode.setHint(String.valueOf(h) + "4");
            } else if (pico == 1000000.0) {
                // 1000000
                eCode.setHint("105");
            } else {
                Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            System.out.print(e);
            Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
        }
    }
}