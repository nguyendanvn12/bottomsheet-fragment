package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {
    FragmentBlankBinding blankBinding;
    ViewGroup viewGroup;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.viewGroup = container;
       blankBinding  = DataBindingUtil.inflate(inflater,R.layout.fragment_blank,container,false);
        blankBinding.rvtest.setAdapter(new Adapter());
        blankBinding.rvtest.setLayoutManager(new LinearLayoutManager(getContext()));
        view = new View(getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setBackgroundColor(Color.parseColor("#80000000"));
        viewGroup.addView(view);
        blankBinding.fgContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().onBackPressed();
            }
        });
        return blankBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewGroup.removeView(view);
    }
}
