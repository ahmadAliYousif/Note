package com.example.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note.interfaces.OnClickNote;
import com.example.note.model.NoteItems;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class RecycleViewItemsNote extends RecyclerView.Adapter<RecycleViewItemsNote.ViewHolderItmes> {
    List<NoteItems> itemsList;
    Context context;
    OnClickNote onClickNote;

    public RecycleViewItemsNote(List<NoteItems> itemsList, Context context, OnClickNote onClickNote) {
        this.itemsList = itemsList;
        this.context = context;
        this.onClickNote = onClickNote;
    }

    @NonNull
    @Override
    public ViewHolderItmes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.note_items, null, false);
        ViewHolderItmes viewHolderItmes = new ViewHolderItmes(view);

        return viewHolderItmes;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItmes holder, int position) {
        String body = itemsList.get(position).getBodyNote();
        if (body.length() > 15) {
            body = body.substring(0, 13) + " ...";

        }
        holder.tv_title.setText(itemsList.get(position).getTitleNote() + "");
        holder.tv_body.setText(body);
        holder.tv_date.setText(itemsList.get(position).getDateNote() + "");
        holder.noteItems = itemsList.get(position);

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class ViewHolderItmes extends RecyclerView.ViewHolder {
        MaterialTextView tv_id;
        MaterialTextView tv_title;
        MaterialTextView tv_body;
        MaterialTextView tv_date;
        NoteItems noteItems;

        public ViewHolderItmes(@NonNull View itemView) {
            super(itemView);

//            tv_id = itemView.findViewById(R.id.note_items_id);
            tv_title = itemView.findViewById(R.id.note_items_title);
            tv_body = itemView.findViewById(R.id.note_items_note);
            tv_date = itemView.findViewById(R.id.note_items_date);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickNote.onClick(noteItems);


                }
            });

        }


    }
}
