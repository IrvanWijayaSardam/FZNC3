package com.example.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challengechaptertiga.databinding.FragmentDetailBinding


class FragmentDetail : Fragment() {
    private var _binding : FragmentDetailBinding?                           = null
    private val binding get()                                                = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
    }

    private fun getArgs() {
        var nama = requireArguments().getString("nama")
        var harga = requireArguments().getString("harga")

        binding.tvNama.setText(nama)
        binding.tvHarga.setText(harga)
    }
}