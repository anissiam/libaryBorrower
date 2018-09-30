package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import model.Books;

public class HomeNewBookAdapter extends RecyclerView.Adapter<HomeNewBookAdapter.HomeNewBookHolder> {
    Context context;
    ArrayList<Books> List_Books;

    public HomeNewBookAdapter(Context context, ArrayList<Books> list_Books) {
        this.context = context;
        List_Books = list_Books;
    }

    @NonNull
    @Override
    public HomeNewBookHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeNewBookHolder homeNewBookHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HomeNewBookHolder extends RecyclerView.ViewHolder {

        public HomeNewBookHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
