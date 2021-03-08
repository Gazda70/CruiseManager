package gazda.cruisemanagerapp.createCruise

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.databinding.CreateCruiseFragmentBinding
import gazda.cruisemanagerapp.databinding.GreetingScreenBinding

class CreateCruiseFragment : Fragment() {

    private lateinit var binding: CreateCruiseFragmentBinding

    companion object {
        fun newInstance() = CreateCruiseFragment()
    }

    private lateinit var viewModel: CreateCruiseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.create_cruise_fragment, container, false)
        binding.continueCruiseCreationButton.setOnClickListener {
      //      binding.root.findNavController().navigate(R.id)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateCruiseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}