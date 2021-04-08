package com.example.progetto_lso_b;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ChatFragment extends Fragment {

    String[] nomi = {"paolo","ciccia","banana81","N-ger"};
    String[] ultimiMessagi = {"ok","ho la leucemia","oooga negro","fabio grosso 2006"};
    RecyclerView recyclerView;

    public ChatFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        recyclerView=(RecyclerView) view.findViewById(R.id.recview_chat);
        ChatListAdapter chatListAdapter = new ChatListAdapter(nomi,ultimiMessagi);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);

        //collegamento alla recyclerView
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(chatListAdapter);
        return view;
    }
}
