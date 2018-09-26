package geek.libaryborrower.anis.libaryborrower;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class BorrwerDataActivity extends AppCompatActivity {
    private CircleImageView imageBorrower;
    private EditText edtName;
    private EditText edtPhone;
    private EditText edtEmail;
    private EditText edtBirthDate;
    private Button btnSave;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mfirestore;
    private StorageReference mstorage;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrwer_data);

        imageBorrower = (CircleImageView)findViewById(R.id.imageBorrower);
        edtName = (EditText)findViewById(R.id.edtName);
        edtPhone = (EditText)findViewById(R.id.edtPhone);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtBirthDate = (EditText)findViewById(R.id.edtBirthDate);
        btnSave= (Button)findViewById(R.id.btnSave);

        mAuth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();

        mstorage= FirebaseStorage.getInstance().getReference().child("images");
        if (FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl()!=null) {
            String url = FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString();
            Glide.with(BorrwerDataActivity.this).load(url).into(imageBorrower);
        }

        /*if(imageBorrower.getDrawable() == getResources().getDrawable( R.drawable.profileicon)){
            imageBorrower.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(BorrwerDataActivity.this, "hi", Toast.LENGTH_SHORT).show();
                }
            });
        }*/
        final String user_id = mAuth.getCurrentUser().getUid();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String phone = edtPhone.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                ///--change BirthDate to Date member
                String birthDate = edtBirthDate.getText().toString().trim();

                //String token_id = FirebaseInstanceId.getInstance().getToken();
                Map<String, Object> userMap = new HashMap<>();
                userMap.put("name", name);
                userMap.put("phone", phone);
                userMap.put("email", email);
                userMap.put("birthDate", birthDate);
                //userMap.put("email", email);
                mfirestore.collection("Users").document(user_id)
                        .set(userMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(BorrwerDataActivity.this, "success", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BorrwerDataActivity.this, "Error" , Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

}
