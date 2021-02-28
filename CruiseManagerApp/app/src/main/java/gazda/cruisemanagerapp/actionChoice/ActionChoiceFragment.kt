package gazda.cruisemanagerapp.actionChoice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gazda.cruisemanagerapp.R

class ActionChoiceFragment : Fragment() {

    companion object {
        fun newInstance() = ActionChoiceFragment()
    }

    private lateinit var viewModel: ActionChoiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.action_choice_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ActionChoiceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}