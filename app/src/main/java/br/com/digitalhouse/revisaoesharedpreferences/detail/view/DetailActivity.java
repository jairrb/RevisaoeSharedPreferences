package br.com.digitalhouse.revisaoesharedpreferences.detail.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.model.Contact;


public class DetailActivity extends AppCompatActivity {

    private ImageView circleImageViewPhoto;
    private TextView textViewName;
    private TextView textViewPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        textViewName = findViewById(R.id.textViewName);
        textViewPhone = findViewById(R.id.textViewPhone);
        circleImageViewPhoto = findViewById(R.id.circleImageViewPhoto);

        Contact contact = getIntent().getParcelableExtra("CONTACT");

        if (contact != null) {
            textViewName.setText(contact.getName());
            textViewPhone.setText(contact.getPhone());
            circleImageViewPhoto.setImageDrawable(ContextCompat
                    .getDrawable(circleImageViewPhoto.getContext(), contact.getPhoto()));
        }
    }
}
