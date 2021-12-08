package denis.paim.myapplicationappdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CarrinhoActivity extends AppCompatActivity {


    private int contador = 1;
    private float precoEntrega = 8.0f;
    private float subTotal = 0;

    TextView nome;
    TextView preco;
    TextView quantidadeCarrinho;
    TextView subTotalAtualizado;
    TextView total;
    TextView custoEntrega;
    ImageView imagem;
    ImageView icMais;
    ImageView icMenos;


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


        Bundle extras = getIntent().getExtras();

        float precoFloat = Float.valueOf(extras.getString("preco"));
        float precoMaisEntrega = precoFloat + precoEntrega;

        DecimalFormat df = new DecimalFormat("0.00");

        nome.setText(extras.getString("produto"));
        preco.setText("R$ "+df.format(precoFloat));
        imagem.setImageResource(extras.getInt("imagem", R.drawable.ic_app_logo));

        subTotalAtualizado.setText("R$ "+df.format(precoFloat));
        custoEntrega.setText("R$ "+df.format(precoEntrega));
        total.setText("R$ "+df.format(precoMaisEntrega));

        quantidadeCarrinho.setText(String.valueOf(contador));

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
                    float totalAtualizado = subTotal + precoEntrega;
                    total.setText("R$ "+df.format(totalAtualizado));
                }
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