package app.com.ninja.android.appnet;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class refreshService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String GET_NEW_ITEMS = "app.com.ninja.android.appnet.action.REFRESH";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "app.com.ninja.android.appnet.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "app.com.ninja.android.appnet.extra.PARAM2";

    public refreshService() {
        super("refreshService");
    }

    /**
     * Starts this service to perform action  with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionRefresh(Context context, String param1, String param2) {
        Intent intent = new Intent(context, refreshService.class);
        intent.setAction(GET_NEW_ITEMS);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();

                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
//                handleActionRefresh(param1, param2);

        }
    }

    /**
     * Handle action refresh in the provided background thread with the provided
     * parameters.
     */
    private void handleActionRefresh(String param1, String param2) {
//        FreshData fresh = new FreshData();
//        fresh.refreshData();
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
