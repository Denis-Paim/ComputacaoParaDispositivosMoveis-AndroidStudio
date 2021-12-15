package denis.paim.myapplicationappdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DadosClientes extends AppCompatActivity {

    private boolean switchLigado;

    EditText edNomeCliente;
    EditText edEnderecoCliente;
    EditText edCidadeCliente;
    EditText edCep;
    EditText edNumeroCartao;
    EditText edValidadeCartao;
    EditText edNumeroSeguranca;
    TextView txtFinalizarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_clientes);

        edNomeCliente = findViewById(R.id.edNomeCliente);
        edEnderecoCliente = findViewById(R.id.edEnderecoCliente);
        edCidadeCliente = findViewById(R.id.edCidadeCliente);
        edCep = findViewById(R.id.edCep);
        edNumeroCartao = findViewById(R.id.edNumeroCartao);
        edValidadeCartao = findViewById(R.id.edValidadeCartao);
        edNumeroSeguranca = findViewById(R.id.edNumeroSeguranca);
        txtFinalizarPedido = findViewById(R.id.txtFinalizarPedido);


        Bundle extras = getIntent().getExtras();
        switchLigado = extras.getBoolean("switchLigado");

        if (switchLigado){

            edEnderecoCliente.setVisibility(View.VISIBLE);
            edCidadeCliente.setVisibility(View.VISIBLE);
            edCep.setVisibility(View.VISIBLE);

        }

        txtFinalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cliente = edNomeCliente.getText().toString();
                String cartao = edNumeroCartao.getText().toString();
                String validadeCartao = edValidadeCartao.getText().toString();
                String numeroSeguranca = edNumeroSeguranca.getText().toString();

                if (cliente.isEmpty() || cartao.isEmpty() || validadeCartao.isEmpty() || numeroSeguranca.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.alerta),
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.pedido_recebido)+" "+cliente,
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}