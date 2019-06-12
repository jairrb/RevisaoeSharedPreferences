package br.com.digitalhouse.revisaoesharedpreferences.detail.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.adapters.ViewPagerDetailAdapter;
import br.com.digitalhouse.revisaoesharedpreferences.home.view.HomeFragment;
import br.com.digitalhouse.revisaoesharedpreferences.model.Contact;
import br.com.digitalhouse.revisaoesharedpreferences.model.FragmentsDetailModel;


public class DetailActivity extends AppCompatActivity {

    private ImageView circleImageViewPhoto;
    private TextView textViewName;
    private TextView textViewPhone;
    private ViewPager viewPagerDetail;
    private TabLayout tabDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initViews();

        Contact contact = getIntent().getParcelableExtra("CONTACT");

        if (contact != null) {
            textViewName.setText(contact.getName());
            textViewPhone.setText(contact.getPhone());
            circleImageViewPhoto.setImageDrawable(ContextCompat
                    .getDrawable(circleImageViewPhoto.getContext(), contact.getPhoto()));
        }

        ViewPagerDetailAdapter adapter = new ViewPagerDetailAdapter(getSupportFragmentManager(),getFragmentList());
        viewPagerDetail.setAdapter(adapter);
        //viewPagerDetail.getOffscreenPageLimit(getFragmentList().size());
        tabDetail.setupWithViewPager(viewPagerDetail);
    }

    private List<FragmentsDetailModel> getFragmentList() {
        List<FragmentsDetailModel> fragmentsDetailModels = new ArrayList<>();

        fragmentsDetailModels.add(new FragmentsDetailModel(new HomeFragment(),"Home"));
        fragmentsDetailModels.add(new FragmentsDetailModel(new HomeFragment(),"Cadastro"));

        return fragmentsDetailModels;
    }

    private void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewPhone = findViewById(R.id.textViewPhone);
        circleImageViewPhoto = findViewById(R.id.circleImageViewPhoto);
        viewPagerDetail = findViewById(R.id.viewPagerDetail);
        tabDetail = findViewById(R.id.tabDetail);
    }
}
