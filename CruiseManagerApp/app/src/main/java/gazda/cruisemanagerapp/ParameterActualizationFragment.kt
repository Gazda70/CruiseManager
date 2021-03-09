package gazda.cruisemanagerapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ParameterActualizationFragment : Fragment() {

    companion object {
        fun newInstance() = ParameterActualizationFragment()
    }

    private lateinit var viewModel: ParameterActualizationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.parameter_actualization_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ParameterActualizationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}