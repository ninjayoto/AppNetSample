package app.com.ninja.android.appnet.control;

import app.com.ninja.android.appnet.model.DataItems;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Retrofit interface to retreive the data
 * */

public interface Api {


	String BASE_URL = "https://alpha-api.app.net/"; 


	@GET("stream/0/posts/stream/global")

	public Call<DataItems> listposts();


	class Factory{

		private static Api service;

		public static Api getInstance(){
			// a method to instantiate an instance of service if not instantiated

			if (service == null){

				Retrofit retrofit = new Retrofit.Builder()

				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(BASE_URL)
				.build();
				service = retrofit.create(Api.class);
				return service;
			}else {
				return service;
			}
		}
	}
}

