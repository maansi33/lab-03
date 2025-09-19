package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private TextView showCountTextView;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);

        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);

        return fragmentFirstLayout;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Navigate to SecondFragment with Safe Args
        view.findViewById(R.id.random_button).setOnClickListener(v -> {
            int currentCount = Integer.parseInt(showCountTextView.getText().toString());

            FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                    FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);

            NavHostFragment.findNavController(FirstFragment.this).navigate(action);
        });

        // Show a Toast
        view.findViewById(R.id.toast_button).setOnClickListener(v -> {
            Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
            myToast.show();
        });

        // Increment the counter
        view.findViewById(R.id.count_button).setOnClickListener(this::countMe);
    }

    private void countMe(View view) {
        // Get the value of the text view
        String countString = showCountTextView.getText().toString();

        // Convert value to a number and increment it
        int count = Integer.parseInt(countString);
        count++;

        // Display the new value in the text view
        showCountTextView.setText(String.valueOf(count));
    }
}
