package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parcialtp3.R
import com.example.parcialtp3.apiServiceBuilder.APIServicesBuilder
import com.example.parcialtp3.model.response.CarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuscarFragment : Fragment() {
    lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_buscar, container, false)

        getCars()
        return fragmentView
    }

    private fun getCars(){
        val service = APIServicesBuilder.create()

        service.getCarList().enqueue(object: Callback<CarResponse> {
            override fun onResponse(
                call: Call<CarResponse>,
                response: Response<CarResponse>
            ){
              println(response.body()!!.results)
            }
            override fun onFailure(call: Call<CarResponse>, t: Throwable) {
                println(t.message)
            }
        })

    }

}