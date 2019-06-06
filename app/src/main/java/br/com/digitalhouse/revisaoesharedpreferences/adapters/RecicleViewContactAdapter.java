package br.com.digitalhouse.revisaoesharedpreferences.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.RecycleViewClickListener;
import br.com.digitalhouse.revisaoesharedpreferences.model.Contact;

public class RecicleViewContactAdapter extends RecyclerView.Adapter<RecicleViewContactAdapter.ViewHolder> {
    private List<Contact> contacts;
    private RecycleViewClickListener listener;

    public RecicleViewContactAdapter(List<Contact> contacts, RecycleViewClickListener listener) {
        this.contacts = contacts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecicleViewContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_recycleview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecicleViewContactAdapter.ViewHolder viewHolder, int i) {
        final Contact contact = contacts.get(i);
        viewHolder.bind(contact);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(contact);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    //Class ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewPhoto;
        private TextView textViewName;
        private TextView textViewPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(Contact contact) {
            imageViewPhoto.setImageDrawable(ContextCompat
                    .getDrawable(imageViewPhoto.getContext(), contact.getPhoto()));
            textViewName.setText(contact.getName());
            textViewPhone.setText(contact.getPhone());
        }
    }
}
