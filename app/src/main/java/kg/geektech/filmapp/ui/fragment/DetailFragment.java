package kg.geektech.filmapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import kg.geektech.filmapp.App;
import kg.geektech.filmapp.data.model.Film;
import kg.geektech.filmapp.databinding.FragmentDetailBinding;
import kg.geektech.filmapp.ui.DetailAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private DetailAdapter detailsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsAdapter = new DetailAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerFilmsDetail.setAdapter(detailsAdapter);
        String id = DetailFragmentArgs.fromBundle(getArguments()).getId();
        App.filmApi.getFilmDetail(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List responses = Collections.singletonList(response.body());
                    detailsAdapter.setList(responses);
                    Toast.makeText(requireActivity(), "Успешно", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity(), "Провалено", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                //add
            }
        });

    }









































}