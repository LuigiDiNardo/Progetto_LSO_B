package com.example.progetto_lso_b;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.osmdroid.views.MapView;

import java.net.Socket;
import java.net.SocketAddress;

public class MembriAsyncTask extends AsyncTask {
    private MapView map=null;
    private double latitude,longitude;
    Context context;
    private SocketClass sock;


    public MembriAsyncTask(MapView map, Context ctx){
        this.context=ctx;
        this.map=map;
    }

    public MembriAsyncTask(Context ctx,double latitude, double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.context=ctx;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        sock=SocketClass.getInstance();
        String result;
        Log.d("YOU","siamo in doInBackground");
        sock.writeData("92");
        result = sock.readData();
        return result;
    }


    protected void onPostExecute(String risposta) {
        super.onPostExecute(risposta);
        Toast.makeText(context,risposta,Toast.LENGTH_SHORT).show();
        sock.closeSocket();
        //effettua operazioni post async/restituisce il risultato di tale
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        //aggiorna il main thread
    }

    @Override
    protected void onPreExecute() {
        //carica le informazioni prima di eseguire l'async
    }
}
