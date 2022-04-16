package kg.geektech.filmapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.filmapp.Click;
import kg.geektech.filmapp.data.model.Film;
import kg.geektech.filmapp.databinding.ItemFilmsBinding;
import okhttp3.ResponseBody;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderFilm> {
    private List<Film> films = new ArrayList<>();
    private Click click;

    public void setOnclick(Click onclick) {
        this.click = onclick;
    }

    @NonNull
    @Override
    public ViewHolderFilm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmsBinding binding = ItemFilmsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolderFilm(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFilm holder, int position) {
    holder.bind(films.get(position));
    }



    @Override
    public int getItemCount() {
        return films.size();
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }


    class ViewHolderFilm extends RecyclerView.ViewHolder{
    private ItemFilmsBinding binding;
        public ViewHolderFilm(@NonNull ItemFilmsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Film film) {initListener(film);
            binding.tvDescription.setText(film.getDescription());
            binding.tvTitle.setText(film.getTitle());
        }

        private void initListener(Film film) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click.click(film.getId());
                }
            });
        }
    }
}

