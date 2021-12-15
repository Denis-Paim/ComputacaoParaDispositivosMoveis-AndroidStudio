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


public class SushiFragment extends Fragment {

    RecyclerView recyclerView;
    ProdutosAdapter produtosAdapter;

    View view;

    public SushiFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.sushi_fragment, container, false);

        List<ProdutoModel> produtoList = new ArrayList<>();
        produtoList.add(new ProdutoModel(R.drawable.ic_ramen, "Ramen", 34.90f));
        produtoList.add(new ProdutoModel(R.drawable.ic_sushi, "Sushi", 24.00f));
        produtoList.add(new ProdutoModel(R.drawable.ic_onigiri, "Onigiri", 14.90f));
        produtoList.add(new ProdutoModel(R.drawable.ic_temaki, "Temaki", 19.00f));

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
