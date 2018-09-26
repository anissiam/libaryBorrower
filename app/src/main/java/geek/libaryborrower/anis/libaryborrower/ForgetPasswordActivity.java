package geek.libaryborrower.anis.libaryborrower;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {
    private EditText edtEmail;
    private Button btnForget;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnForget = (Button) findViewById(R.id.btnForget);
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();

            }
        });
    }

    public void reset() {
        String Email = edtEmail.getText().toString().trim();
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(this, "Enter ypur Ema", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Sending to your Email...");
        progressDialog.show();
        auth.sendPasswordResetEmail(Email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            Toast.makeText(ForgetPasswordActivity.this, "Check your Email", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(ForgetPasswordActivity.this, "Error :" + task.getException(), Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });

    }
}
