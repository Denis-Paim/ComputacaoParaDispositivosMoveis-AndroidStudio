package denis.paim.myapplicationappdelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CarrinhoActivity extends AppCompatActivity {


    private int contador = 1;
    private float precoEntrega = 0;
    private float subTotal = 0;
    private float totalAtualizado = 0;
    private boolean switchLigado = false;

    TextView nome;
    TextView preco;
    TextView quantidadeCarrinho;
    TextView subTotalAtualizado;
    TextView total;
    TextView custoEntrega;
    TextView txtFinalizarPedido;
    ImageView imagem;
    ImageView icMais;
    ImageView icMenos;
    SwitchCompat switchEntrega;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrinho_activity);

        nome = findViewById(R.id.txtNomeCarrinho);
        preco = findViewById(R.id.txtPrecoCarrinho);
        imagem = findViewById(R.id.imagemCarrinho);
        quantidadeCarrinho = findViewById(R.id.txt_contador);
        icMais = findViewById(R.id.ic_mais);
        icMenos = findViewById(R.id.ic_menos);
        subTotalAtualizado = findViewById(R.id.txtSubTotal);
        custoEntrega = findViewById(R.id.txtCustoEntrega);
        total = findViewById(R.id.txtPrecoTotal);
        txtFinalizarPedido = findViewById(R.id.txtAvancar);
        switchEntrega = findViewById(R.id.switchEntrega);

        DecimalFormat df = new DecimalFormat("0.00");

        Bundle extras = getIntent().getExtras();

        nome.setText(extras.getString("produto"));
        float precoFloat = Float.valueOf(extras.getString("preco"));
        preco.setText("R$ "+df.format(precoFloat));
        imagem.setImageResource(extras.getInt("imagem", R.drawable.ic_app_logo));

        subTotalAtualizado.setText("R$ "+df.format(precoFloat));
        total.setText("R$ "+df.format(precoFloat));

        quantidadeCarrinho.setText(String.valueOf(contador));

        switchEntrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switchEntrega.isChecked()){
                    precoEntrega = 8.0f;
                    custoEntrega.setText("R$ "+df.format(precoEntrega));
                    total.setText("R$ "+df.format(calcValorTotal(precoFloat, contador, precoEntrega)));
                    switchLigado = true;
                }else{
                    precoEntrega = 0.0f;
                    custoEntrega.setText("R$ "+df.format(precoEntrega));
                    total.setText("R$ "+df.format(calcValorTotal(precoFloat, contador, precoEntrega) - precoEntrega));
                    switchLigado = false;
                }
            }
        });

        icMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                quantidadeCarrinho.setText(String.valueOf(contador));
                subTotal = calcSubTotal(precoFloat, contador);
                subTotalAtualizado.setText("R$ "+df.format(subTotal));
                total.setText("R$ "+df.format(calcValorTotal(precoFloat, contador, precoEntrega)));
            }
        });

        icMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contador > 1){
                    contador--;
                    subTotal = subTotal - precoFloat;
                    quantidadeCarrinho.setText(String.valueOf(contador));
                    subTotalAtualizado.setText("R$ "+df.format(subTotal));
                    totalAtualizado = subTotal + precoEntrega;
                    total.setText("R$ "+df.format(totalAtualizado));
                }
            }
        });

        txtFinalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CarrinhoActivity.this, DadosClientes.class);
                intent.putExtra("switchLigado", switchLigado);
                startActivity(intent);

            }
        });
    }

    public float calcSubTotal(float preco, int contador){
        float custoSubTotal = preco * contador;
        return custoSubTotal;
    }

    public float calcValorTotal(float preco, int contador, float precoEntrega){
        float custoTotal = (preco * contador) + precoEntrega;
        return custoTotal;
    }

}