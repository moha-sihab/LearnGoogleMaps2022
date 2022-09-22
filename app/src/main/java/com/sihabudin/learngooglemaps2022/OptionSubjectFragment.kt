package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sihabudin.learngooglemaps2022.databinding.FragmentOptionSubjectBinding


class OptionSubjectFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentOptionSubjectBinding? = null
    private val binding get() = _binding!!
    private lateinit var setOnClickSubjectListener: SetOnClickSubjectListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOptionSubjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindingData() {
        val optionAdapter = OptionSubjectAdapter()
        optionAdapter.setData(subjectList())
        with(binding.rvOption) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = optionAdapter
        }
        optionAdapter.onItemClick = {
            setOnClickSubjectListener.onClick(it)
            dismiss()
        }
    }

    fun setOnClickSubjectListener(listener : SetOnClickSubjectListener){
        this.setOnClickSubjectListener = listener
    }

    private fun subjectList(): List<String> {
        val subject: MutableList<String> = mutableListOf()
        subject.add(MAP_STYLE)
        subject.add(MAP_TYPE)
        subject.add(MAP_BUILDING3D)
        subject.add(MAP_MAXMINZOOM)
        subject.add(MAP_UPDATE_CAMERA_POSITION)
        subject.add(MAP_BOUNDARIES)
        subject.add(MAP_RESTRICT_SCROLL)
        subject.add(MAP_ANIMATE_CAMERA)
        subject.add(MAP_SINGLE_LONG_CLICK)
        subject.add(MAP_OBJECT_MARKER)
        subject.add(MAP_MARKER_DRAGGING)
        subject.add(MAP_MARKER_CUSTOM)

        return subject
    }

    interface SetOnClickSubjectListener{
        fun onClick(subject : String)
    }

}