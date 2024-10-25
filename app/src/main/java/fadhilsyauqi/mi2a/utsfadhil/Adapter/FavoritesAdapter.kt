package fadhilsyauqi.mi2a.utsfadhil.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fadhilsyauqi.mi2a.utsfadhil.FavoritesPage
import fadhilsyauqi.mi2a.utsfadhil.Model.ModelFavorites
import fadhilsyauqi.mi2a.utsfadhil.R
import fadhilsyauqi.mi2a.utsfadhil.detail_order_page

class FavoritesAdapter(
    val itemList : ArrayList<ModelFavorites>,
    val getActivity : FavoritesPage
) : RecyclerView.Adapter<FavoritesAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var gambarMakanan : ImageView
        var namaMakanan : TextView
        var detailMakanan : TextView

        init {
            gambarMakanan = itemView.findViewById(R.id.gambarMakanan) as ImageView
            namaMakanan = itemView.findViewById(R.id.namaMakanan) as TextView
            detailMakanan = itemView.findViewById(R.id.detailMakanan) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_makanan, parent, false)

        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.gambarMakanan.setImageResource(itemList[position].gambarMakanan)
        holder.namaMakanan.setText(itemList[position].namaMakanan)
        holder.detailMakanan.setText(itemList[position].detailMakanan)

        holder.itemView.setOnClickListener() {
            val intent = Intent(getActivity, detail_order_page::class.java)
            intent.putExtra("gambarMakanan", itemList[position].gambarMakanan)
            intent.putExtra("namaMakanan", itemList[position].namaMakanan)

            getActivity.startActivity(intent)
        }
    }

}