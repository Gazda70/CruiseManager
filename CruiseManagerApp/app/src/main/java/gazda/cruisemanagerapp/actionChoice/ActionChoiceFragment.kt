package gazda.cruisemanagerapp.actionChoice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.databinding.ActionChoiceFragmentBinding
import gazda.cruisemanagerapp.databinding.GreetingScreenBinding

class ActionChoiceFragment : Fragment() {

    private lateinit var binding: ActionChoiceFragmentBinding

    companion object {
        fun newInstance() = ActionChoiceFragment()
    }

    private lateinit var viewModel: ActionChoiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.action_choice_fragment, container, false)

        binding.createCruiseButton.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_actionChoiceFragment_to_createCruiseFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ActionChoiceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}