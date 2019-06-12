package br.com.digitalhouse.revisaoesharedpreferences.model;

import android.support.v4.app.Fragment;

public class FragmentsDetailModel {
    private Fragment fragment;
    private String title;

    public FragmentsDetailModel() {
    }

    public FragmentsDetailModel(Fragment fragment, String titulo) {
        this.fragment = fragment;
        this.title = titulo;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
