package com.hafidh.covid19.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafidh.covid19.R
import com.hafidh.covid19.model.ProvinceResponse
import kotlinx.android.synthetic.main.item_province.view.*


class ProvinceAdapter(private var list: ArrayList<ProvinceResponse>): RecyclerView.Adapter<ProvinceAdapter.ProvinceView>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceView {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_province,parent,false)
        return ProvinceView(View)
    }

    override fun onBindViewHolder(holder: ProvinceView, position: Int) {
        return holder.bind(list[position])
    }
    override fun getItemCount(): Int {
       return list.size
    }
    inner class ProvinceView(ItemView: View): RecyclerView.ViewHolder(ItemView){
        fun bind(province : ProvinceResponse){
            with(itemView){
                    tvName.text = province.attributes.Province
                    tvPositive.text = province.attributes.Positive.toString()
                    tvRecover.text = province.attributes.Recovery.toString()
                    tvDeath.text = province.attributes.Death.toString()
            }
        }
    }

}