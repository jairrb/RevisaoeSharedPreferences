package br.com.digitalhouse.revisaoesharedpreferences.home.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.adapters.RecicleViewContactAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecicleViewContactAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Add findViewById para Recycler
        recyclerView = findViewById(R.id.);

        return view;
    }

}
