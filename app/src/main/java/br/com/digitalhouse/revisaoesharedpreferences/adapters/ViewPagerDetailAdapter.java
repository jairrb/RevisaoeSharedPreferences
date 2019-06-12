package br.com.digitalhouse.revisaoesharedpreferences.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import br.com.digitalhouse.revisaoesharedpreferences.model.FragmentsDetailModel;

public class ViewPagerDetailAdapter extends FragmentStatePagerAdapter {
    private List<FragmentsDetailModel> fragmentsDetailModels;

    public ViewPagerDetailAdapter(FragmentManager fm, List<FragmentsDetailModel> fragmentsDetailModels) {
        super(fm);
        this.fragmentsDetailModels = fragmentsDetailModels;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentsDetailModels.get(i).getFragment();
    }

    @Override
    public int getCount() {

        return fragmentsDetailModels.size();
    }

    public CharSequence getTitle(int i) {
        return fragmentsDetailModels.get(i).getTitle();
    }

}
