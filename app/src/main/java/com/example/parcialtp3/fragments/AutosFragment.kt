package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.CarsAdapter
import com.example.parcialtp3.apiServiceBuilder.APIServicesBuilder
import com.example.parcialtp3.domain.Car
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AutosFragment : Fragment() {
    lateinit var autosView : View
    lateinit var autosRecView : RecyclerView
    //lateinit var autosViewModel : AutosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        autosView = inflater.inflate(R.layout.fragment_autos, container, false)

        autosRecView = autosView.findViewById<RecyclerView>(R.id.carsRecycleView)
        autosRecView.setHasFixedSize(true)

        getCars()

        return autosView
    }

    override fun onStart() {
        super.onStart()
    }

    private fun getCars() {
        val service = APIServicesBuilder.create()

        service.getCarList().enqueue(object: Callback<List<Car>> {
            override fun onResponse(
                call: Call<List<Car>>,
                response: Response<List<Car>>
            ){
                println(response.body()!!)
                loadRecViewData(response.body() ?: emptyList())
            }
            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                println(t.message)
            }
        })
    }

    private fun loadRecViewData(list: List<Car>) {
        autosRecView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = CarsAdapter(list)
        }
    }

}