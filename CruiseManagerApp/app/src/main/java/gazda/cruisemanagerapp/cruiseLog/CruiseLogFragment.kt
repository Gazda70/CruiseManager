package gazda.cruisemanagerapp.cruiseLog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.databinding.CruisesLogFragmentBinding

class CruiseLogFragment : Fragment(), ClickListener {

    private lateinit var binding: CruisesLogFragmentBinding

    private lateinit var adapterLogEntries: CruiseLogEntriesRecyclerViewAdapter

    companion object {
        fun newInstance() = CruiseLogFragment()
    }

    private lateinit var viewModel: CruiseLogViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.cruise_log_fragment, container, false)
        viewModel = ViewModelProvider(this).get(CruiseLogViewModel::class.java)
        adapterLogEntries = CruiseLogEntriesRecyclerViewAdapter(viewModel.getMyLogEntries(), this)
        binding.cruiseLogEntries.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.cruiseLogEntries.adapter = adapterLogEntries
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(CruiseLogViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onClicked(number: Int) {

    }

}