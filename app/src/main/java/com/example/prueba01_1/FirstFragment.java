package com.example.prueba01_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.prueba01_1.databinding.FragmentFirstBinding;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private EditText txt_name, txt_last_name, txt_phone;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_name = (EditText) binding.txtName;
        txt_last_name = (EditText) binding.txtLastName;
        txt_phone = (EditText) binding.txtPhone;

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewInfo();
            }
        });

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInput();
            }
        });

    }

    public void clearInput(){
        String name = txt_name.getText().toString();
        String last_name = txt_last_name.getText().toString();
        String phone = txt_phone.getText().toString();

        if( name != "" || last_name != "" || phone != "" ){
            txt_name.setText("");
            txt_last_name.setText("");
            txt_phone.setText("");
        }
    }

    public void viewInfo(){
        String name = txt_name.getText().toString();
        String last_name = txt_last_name.getText().toString();
        String phone = txt_phone.getText().toString();

        Toast.makeText(getActivity(),"El teléfono de:" + name + " " + last_name +  " es " + phone , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}