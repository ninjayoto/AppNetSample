package app.com.ninja.android.appnet;
import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import app.com.ninja.android.appnet.control.Adapter;
import app.com.ninja.android.appnet.control.Api;
import app.com.ninja.android.appnet.model.DataItems;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    ArrayList<DataItems> itemsList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout swipeLayout;
//    static final String RETURN_DATA = "string_value";
//
//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        savedInstanceState.putParcelableArrayList(RETURN_DATA, itemsList);
//        super.onSaveInstanceState(savedInstanceState);
//    }

    @Override
    protected void onResume(){
        super.onResume();
        // Android N runtime internet permission
//        getPermissionToUseInternet();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
//        Realm realm = Realm.getInstance(realmConfig);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_list);

        mRecyclerView.setHasFixedSize(true);

        // linear layout manager
        mLayoutManager = new LinearLayoutManager(this);

        // specifying adapter

        mRecyclerView.setAdapter(mAdapter);


        //background service
//        launchService();

        //retrieve data from Api
        mapJSON();

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeLayout.setOnRefreshListener(this);
    }


//swipe to refresh
    @Override public void onRefresh() {
        mapJSON();
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                swipeLayout.setRefreshing(false);
            }
        }, 3000);
    }

    // parsing JSON
    public void mapJSON() {
        getPermissionToUseInternet();

        Api.Factory.getInstance().listposts().enqueue(new Callback<DataItems>() {
            //Call(request to the server) and a response
            public void onResponse(Call<DataItems> call,
                                   Response<DataItems> response) {

                DataItems res = response.body();
                itemsList = new ArrayList<>(Arrays.asList(res));

                // use a linear layout manager
                mRecyclerView.setLayoutManager(mLayoutManager);

                mAdapter = new Adapter(getApplicationContext(),itemsList);

                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            public void onFailure(Call<DataItems> call, Throwable t) {

            // snackbar message to the user to check connection if data retrieval fails
               Snackbar.make(mRecyclerView, getString(R.string.connection_snackbar), Snackbar.LENGTH_LONG).show();

            }
        });

    }

    // Checking for runtime permissions in Android N and above

    // Identifier for the permission request
    private static final int INTERNET_PERMISSIONS_REQUEST = 1;

    @TargetApi(Build.VERSION_CODES.M)
    public void getPermissionToUseInternet() {


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {


            requestPermissions(new String[]{Manifest.permission.INTERNET},
                    INTERNET_PERMISSIONS_REQUEST);
        }
    }

    // Callback with the request from calling requestPermissions(...)
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults){
            // Make sure it's our original Internet request
            if (requestCode == INTERNET_PERMISSIONS_REQUEST) {
                if (grantResults.length == 1 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Internet permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Internet permission denied", Toast.LENGTH_SHORT).show();
                }
            } else {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
//    public void launchService() {
//        Intent i = new Intent(this, refreshService.class);
//        i.putExtra("", "");
//        // Starting the service
//        startService(i);
//
//    }



