package br.com.crusoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.aware.PublishConfig;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import javax.xml.transform.dom.DOMSource;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultadoo);
    }

    public void calcularPreco(View view){
        // recuperar valores digitado
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validaçao dos campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados){
            //Convertendo string para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            // Fazer calculo do menor preço
            Double resultado = valorAlcool/valorGasolina;
            if (resultado >= 0.7){
                textResultado.setText("Melhor utilizar gasolina");
            }else {
                textResultado.setText("Melhor utilizar álcool");
            }
        }else {
            textResultado.setText("Preencha os preços primeiro! ");
        }



    }

    public Boolean  validarCampos(String pAlcool , String pGasolina){
        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;

        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}