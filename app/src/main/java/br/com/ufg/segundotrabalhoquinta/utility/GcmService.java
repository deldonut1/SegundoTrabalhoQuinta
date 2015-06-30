package br.com.ufg.segundotrabalhoquinta.utility;


import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.util.concurrent.ExecutionException;

/**
 * Created by Ayrton on 28/06/2015.
 */
public class GcmService extends IntentService {

    public static String token = "Vazio";
    private final IBinder mBinder = new MyBinder();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public GcmService() {
        super("GcmService");
    }



    /*public static String getToken(Context context)
    {


    }*/

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        InstanceID instanceID = InstanceID.getInstance(getApplicationContext());

        String id = instanceID.getId();

        try
        {
            token = instanceID.getToken(id, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
        }
        catch (Exception e)
        {
            token = "Erro! " + e ;
        }
        finally {

        }
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return mBinder;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
int x = 0;
    }

    public class MyBinder extends Binder {
        GcmService getService() {
            return GcmService .this;
        }
    }

    public String getRetValue() {
        return token;
    }



}
