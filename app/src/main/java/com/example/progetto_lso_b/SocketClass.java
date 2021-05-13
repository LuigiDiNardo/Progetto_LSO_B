package com.example.progetto_lso_b;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClass { //singleton per la socket
    private static Socket sock=null;
    private static SocketClass socket;
    private static DataOutputStream dataOutputStream=null;
    private static DataInputStream dataInputStream=null;


    private SocketClass(){}
    public static SocketClass getInstance() {
        if (sock == null) {
            try {
                sock = new Socket("51.144.166.40" , 3557);
                Log.d("SOCKET","Riuscita la connessione!");
            } catch (IOException e) {
                Log.e("SOCKET","Errore stabilimento connessione con il server!");
            }
        }
        return socket;
    }

    public static void writeData(String value){
        try {
            dataOutputStream=new DataOutputStream(sock.getOutputStream());
            dataOutputStream.writeBytes(value);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("DATAOUTPUTSTREAM","Impossibile ricavare l'outputstream dalla socket!");
        }
    }

    public static String readData(Class<?> type){
        String value;
        try {
            dataInputStream=new DataInputStream(sock.getInputStream());
            if(type == int.class){
                value = String.valueOf(dataInputStream.readInt());
            }
            else if(type == String.class){
                byte[] data = new byte[256];
                dataInputStream.read(data);
                value=String.valueOf(data);

            }
            else if(type == Double.class){
                value = String.valueOf(dataInputStream.readDouble());
            }
            else throw new IllegalStateException();
            return value;
        } catch (IOException e ) {
            e.printStackTrace();
            Log.e("DATAINPUTSTREAM","Impossibile ricavare l'inputstream dalla socket!");
            return null;
        } catch(IllegalStateException e){
            e.printStackTrace();
            Log.e("DATAINPUTSTREAM","Tipo non riconosciuto!");
            return null;
        }
    }

    public static void closeSocket(){
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}