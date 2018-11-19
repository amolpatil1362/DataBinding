package com.test.kotlin.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.test.kotlin.R.id
import com.test.kotlin.R.layout
import com.test.kotlin.User
import com.test.kotlin.adapters.CustomAdapter.ViewHolder

/**
 * Created by amolpatil on 03/02/18.
 */
public class CustomAdapter(val user: ArrayList<User>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder?.txtName?.setText(user.get(position).getUserName())
        holder?.txtTitle?.setText(user.get(position).getUserId().toString())

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(
            layout.recycleritemview, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
       return user.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(id.txtName)
        val txtTitle = itemView.findViewById<TextView>(id.txtTitle)

    }

    fun testFunsction(param1:String):Int?{
        return 0
    }


}
