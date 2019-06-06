package br.com.digitalhouse.revisaoesharedpreferences.home.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.interfaces.RecycleViewClickListener;
import br.com.digitalhouse.revisaoesharedpreferences.adapters.RecicleViewContactAdapter;
import br.com.digitalhouse.revisaoesharedpreferences.detail.view.DetailActivity;
import br.com.digitalhouse.revisaoesharedpreferences.model.Contact;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements RecycleViewClickListener {
    // Required empty public constructor
    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Add findViewById para recycler
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewContact);


        // Configurar recyclerview e adapater
        RecicleViewContactAdapter adapter = new RecicleViewContactAdapter(getContact(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Contact> getContact() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Selma Bouvier", "11-91111-1111", R.drawable.contact0));
        contacts.add(new Contact("Montgomery Burns", "11-91111-1111", R.drawable.contact1));
        contacts.add(new Contact("Apu Nahasapeemapetilon", "11-91111-1111", R.drawable.contact2));
        contacts.add(new Contact("Waylon Smithers", "11-91111-1111", R.drawable.contact3));
        contacts.add(new Contact("Moe Szyslak", "11-91111-1111", R.drawable.contact4));
        contacts.add(new Contact("Edna Krabappel", "11-91111-1111", R.drawable.contact5));
        contacts.add(new Contact("Marge Simpson", "11-91111-1111", R.drawable.contact6));
        contacts.add(new Contact("Jimbo Jones", "11-91111-1111", R.drawable.contact7));
        contacts.add(new Contact("Homer Simpson", "11-91111-1111", R.drawable.contact8));
        contacts.add(new Contact("Barney Gumble", "11-91111-1111", R.drawable.contact9));

        return contacts;
    }


    @Override
    public void onClick(Contact contact) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("CONTACT", contact);
        startActivity(intent);

    }
}
