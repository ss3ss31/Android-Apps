package com.example.sheinsonapplication.ui.products;

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
import com.example.sheinsonapplication.adapters.ProductsAdapter;
import com.example.sheinsonapplication.databinding.FragmentProductsBinding;

public class ProductsFragment extends Fragment {

    private ProductsViewModel productsViewModel;
    private FragmentProductsBinding binding;

    //--

    private GridView products_grid;

    private String [] products_names;
    private String [] products_descriptions;
    private int [] products_images;

    //--

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productsViewModel =
                new ViewModelProvider(this).get(ProductsViewModel.class);

        binding = FragmentProductsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //--
        //      initialize
        products_grid = (GridView) root.findViewById(R.id.lv_grid_products);

        products_names = new String[]{};
        products_descriptions = new String[]{};
        products_images = new int [] {};

        products_names = getResources().getStringArray(R.array.products_names_array);
        products_descriptions = getResources().getStringArray(R.array.products_descriptions_array);
        products_images = getResources().getIntArray(R.array.products_images_array);

        //-- get the images from xml file string-array-projects.xml
        TypedArray ta = getResources().obtainTypedArray(R.array.products_images_array);
        Drawable[] product_images_array = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                product_images_array[i] = ContextCompat.getDrawable(this.getContext(), id);
            }
        }
        ta.recycle();
        //--


        ProductsAdapter productsAdapter = new ProductsAdapter(this.getContext(),R.layout.product_item_view,products_names,product_images_array,products_descriptions);
        products_grid.setAdapter(productsAdapter);

        //--
        //--

        final TextView textView = binding.textProducts;
        productsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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