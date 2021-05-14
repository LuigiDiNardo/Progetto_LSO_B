package com.example.progetto_lso_b;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketClass { //singleton per la socket
    private static Socket sock;
    private static SocketClass socket;
    private static final SocketAddress address= new InetSocketAddress("51.144.166.40", 3557);


    private SocketClass() {
    }

    public static SocketClass getInstance() {
        if (sock == null) {
            try {
                sock = new Socket("51.144.166.40", 3557);
                Log.d("SOCKET", "Riuscita la connessione!");
            } catch (IOException e) {
                Log.e("SOCKET", "Errore stabilimento connessione con il server!");
            }
        }
        return socket;
    }

    public static void writeData(String value) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(sock.getOutputStream());
            dataOutputStream.writeBytes(value);
            if(!sock.isConnected())
                sock.connect(address);
            sock.shutdownOutput();
            Log.d("YOUMAN", "andata bene la scrittura");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("DATAOUTPUTSTREAM", "Impossibile ricavare l'outputstream dalla socket!");
        }
    }

    public static String readData() {
        String value;
        byte[] stringa = new byte[256];
        try {
            DataInputStream dataInputStream = new DataInputStream(sock.getInputStream());
            dataInputStream.read(stringa);
            value = new String(stringa);
            value = value.replaceAll("\u0000", "");
            Log.d("YOUMAN", "lettura andata a buon fine: "+value);
            return value;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeSocket(){
        try {
            sock.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}