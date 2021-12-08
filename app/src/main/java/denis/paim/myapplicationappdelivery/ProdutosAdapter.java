package denis.paim.myapplicationappdelivery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder> {

    Context context;
    List<ProdutoModel> produtosList;

    public ProdutosAdapter(Context context, List<ProdutoModel> produtosList) {

        this.context = context;
        this.produtosList = produtosList;
    }

    @NonNull
    @Override
    public ProdutosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false);
        return new ProdutosViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProdutosViewHolder holder, int position) {

        holder.imagem.setImageResource(produtosList.get(position).getImagem());
        holder.nome.setText(produtosList.get(position).getNome());
        holder.preco.setText("R$ "+produtosList.get(position).getPreco());

        holder.btnAdicionarCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProdutoModel objeto = produtosList.get(holder.getAdapterPosition());
//                holder.botoesLayout.setVisibility(View.VISIBLE);
//                holder.adicionarCarrinho.setVisibility(View.GONE);
//                objeto.setTotalNoCarrinho(1);
//                holder.contador.setText(String.valueOf(objeto.getTotalNoCarrinho()));

                Intent intent = new Intent(context, CarrinhoActivity.class);
                intent.putExtra("produto", produtosList.get(holder.getAdapterPosition()).getNome());
                intent.putExtra("preco", String.valueOf(produtosList.get(holder.getAdapterPosition()).getPreco()));
                intent.putExtra("imagem", produtosList.get(holder.getAdapterPosition()).getImagem());
                context.startActivity(intent);

            }
        });

//        holder.buttonMais.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ProdutoModel objeto = produtosList.get(holder.getAdapterPosition());
//                int total = objeto.getTotalNoCarrinho();
//                total++;
//                objeto.setTotalNoCarrinho(total);
//                holder.contador.setText(String.valueOf(total));
//
//            }
//        });

//        holder.buttonMenos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ProdutoModel objeto = produtosList.get(holder.getAdapterPosition());
//                int total = objeto.getTotalNoCarrinho();
//                total--;
//                if (total > 0){
//                    objeto.setTotalNoCarrinho(total);
//                    holder.contador.setText(String.valueOf(total));
//                }else{
//                    holder.botoesLayout.setVisibility(View.GONE);
//                    holder.adicionarCarrinho.setVisibility(View.VISIBLE);
//                    objeto.setTotalNoCarrinho(total);
//
//                }
//            }
//        });
    }


    @Override
    public int getItemCount() {

        return produtosList.size();

    }


    public class ProdutosViewHolder extends RecyclerView.ViewHolder {

        ImageView imagem;
        TextView nome;
        TextView preco;
        TextView btnAdicionarCarrinho;

        public ProdutosViewHolder(@NonNull View itemView) {
            super(itemView);

            imagem = itemView.findViewById(R.id.imagem);
            nome = itemView.findViewById(R.id.text_nome);
            preco = itemView.findViewById(R.id.text_preco);
            btnAdicionarCarrinho = itemView.findViewById(R.id.btnAdicionarCarrinho);

        }
    }
}
