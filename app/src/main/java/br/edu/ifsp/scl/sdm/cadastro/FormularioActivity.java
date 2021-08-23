package br.edu.ifsp.scl.sdm.cadastro;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

public class FormularioActivity extends Activity {

    // Lista de Estados (UF)
    private static final String[] ESTADOS = new String[] {
            "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará","Distrito Federal","Espírito Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Pará","Paraíba","Paraná","Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte","rio Grande do Sul","Rondônia","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"
    };


    protected void onCreate(Bundle iclicle) {
        super.onCreate(iclicle);
        setContentView(R.layout.activity_formulario);

        //Completa lista de Estados (UFs)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ESTADOS);
        AutoCompleteTextView autoCompleteTextView;
        TextInputLayout textInputLayout = findViewById(R.id.cboEstados);
        autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setInputType(InputType.TYPE_NULL);

    }


}

/*
        textoEt = findViewById(R.id.textoEt);
        textoEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        cliqueAquiBt = findViewById(R.id.cliqueAquiBt);
        cliqueAquiBt.setOnClickListener(this);
        opcoesSp = findViewById(R.id.opcoesSp);
        opcoesSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        selecionadoCb = findViewById(R.id.selecionadoCb);
        radio1Rb = findViewById(R.id.radio1Rb);
    }

    @Override
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();

        // EditText
        sb.append(textoEt.getText().toString());
        sb.append('\n');

        // Spinner
        sb.append(((TextView) opcoesSp.getSelectedView()).getText());
        sb.append('\n');

        // CheckBox
        sb.append(selecionadoCb.isChecked() ? "selecionado" : "não selecionado");
        sb.append('\n');

        // RadioButton
        sb.append(radio1Rb.isChecked() ? "Radio 1" : "Radio 2");
        sb.append('\n');

        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
*/
