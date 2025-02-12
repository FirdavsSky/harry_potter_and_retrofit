package com.example.harry_potter_and_retrofit.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.harry_potter_and_retrofit.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

private const val TAG = "MainFragment"

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels{
        MainViewModelFactory()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.character.collect { character ->
                Log.d(TAG, character.toString())
                binding.tvName.text = character.name
                binding.tvHouse.text = character.hogwartsHouse
                binding.imageCharacter.load(character.imageUrl)
            }
        }

        binding.btnRandomCharacter.setOnClickListener {

            viewModel.randomCharacter()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}