package com.example.studentregapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.studentregapp.R;
import com.example.studentregapp.model.Student;

import java.util.List;

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.ViewHolder> {

    private List<Student> students;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public StudentRecyclerAdapter(Context context, List<Student> students) {
        this.mInflater = LayoutInflater.from(context);
        this.students = students;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.student_card, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.tvRollNo.setText(""+student.getRollNo());
        holder.tvName.setText(student.getName());
        holder.tvEmail.setText(student.getEmail());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return students.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvRollNo;
        TextView tvName;
        TextView tvEmail;

        ViewHolder(View itemView) {
            super(itemView);
            tvRollNo = itemView.findViewById(R.id.tv_roll_no_SC);
            tvName = itemView.findViewById(R.id.tv_name_SC);
            tvEmail = itemView.findViewById(R.id.tv_email_SC);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Student getItem(int id) {
        return students.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}