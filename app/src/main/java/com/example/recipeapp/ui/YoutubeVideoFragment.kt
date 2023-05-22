package com.example.recipeapp.ui

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.recipeapp.databinding.FragmentYoutubePlayerBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class YoutubeVideoFragment : Fragment() {

    private var _binding: FragmentYoutubePlayerBinding? = null
    private val binding get() = _binding!!

    private var videoId : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentYoutubePlayerBinding.inflate(inflater)
         videoId = YoutubeVideoFragmentArgs.fromBundle(requireArguments()).youtubeLink

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val youTubePlayerView: YouTubePlayerView = binding.youtubePlayerView
        viewLifecycleOwner.lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {

                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}