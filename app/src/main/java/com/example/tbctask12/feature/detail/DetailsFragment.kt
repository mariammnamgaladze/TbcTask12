package com.example.tbctask12.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tbctask12.databinding.FragmentDetailsBinding
import com.example.tbctask12.feature.data.PictureModel

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private lateinit var imageModel: PictureModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageModel = it.getParcelable("data")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() = binding.apply {
        imageView.setImageResource(imageModel.imageRes)
        descriptionTV.text = imageModel.imageDescription
        headingTV.text = imageModel.imageTitle
    }

    companion object {
        @JvmStatic
        fun newInstance(model: PictureModel) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("data", model)
                }
            }
    }
}