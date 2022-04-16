package kg.geektech.filmapp.ui.fragment;

import kg.geektech.filmapp.App;
import kg.geektech.filmapp.Click;
import retrofit2.Call;
import retrofit2.Callback;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kg.geektech.filmapp.data.model.Film;
import kg.geektech.filmapp.databinding.FragmentFilmBinding;
import kg.geektech.filmapp.ui.Adapter;

import retrofit2.Callback;
import retrofit2.Response;


public class FilmFragment extends Fragment implements Click {

    private FragmentFilmBinding binding;
    private Adapter adapter;

    public FilmFragment (){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new Adapter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerFilms.setAdapter(adapter);
        adapter.setOnclick(this);
        App.filmApi.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(@NonNull Call<List<Film>> call, @NonNull Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setFilms(response.body());
                } else {

                }
            }
            @Override
            public void onFailure(@NonNull Call<List<Film>> call, Throwable t) {
            }
        });
           }

    @Override
    public void click(String id) {
        Navigation.findNavController(requireView()).navigate(FilmFragmentDirections.actionFilmFragmentToDetailFragment(id));
    }
}