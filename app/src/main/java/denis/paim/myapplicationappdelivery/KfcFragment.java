package denis.paim.myapplicationappdelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class KfcFragment extends Fragment {

    RecyclerView recyclerView;
    ProdutosAdapter produtosAdapter;

    View view;

    public KfcFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.kfc_fragment, container, false);

        List<ProdutoModel> produtoList = new ArrayList<>();
        produtoList.add(new ProdutoModel(R.drawable.ic_balde_frango, "Balde frango", 29.90f));
        produtoList.add(new ProdutoModel(R.drawable.ic_nuggets, "Nuggets", 15.90f));
        produtoList.add(new ProdutoModel(R.drawable.ic_sorvete_kfc, "Sorvete", 19.90f));
        produtoList.add(new ProdutoModel(R.drawable.ic_refrigerante, "Refrigerante", 12.00f));

        iniciarRecyclerView(produtoList);

        return view;
    }

    private void iniciarRecyclerView(List<ProdutoModel> produtoList) {

        recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        produtosAdapter = new ProdutosAdapter(getContext(), produtoList);
        recyclerView.setAdapter(produtosAdapter);
    }

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

}
