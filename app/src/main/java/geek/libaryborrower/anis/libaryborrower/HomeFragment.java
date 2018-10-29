package geek.libaryborrower.anis.libaryborrower;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;


import adapter.HomeNewBookAdapter;
import model.Books;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView ;
    private ArrayList<Books> List_Books;
    private HomeNewBookAdapter homeNewBookAdapter ;
    private Books books;
    private FirebaseFirestore mFirestore;
    private Activity mActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFirestore = FirebaseFirestore.getInstance();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        List_Books = new ArrayList<>();
        homeNewBookAdapter = new HomeNewBookAdapter(container.getContext(), List_Books);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(homeNewBookAdapter);
        getBookData();
        return view;
    }
    public void getBookData(){
        //List_Books.clear();
        mFirestore.collection("Books").addSnapshotListener(getActivity(), new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                for (DocumentChange doc :documentSnapshots.getDocumentChanges()){
                    if(doc.getType()==DocumentChange.Type.ADDED){
                        String user_id = doc.getDocument().getId();
                        String cover_Image = doc.getDocument().getString("cover");
                        String title = doc.getDocument().getString("title");
                        String author = doc.getDocument().getString("author");
                        boolean available = doc.getDocument().getBoolean("available");
                        Date date_of_uplode =  doc.getDocument().getDate("date_of_uplode ");
                        //Log.d("TAGG",doc.getDocument().getDate("date_of_uplode ")+"");

                        books = doc.getDocument().toObject(Books.class);
                        books.setCover(cover_Image);
                        books.setTitle(title);
                        books.setAuthor(author);
                        books.setAvailable(available);
                        books.setDate_Created(date_of_uplode);
                        List_Books.add(books);
                        homeNewBookAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }
}
