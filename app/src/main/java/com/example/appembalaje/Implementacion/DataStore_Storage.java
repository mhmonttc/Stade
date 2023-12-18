package com.example.appembalaje.Implementacion;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class DataStore_Storage {

    Uri imageUri;
    StorageReference storageReference;
    ProgressDialog progressDialog;

    public void SubirImagen(String path, Uri uriImage, Context context){
        StorageReference reference = storageReference.child(path+ UUID.randomUUID().toString());
        reference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        reference.getDownloadUrl();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();

                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        progressDialog = ProgressDialog.show(context,"Subiendo datos","Espera unos momentos mientras subimos los datos");
                        progressDialog.setMax(Math.toIntExact(snapshot.getTotalByteCount()));
                        progressDialog.setProgress(Math.toIntExact(snapshot.getBytesTransferred()));
                    }
                });


    }





}
