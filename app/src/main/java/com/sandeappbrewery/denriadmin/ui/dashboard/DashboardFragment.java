package com.sandeappbrewery.denriadmin.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.sandeappbrewery.denriadmin.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    Uri imgUri;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imgNewProd.setOnClickListener(view12 -> {
            openGallery();
        });
        binding.btnNewProduct.setOnClickListener(view1 -> {
            uploadNewProduct();
        });
    }

    private void uploadNewProduct() {

        if (binding.txtNewDesription.getText().toString().isEmpty()){

            Snackbar.make(getView(),"Fill in the description field",Snackbar.LENGTH_LONG).show();

        }else if (binding.txtNewPrice.getText().toString().isEmpty()){

            Snackbar.make(getView(),"Fill in the price field",Snackbar.LENGTH_LONG).show();

        }else if (binding.txtNewTitle.getText().toString().isEmpty()){

            Snackbar.make(getView(),"Fill in the title field",Snackbar.LENGTH_LONG).show();

        }else if (imgUri == null){

            Snackbar.make(getView(),"Please Choose an Image",Snackbar.LENGTH_LONG).show();

        }else{
            uploadData();
        }
    }

    private void uploadData() {
        Toast.makeText(getContext(), "Uploaded successfully", Toast.LENGTH_SHORT).show();
    }

    private void openGallery() {
        Intent imageIntent = new Intent(Intent.ACTION_PICK);
        imageIntent.setType("image/*");
        galleryUploadIntentLauncher.launch(imageIntent);
    }

    private final ActivityResultLauncher<Intent> galleryUploadIntentLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK)
                {
                    Intent data = result.getData();
                    if (data != null) {
                        imgUri = data.getData();
                        binding.imgNewProd.setImageURI(imgUri);
                    }
                }
                else {
                    Snackbar.make(getView(),"Cancelled ...",Snackbar.LENGTH_LONG).show();
                }
            }
    );

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}