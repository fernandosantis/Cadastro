package br.edu.ifsp.scl.sdm.cadastro;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

public class FormularioActivity extends AppCompatActivity implements View.OnClickListener {

    // Lista de Estados (UF)
    private static final String[] ESTADOS = new String[]{
            "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
    };
    private TextInputLayout txtEstados;
    private MaterialAutoCompleteTextView cboEstados;

    void completaEstados() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ESTADOS);
        TextInputLayout txtEstados = findViewById(R.id.cboEstados);
        cboEstados = (MaterialAutoCompleteTextView) txtEstados.getEditText();
        cboEstados.setAdapter(adapter);
        cboEstados.setInputType(InputType.TYPE_NULL);
    }
    // Declara Variáveis dos Componentes da UI
    private TextInputLayout txtNomeCompleto;
    private TextInputLayout txtTelefone;
    private TextInputLayout txtEmail;
    private MaterialCheckBox chkMailList;
    private MaterialRadioButton optSexoFem;
    private MaterialRadioButton optSexoMasc;
    private TextInputLayout txtCidade;
    private MaterialButton btnLimpar;
    private MaterialButton btnSalvar;

    private void limpaForm() {
        txtNomeCompleto.getEditText().setText("");
        txtTelefone.getEditText().setText("");
        txtEmail.getEditText().setText("");
        chkMailList.setChecked(true);
        optSexoFem.setChecked(true);
        optSexoMasc.setChecked(false);
        cboEstados.setText("");
        txtCidade.getEditText().setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // Faz link elemento -> variavel ( pelo ID )
        txtNomeCompleto = findViewById(R.id.txtNomeCompleto);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtEmail = findViewById(R.id.txtEmail);
        chkMailList = findViewById(R.id.chkMailList);
        optSexoFem = findViewById(R.id.optSexoFem);
        optSexoMasc = findViewById(R.id.optSexoMasc);

        //Completa lista de Estados (UFs)
        completaEstados();

        txtCidade = findViewById(R.id.txtCidade);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(this);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);
        limpaForm();


    }
    @Override
    public void onClick (View view){
        StringBuilder sb = new StringBuilder();
        if (view == btnSalvar) {
            // Nome, Telefone e Email
            sb.append("Nome: " + txtNomeCompleto.getEditText().getText().toString());
            sb.append('\n');
            String sexo;
            if (optSexoFem.isChecked()) { sexo = "Feminino";} else { sexo = "Masculino";};
            sb.append("Sexo: " + sexo);
            sb.append('\n');
            sb.append("Telefone: " + txtTelefone.getEditText().getText().toString());
            sb.append('\n');
            sb.append("Email: " + txtEmail.getEditText().getText().toString());
            // Java não aceita atribuição direta : String mailList = if(chkMailList.isChecked()) {"Enviar E-mails"} else {"Não enviar E-mails"};
            String mailList;
            mailList = "Enviar E-mails";
            if(!chkMailList.isChecked()) {mailList = "Não " + mailList;};
            sb.append('\n');
            sb.append(mailList);
            sb.append('\n');
            sb.append(txtCidade.getEditText().getText().toString() + ", " + cboEstados.getText().toString());

    /*        // Spinner
            sb.append(((TextView) opcoesSp.getSelectedView()).getText());
            sb.append('\n');

            // CheckBox
            sb.append(selecionadoCb.isChecked() ? "selecionado" : "não selecionado");
            sb.append('\n');

            // RadioButton
            sb.append(radio1Rb.isChecked() ? "Radio 1" : "Radio 2");
            sb.append('\n');*/

        } else {
            limpaForm();
            sb.append("Formulário Redefinido");
            sb.append('\n');
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();

    }
}

  /*      textoEt = findViewById(R.id.textoEt);
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
    }*/