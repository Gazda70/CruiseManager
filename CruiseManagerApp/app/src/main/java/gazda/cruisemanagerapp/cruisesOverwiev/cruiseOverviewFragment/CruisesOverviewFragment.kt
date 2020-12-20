package gazda.cruisemanagerapp.cruisesOverwiev.cruiseOverviewFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.databinding.CruisesOverviewFragmentBinding


class CruisesOverviewFragment : Fragment() {

    private lateinit var viewModel: CruisesOverviewViewModel

    private lateinit var binding:CruisesOverviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // get the DataBindingClass
        binding = DataBindingUtil.inflate(inflater, R.layout.cruises_overwiev_fragment, container, false)

        // get the ViewModel.
        viewModel = ViewModelProvider(this).get(CruisesOverviewViewModel::class.java)

        // Create the observer which updates the UI.
        val cruiseAddingObserver = Observer<Boolean> { newValue ->
          if(newValue){

          }
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.addCruise.observe(viewLifecycleOwner, cruiseAddingObserver)




        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_option -> {
                    // Respond to navigation item 1 click
                    true
                }

                else -> false
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CruisesOverviewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}