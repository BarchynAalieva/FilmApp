package kg.geektech.filmapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.filmapp.data.model.Film;
import kg.geektech.filmapp.databinding.ItemFilmsDetailBinding;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.myViewHolder> {

    private List<Film> list = new ArrayList<>();


    public void setList(List<Film> list) {//Я подключился)
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemFilmsDetailBinding binding = ItemFilmsDetailBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        private ItemFilmsDetailBinding binding;

        public myViewHolder(@NonNull ItemFilmsDetailBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }

        public void bind(Film film) {
            binding.tvDescription.setText(film.getDescription());
            binding.tvTitle.setText(film.getTitle());
            binding.director.setText(film.getDirector());
            binding.producer.setText(film.getProducer());
            binding.originalTitle.setText(film.getOriginalTitle());
            binding.releaseData.setText(film.getReleaseDate());
            Glide.with(binding.getRoot()).load(film.getImage()).into(binding.imageBanner);
        }
    }

}
