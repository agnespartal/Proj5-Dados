package com.example.proj5_dados;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbD4;
    private CheckBox cbD6;
    private CheckBox cbD8;
    private CheckBox cbD10;
    private CheckBox cbD12;
    private CheckBox cbD20;
    private CheckBox cbD100;
    private TextView txtSaida;
    private int maximoSelecionado = 3;
    private int secaoAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cbD4 = findViewById(R.id.cbD4);
        cbD6 = findViewById(R.id.cbD6);
        cbD8 = findViewById(R.id.cbD8);
        cbD10 = findViewById(R.id.cbD10);
        cbD12 = findViewById(R.id.cbD12);
        cbD20 = findViewById(R.id.cbD20);
        cbD100 = findViewById(R.id.cbD100);
        txtSaida = findViewById(R.id.txtSaida);

        Button btnRolar = findViewById(R.id.btnRolar);

        btnRolar.setOnClickListener(op -> RolarDados());

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    secaoAtual++;
                    if (secaoAtual >= maximoSelecionado) {
                        if (!cbD4.isChecked()) cbD4.setEnabled(false);
                        if (!cbD6.isChecked()) cbD6.setEnabled(false);
                        if (!cbD8.isChecked()) cbD8.setEnabled(false);
                        if (!cbD10.isChecked()) cbD10.setEnabled(false);
                        if (!cbD12.isChecked()) cbD12.setEnabled(false);
                        if (!cbD20.isChecked()) cbD20.setEnabled(false);
                        if (!cbD100.isChecked()) cbD100.setEnabled(false);
                    }
                } else {
                    secaoAtual--;
                    if (secaoAtual < maximoSelecionado) {
                        cbD4.setEnabled(true);
                        cbD6.setEnabled(true);
                        cbD8.setEnabled(true);
                        cbD10.setEnabled(true);
                        cbD12.setEnabled(true);
                        cbD20.setEnabled(true);
                        cbD100.setEnabled(true);
                    }
                }
            }
        };
    }

    private void RolarDados()
    {
        StringBuffer sb = new StringBuffer();
        Random rd = new Random();

        if (cbD4.isChecked()){
            int num = rd.nextInt(4) + 1;
            String saida = "D4: " + num + "\n";
            sb.append(saida);
        }
        if (cbD6.isChecked()){
            int num = rd.nextInt(6) + 1;
            String saida = "D6: " + num + "\n";
            sb.append(saida);
        }
        if (cbD8.isChecked()){
            int num = rd.nextInt(8) + 1;
            String saida = "D8: " + num + "\n";
            sb.append(saida);
        }
        if (cbD10.isChecked()){
            int num = rd.nextInt(10) + 1;
            String saida = "D10: " + num + "\n";
            sb.append(saida);
        }
        if (cbD12.isChecked()){
            int num = rd.nextInt(12) + 1;
            String saida = "D12: " + num + "\n";
            sb.append(saida);
        }
        if (cbD20.isChecked()){
            int num = rd.nextInt(20) + 1;
            String saida = "D20: " + num + "\n";
            sb.append(saida);
        }
        if (cbD100.isChecked()){
            int num = rd.nextInt(100) + 1;
            String saida = "D100: " + num + "\n";
            sb.append(saida);
        }

        txtSaida.setText(sb);
    }
}