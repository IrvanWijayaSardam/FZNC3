package com.example.challengechaptertiga


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    private var _binding : FragmentHomeBinding?                         = null
    private val binding get()                                                   = _binding!!
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    private var isGridView = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = arrayListOf(
            ListData(R.drawable.ayam, "Ayam Bakar", "20.0000",),
            ListData(R.drawable.ayamgoreng, "Ayam Goreng", "25.0000",),
            ListData(R.drawable.ayamspicy, "Ayam Spicy", "30.000",),
            ListData(R.drawable.dimsum, "Dim Sum", "30.0000",),
            ListData(R.drawable.pizza, "Pizza", "80.0000",),
            ListData(R.drawable.mie1, "Mie ", "20.0000",),
            ListData(R.drawable.salmonsusi, "Salmon Sushi", "20.0000",),
            ListData(R.drawable.spaghetti, "Spaghetti", "40.0000",),
            ListData(R.drawable.ikanbakar3, "Ikan Bakar ","20.0000"),
            ListData(R.drawable.snack, "French fries", "15.0000",),
            ListData(R.drawable.minum2, "Strawberry Milk", "25.0000",),
        )

        var adapterHome = AdapterHome(list)
        var adapterGrid = AdapterGrid(list)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvListMenu)
        var layoutmanager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager =layoutmanager  // deffault recycler view list
        recyclerView.adapter = adapterHome
        var layoutmanagergrid = GridLayoutManager(context, 2)

        val btnswitchlist = view.findViewById<ImageButton>(R.id.btn_switch)

        var isGridLayout = false

        btnswitchlist.setOnClickListener {
            isGridLayout = !isGridLayout
            if (isGridLayout) {
                btnswitchlist.setImageResource(R.drawable.baseline_grid_view_24)
                recyclerView.layoutManager = layoutmanagergrid
                recyclerView.adapter = adapterGrid
            } else {
                btnswitchlist.setImageResource(R.drawable.list)
                recyclerView.layoutManager = layoutmanager
                recyclerView.adapter = adapterHome
            }
        }

        adapterHome.setOnItemClickListener(object: AdapterHome.onItemClickListener{
            override fun onItemClick(nama: String, harga: String) {
                val bund = Bundle()
                bund.putString("nama",nama)
                bund.putString("harga",harga)
                Navigation.findNavController(binding.root).navigate(R.id.action_fragmentHome_to_fragmentDetail,bund)
            }
        })
    }
}


