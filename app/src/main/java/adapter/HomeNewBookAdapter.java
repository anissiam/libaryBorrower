package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import geek.libaryborrower.anis.libaryborrower.BottomNavigationActivity;
import geek.libaryborrower.anis.libaryborrower.ProfileBookActivity;
import geek.libaryborrower.anis.libaryborrower.R;
import geek.libaryborrower.anis.libaryborrower.SplashActivity;
import model.Books;

public class HomeNewBookAdapter extends RecyclerView.Adapter<HomeNewBookAdapter.ViewHolder> {
    Context context;
    ArrayList<Books> List_Books;

    public HomeNewBookAdapter(Context context, ArrayList<Books> list_Books) {
        this.context = context;
        List_Books = list_Books;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_home, parent, false);
        ViewHolder holder = new ViewHolder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeNewBookAdapter.ViewHolder viewHolder, int i) {
        final Books item = List_Books.get(i);
       // viewHolder.imgBookCover.setImageDrawable(item.setCover());
        viewHolder.tvBookTitle.setText(item.getTitle());
        viewHolder.tvBookAuther.setText(item.getAuthor());

        Date Date_created = item.getDate_Created();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM / d / yyyy");
        String date = dateFormat.format(Date_created);
        viewHolder.tvDateOfUpLode.setText(date);

        ImageView userImageView = viewHolder.imgBookCover;
        Glide.with(context).load(List_Books.get(i).getCover()).into(userImageView);

        //viewHolder.tvIsAvailable.setText(item.getAvailable());
        if (item.getAvailable()==true) {

            viewHolder.tvIsAvailable.setText("Available");
            viewHolder.tvIsAvailable.setBackgroundResource(R.color.available);
        } else {
            viewHolder.tvIsAvailable.setText("Not available");
            viewHolder.tvIsAvailable.setBackgroundResource(R.color.notAvailable);
        }

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileBookActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return List_Books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgBookCover;
        private TextView tvBookTitle;
        private TextView tvBookAuther;
        private TextView tvDateOfUpLode;
        private TextView tvIsAvailable;
        private ImageView icon_like;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBookCover = (ImageView) itemView.findViewById(R.id.imgBookCover);
            tvBookTitle = (TextView) itemView.findViewById(R.id.tvBookTitle);
            tvBookAuther = (TextView) itemView.findViewById(R.id.tvBookAuther);
            tvDateOfUpLode = (TextView)itemView.findViewById(R.id.tvDateOfUpLode);
            tvIsAvailable =  (TextView)itemView.findViewById(R.id.tvIsAvailable);
            icon_like =  (ImageView) itemView.findViewById(R.id.icon_like);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}




