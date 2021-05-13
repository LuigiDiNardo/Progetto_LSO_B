package com.example.progetto_lso_b;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.osmdroid.views.MapView;

import java.net.Socket;

public class
MembriAsyncTask extends AsyncTask {
    private MapView map=null;
    Context context;
    private SocketClass sock;


    public MembriAsyncTask(MapView map, Context ctx){
        this.context=ctx;
        this.map=map;
    }

    public MembriAsyncTask(Context ctx){
        this.context=ctx;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        this.sock= SocketClass.getInstance();
        Log.d("YOU","siamo in doInBackground");
        sock.writeData("exit");
        Log.d("YOU","andata bene la scrittura");
        String result=sock.readData(String.class);
        Log.d("YOU","andata bene la lettura");
        return result;
    }


    protected void onPostExecute(String risposta) {
        super.onPostExecute(risposta);
        Toast.makeText(context,risposta,Toast.LENGTH_SHORT);
        this.sock=SocketClass.getInstance();
        this.sock.closeSocket();
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
