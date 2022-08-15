package com.bank.atm_app.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bank.atm_app.DetailsActivity;
import com.example.atm_app.R;
import com.bank.atm_app.adapters.NotificationAdapter;
import com.example.atm_app.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    // System Variables
    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;


    // My Variables

    ImageView notificationIcon,isReadIcon;
    TextView  notificationTitle,notificationDesc;


    private ListView mListView_no;

     private String[] title;
     private String[] desc;
     private int[]    imgs;
     private int []   isRead;
    private int count = 0 ;





    // Create View
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //--

        // findviewbyid

        mListView_no=(ListView)root.findViewById(R.id.list_notify) ;


        //init data
         title   = new String[]{"title 1","title 2",
                                 "title 3","title 4",
                                 "title 5","title 6",
                                 "title 7","title 8",
                                 "title 9","title 10"};

          desc   = new String[]{"des 1", "desc 2",
                                  "desc 3", "desc 4",
                                  "desc 5", "desc 6",
                                  "desc 7", "desc 8",
                                  "desc 9", "desc 10"};

          imgs   = new int[] {R.drawable.notification_icon,   R.drawable.notification_icon,
                                R.drawable.notification_icon, R.drawable.notification_icon,
                                R.drawable.notification_icon, R.drawable.notification_icon,
                                R.drawable.notification_icon, R.drawable.notification_icon,
                                R.drawable.notification_icon, R.drawable.notification_icon};

        isRead   =  new int[] {R.id.image_Status,R.id.image_Status,
                                R.id.image_Status,R.id.image_Status,
                                R.id.image_Status,R.id.image_Status,
                                R.id.image_Status,R.id.image_Status,
                                R.id.image_Status,R.id.image_Status};

        //--

        NotificationAdapter notificationAdapter = new NotificationAdapter(getContext(),R.layout.listview_notification,imgs,title,desc,isRead);
        mListView_no.setAdapter(notificationAdapter);

        mListView_no.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(getActivity(), DetailsActivity.class);
                   mIntent.putExtra("title_no",title[i]);
                   mIntent.putExtra("desc_no", desc [i]);
                   mIntent.putExtra("imgs_no", imgs [i]);
                   mIntent.putExtra("isRead_no", isRead [i]);

                   count = 8;
                   mIntent.putExtra("8",count);

                notificationAdapter.getView(i,view.findViewById(R.id.image_Status),mListView_no).setVisibility(View.GONE);


                startActivity(mIntent);

            }
        });



        //--


        //final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);

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