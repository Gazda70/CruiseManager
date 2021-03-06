package gazda.cruisemanagerapp.greetingScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.cruisesOverwiev.cruisesOverview.CruisesOverviewViewModel
import gazda.cruisemanagerapp.databinding.CruisesOverviewFragmentBinding
import gazda.cruisemanagerapp.databinding.GreetingScreenBinding

class GreetingScreen : Fragment() {

    private lateinit var binding: GreetingScreenBinding
    companion object {
        fun newInstance() =
            GreetingScreen()
    }

    private lateinit var viewModel: GreetingScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.greeting_screen_fragment, container, false)

        binding.addCruiseButton.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_greetingScreen_to_actionChoiceFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GreetingScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}