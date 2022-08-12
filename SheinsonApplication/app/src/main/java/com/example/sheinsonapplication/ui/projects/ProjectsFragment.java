package com.example.sheinsonapplication.ui.projects;

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
import com.example.sheinsonapplication.adapters.ProjectsAdapter;
import com.example.sheinsonapplication.databinding.FragmentProjectsBinding;

public class ProjectsFragment extends Fragment {

    // vatiables
    private ProjectsViewModel mViewModel;
    private FragmentProjectsBinding binding;

    private GridView projects_grid;

    private String [] projects_names;
    private String [] projects_descriptions;
    private int [] projects_images;
    private int [] projects_logos;


//--------

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(ProjectsViewModel.class);
        binding = FragmentProjectsBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        //--  initialize
        projects_grid = (GridView) root.findViewById(R.id.lv_grid_projects);

        projects_names = new String[]{};
        projects_descriptions = new String[]{};
        projects_images = new int [] {};

        projects_names = getResources().getStringArray(R.array.project_names_array);
        projects_descriptions = getResources().getStringArray(R.array.project_descriptions_array);
        projects_images = getResources().getIntArray(R.array.project_images_array);

        //-- get the images from xml file string-array-projects.xml
        TypedArray ta = getResources().obtainTypedArray(R.array.project_images_array);
        Drawable[] project_images_array = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                project_images_array[i] = ContextCompat.getDrawable(this.getContext(), id);
            }
        }
        ta.recycle();
        //--


        ProjectsAdapter projectsAdapter = new ProjectsAdapter(this.getContext(),R.layout.project_item_view,projects_names,project_images_array,projects_descriptions);
        projects_grid.setAdapter(projectsAdapter);

        //--

        final TextView textView = binding.textProjects;
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.textProjects.setText(s);
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