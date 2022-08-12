package com.example.sheinsonapplication.ui.brands;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sheinsonapplication.R;
import com.example.sheinsonapplication.adapters.BrandsAdapter;
import com.example.sheinsonapplication.databinding.FragmentBrandsBinding;

public class BrandsFragment extends Fragment {

    private BrandsViewModel brandsViewModel;
    private FragmentBrandsBinding binding;

    //--
    private GridView brands_grid;

    private String [] brands_names;
    private String [] brands_descriptions;
    private int [] brands_images;
    private int [] brands_logos;
    //--

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        brandsViewModel =
                new ViewModelProvider(this).get(BrandsViewModel.class);

        binding = FragmentBrandsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //--


        //--  initialize
        brands_grid = (GridView) root.findViewById(R.id.lv_grid_brand);

        brands_names = new String[]{};
        brands_descriptions = new String[]{};
        brands_images = new int [] {};
        brands_logos = new int [] {};

        brands_names = getResources().getStringArray(R.array.brands_names_array);
        brands_descriptions = getResources().getStringArray(R.array.brands_descriptions_array);
        brands_images = getResources().getIntArray(R.array.brands_images_array);
        brands_logos = getResources().getIntArray(R.array.brands_logos_array);

        //-- get the images from xml file string-array-brands.xml
        TypedArray ta = getResources().obtainTypedArray(R.array.brands_images_array);
        Drawable[] brand_images_array = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                brand_images_array[i] = ContextCompat.getDrawable(this.getContext(), id);
            }
        }
        ta.recycle();

        TypedArray ta2 = getResources().obtainTypedArray(R.array.brands_logos_array);
        Drawable[] brand_logos_array = new Drawable[ta2.length()];
        for (int i = 0; i < ta2.length(); i++) {
            int id = ta2.getResourceId(i, 0);
            if (id != 0) {
                brand_logos_array[i] = ContextCompat.getDrawable(this.getContext(), id);
            }
        }
        ta2.recycle();
        //--



        BrandsAdapter brandsAdapter = new BrandsAdapter(this.getContext(),R.layout.brand_item_view,brands_names,brand_images_array,brand_logos_array,brands_descriptions);
        brands_grid.setAdapter(brandsAdapter);

        //--

        final TextView textView = binding.textBrands;
        brandsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.textBrands.setText(s);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}