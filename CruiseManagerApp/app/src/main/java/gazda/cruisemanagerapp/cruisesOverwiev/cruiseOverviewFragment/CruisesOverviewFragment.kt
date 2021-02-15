package gazda.cruisemanagerapp.cruisesOverwiev.cruiseOverviewFragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import database.CruiseDatabase
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.databinding.CruisesOverviewFragmentBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CruisesOverviewFragment : Fragment() {


    private lateinit var viewModel: CruisesOverviewViewModel

    private lateinit var binding:CruisesOverviewFragmentBinding

    private lateinit var  adapter:CruisesOverwievRecyclerViewAdapter

    private val disposable = CompositeDisposable()

    override fun onStart() {
        super.onStart()
        // Subscribe to the emissions of the user name from the view model.
        // Update the user name text view, at every onNext emission.
        // In case of error, log the exception.
        disposable += (viewModel.getCruisesFromDatabase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ adapter.addCruise(it) },
                { error -> Log.e(TAG, "Unable to get cruise info", error) }))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // get the DataBindingClass
        binding = DataBindingUtil.inflate(inflater, R.layout.cruises_overwiev_fragment, container, false)

        // get the ViewModel.
        viewModel = ViewModelProvider(this).get(CruisesOverviewViewModel::class.java)
        viewModel.setDataSource(CruiseDatabase.getInstance(this.requireContext()).cruiseInfoDao())
        //get the RecyclerView adapter
        adapter = CruisesOverwievRecyclerViewAdapter(viewModel.getMyCruises(),
            binding.activeCruisesView
        )

        binding.activeCruisesView.layoutManager = LinearLayoutManager(context)
        binding.activeCruisesView.adapter = adapter

        setActiveCruisesInfoLabelValue()

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

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CruisesOverviewViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun setActiveCruisesInfoLabelValue()
    {
        if(viewModel.cruises.isEmpty()){
            binding.activeCruisesStatusInformationText.visibility = View.VISIBLE
        }else{
            binding.activeCruisesStatusInformationText.visibility = View.INVISIBLE
        }
    }

    operator fun CompositeDisposable.plusAssign(disposable: Disposable){
        this.add(disposable)
    }
}


