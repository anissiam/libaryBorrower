package geek.libaryborrower.anis.libaryborrower;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class ProfileBookActivity extends AppCompatActivity {
    private ImageView imgBookCover;
    private TextView tvType;
    private TextView tvTitle;
    private TextView tvBookAuthor;
    private TextView tvISBN;
    private TextView tvEdition;
    private TextView tvNoOfPage;
    private TextView tvPublisher;
    private TextView tvLinguisticEditor;
    private TextView tvCoverDesigner;
    private TextView tvCategory;
    private TextView tvLanguage;
    private TextView tvIsAvailable;
    private TextView tvDescription;
    private Context context;
    private FirebaseFirestore firestore ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_book);
        imgBookCover = (ImageView) findViewById(R.id.imgBookCover);
        tvType = (TextView) findViewById(R.id.tvType);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvBookAuthor = (TextView) findViewById(R.id.tvBookAuthor);
        tvISBN = (TextView) findViewById(R.id.tvISBN);
        tvEdition = (TextView) findViewById(R.id.tvEdition);
        tvNoOfPage = (TextView) findViewById(R.id.tvNoOfPage);
        tvPublisher = (TextView) findViewById(R.id.tvPublisher);
        tvLinguisticEditor = (TextView) findViewById(R.id.tvLinguisticEditor);
        tvCoverDesigner = (TextView) findViewById(R.id.tvCoverDesigner);
        tvCategory = (TextView) findViewById(R.id.tvCategory);
        tvLanguage = (TextView) findViewById(R.id.tvLanguage);
        tvIsAvailable = (TextView) findViewById(R.id.tvIsAvailable);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        firestore =  FirebaseFirestore.getInstance();
        fetchAllBookData();
    }

    private void fetchAllBookData() {
        firestore.collection("Books").whereEqualTo("isbn13","9789776376632")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                        for (DocumentSnapshot document : task.getResult()) {
                            String Title = document.getString("title");
                            tvTitle.setText(Title);

                            String cover = document.getString("cover");
                            Picasso.get().load(cover).into(imgBookCover);
                            //Glide.with(context).load(cover).into(imgBookCover);

                            String Description = document.getString("description");
                            tvDescription.setText(Description);
                            }
                        }else {
                            Toast.makeText(ProfileBookActivity.this, "Error : "+task.getException() , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


}
