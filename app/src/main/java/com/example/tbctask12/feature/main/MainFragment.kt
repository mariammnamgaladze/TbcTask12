package com.example.tbctask12.feature.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tbctask12.R
import com.example.tbctask12.databinding.FragmentMainBinding
import com.example.tbctask12.feature.data.pictureList
import com.example.tbctask12.feature.detail.DetailsFragment

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val pictureAdapter = PictureAdapter(pictureList.toMutableList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        onClickListener()
    }

    private fun initUi() {
        setUpRecycler()

        binding.editTextTextPersonName.doOnTextChanged { text, start, before, count ->
            if (count == 0)
                pictureAdapter.updateList(pictureList)

            if (count > 2) {
                val newList = pictureList.filter {
                    val inputeTxt = text.toString().lowercase()
                    val animalType = it.Type.animalType.lowercase()
                    animalType.contains(inputeTxt)
                }
                pictureAdapter.updateList(newList)
            }
        }
    }

    private fun onClickListener() {
        pictureAdapter.onItemClickListener = {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.container, DetailsFragment.newInstance(it))
                .addToBackStack(null)
                .commit()
        }
    }

    private fun setUpRecycler() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = pictureAdapter
        }
    }


}