package gazda.cruisemanagerapp.threeMainOptions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gazda.cruisemanagerapp.R

class ThreeMainOptionsAdvanced : Fragment() {

    companion object {
        fun newInstance() = ThreeMainOptionsAdvanced()
    }

    private lateinit var viewModel: ThreeMainOptionsAdvancedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.three_main_options_advanced_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThreeMainOptionsAdvancedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}