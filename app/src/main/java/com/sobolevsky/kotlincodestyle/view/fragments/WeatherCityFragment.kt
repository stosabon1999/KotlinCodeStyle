package com.sobolevsky.kotlincodestyle.view.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sobolevsky.kotlincodestyle.R
import com.sobolevsky.kotlincodestyle.di.Injectable
import com.sobolevsky.kotlincodestyle.view.adapters.WeatherAdapter
import com.sobolevsky.kotlincodestyle.view.factories.WeatherViewHolderFactoryImpl
import com.sobolevsky.kotlincodestyle.view.viewmodels.WeatherCityViewModel
import javax.inject.Inject

class WeatherCityFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var weatherAdapter: WeatherAdapter

    private val viewModel: WeatherCityViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        progressBar = view.findViewById(R.id.progress_bar)
        weatherAdapter = WeatherAdapter(WeatherViewHolderFactoryImpl())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = weatherAdapter
        }
        viewModel.observeChanges()
        viewModel.loadWeather()
    }

    private fun WeatherCityViewModel.observeChanges() {
        weatherData.observe(viewLifecycleOwner, {
            weatherAdapter.submitList(it)
        })
        isLoading.observe(viewLifecycleOwner, {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
        serviceUnavailable.observe(viewLifecycleOwner, {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle(R.string.service_unavailable)
            builder.setMessage(R.string.try_later)
            builder.setPositiveButton(android.R.string.yes) { dialog, which -> }
            builder.show()
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = WeatherCityFragment()
    }
}