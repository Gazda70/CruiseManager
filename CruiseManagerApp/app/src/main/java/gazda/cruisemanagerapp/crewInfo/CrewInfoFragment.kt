package gazda.cruisemanagerapp.crewInfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gazda.cruisemanagerapp.R

class CrewInfoFragment : Fragment() {

    companion object {
        fun newInstance() = CrewInfoFragment()
    }

    private lateinit var viewModel: CrewInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.crew_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CrewInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}