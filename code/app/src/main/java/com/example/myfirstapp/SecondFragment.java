package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.myfirstapp.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private final SecondFragmentArgs args = null;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int count = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();

        // Format and set the heading text
        String countText = getString(R.string.random_heading, count);
        TextView headerView = view.getRootView().findViewById(R.id.textview_header);
        headerView.setText(countText);

        // Generate random number
        Random random = new Random();
        int randomNumber = 0;
        if (count > 0) {
            randomNumber = random.nextInt(count + 1);
        }

        // Show random number
        TextView randomView = view.getRootView().findViewById(R.id.textview_random);
        randomView.setText(Integer.toString(randomNumber));

        // Existing button click
        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
