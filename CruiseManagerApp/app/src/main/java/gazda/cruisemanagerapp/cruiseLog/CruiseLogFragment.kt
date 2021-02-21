package gazda.cruisemanagerapp.cruiseLog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gazda.cruisemanagerapp.R

class CruiseLogFragment : Fragment() {

    companion object {
        fun newInstance() = CruiseLogFragment()
    }

    private lateinit var viewModel: CruiseLogViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.cruise_log_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CruiseLogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}