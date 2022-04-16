package kg.geektech.filmapp;

import android.app.Application;

import kg.geektech.filmapp.data.remote.Api;
import kg.geektech.filmapp.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static Api filmApi;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        filmApi = retrofitClient.createAPi();
    }
}
