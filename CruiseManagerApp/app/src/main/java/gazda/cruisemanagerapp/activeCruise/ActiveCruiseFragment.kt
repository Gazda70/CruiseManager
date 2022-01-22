package gazda.cruisemanagerapp.activeCruise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.databinding.ActiveCruiseFragmentBinding

class ActiveCruiseFragment : Fragment() {

    private lateinit var binding: ActiveCruiseFragmentBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_active_cruise, container, false)
        binding.cruiseLogImage.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_activeCruiseFragment_to_cruiseLogFragment)
        }
        return binding.root
    }
}