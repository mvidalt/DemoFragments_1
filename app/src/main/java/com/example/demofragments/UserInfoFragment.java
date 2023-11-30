package com.example.demofragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserInfoFragment extends Fragment {
    private static final String ARG_USER_NAME = "user_name";

    public static UserInfoFragment newInstance(String userName) {
        UserInfoFragment fragment = new UserInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_NAME, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);

        TextView userNameTextView = view.findViewById(R.id.txtUserName);
        Bundle args = getArguments();
        if (args != null && args.containsKey(ARG_USER_NAME)) {
            userNameTextView.setText(args.getString(ARG_USER_NAME));
        }

        return view;
    }

    public void updateUserName(String newUserName) {
        View view = getView();
        if (view != null) {
            TextView userNameTextView = view.findViewById(R.id.txtUserName);
            if (userNameTextView != null) {
                userNameTextView.setText(newUserName);
            }
        }
    }
}
