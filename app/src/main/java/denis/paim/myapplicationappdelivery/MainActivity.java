package denis.paim.myapplicationappdelivery;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    CardView mcCard;
    CardView kfcCard;
    CardView sushiCard;
    TextView txtRestaurante;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcCard = findViewById(R.id.mcCard);
        kfcCard = findViewById(R.id.kfcCard);
        sushiCard = findViewById(R.id.sushiCard);
        txtRestaurante = findViewById(R.id.txtProdutos);

        mcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.entrar_esquerda, R.anim.sair_direita, R.anim.entrar_esquerda, R.anim.sair_direita);
                transaction.add(R.id.flFragment, new McDonaldsFragment()).commit();

                mcCard.setCardElevation(0);
                kfcCard.setCardElevation(8);
                sushiCard.setCardElevation(8);
                txtRestaurante.setText("McDonald's");

            }
        });

        kfcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.entrar_esquerda, R.anim.sair_direita, R.anim.entrar_esquerda, R.anim.sair_direita);
                transaction.add(R.id.flFragment, new KfcFragment()).commit();

                mcCard.setCardElevation(8);
                kfcCard.setCardElevation(0);
                sushiCard.setCardElevation(8);
                txtRestaurante.setText("KFC");

            }
        });

        sushiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.entrar_esquerda, R.anim.sair_direita, R.anim.entrar_esquerda, R.anim.sair_direita);
                transaction.add(R.id.flFragment, new SushiFragment()).commit();

                mcCard.setCardElevation(8);
                kfcCard.setCardElevation(8);
                sushiCard.setCardElevation(0);
                txtRestaurante.setText("Sushi");

            }
        });

    }
}