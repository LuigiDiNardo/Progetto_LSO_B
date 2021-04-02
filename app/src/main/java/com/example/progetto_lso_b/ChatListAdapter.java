package com.example.progetto_lso_b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyViewHolder> {

    private String[] listaNomi, listaTesti;

    public ChatListAdapter(String[] nomi, String[] testi){
        this.listaNomi=nomi;
        this.listaTesti=testi;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //istanzia il layout creato per gestire tutti i list item
        View singleItemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_items,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder((singleItemLayout));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListAdapter.MyViewHolder holder, int position) {
        //mostra l'item nella lista nella sua corretta posizione
        holder.nome.setText((listaNomi[position]));
        holder.messaggio.setText((listaTesti[position]));

    }

    @Override //ritorna il numero degli item presenti nella list
    //P.S. verrà riaggiornata con gli eventuali tipi di dato da inserire nell'applicazione; si consideri tale codice come una demo
    public int getItemCount() {
        return listaNomi.length;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        //definisco tutti gli oggetti che devono essere mostrati con la recycler view
        TextView nome,messaggio;
        ImageView proPic;

        //inizializzo gli oggetti che verranno mostrati con la recycler view
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.chat_name_text);
            messaggio = itemView.findViewById(R.id.chat_text);
            proPic =itemView.findViewById(R.id.chat_profile_pic);

        }
    }
}
