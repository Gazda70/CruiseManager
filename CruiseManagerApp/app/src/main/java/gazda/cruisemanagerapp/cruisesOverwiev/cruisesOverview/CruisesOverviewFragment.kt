package gazda.cruisemanagerapp.cruisesOverwiev.cruisesOverview

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import database.entities.CruiseInfo
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.databinding.CruisesOverviewFragmentBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.cruises_overwiev_fragment.view.*


class CruisesOverviewFragment : Fragment(), ClickListener {


    private lateinit var viewModel: CruisesOverviewViewModel

    private lateinit var binding:CruisesOverviewFragmentBinding

    private lateinit var  adapterFuture:FutureCruisesRecyclerViewAdapter

    private lateinit var adapterPrevious:PreviousCruisesRecyclerViewAdapter

    private lateinit var  gestureDetector: GestureDetector

    private var activeCruise: CruiseInfo? = null

    //private lateinit var username:String

    private val disposable = CompositeDisposable()

    override fun onStart() {
        super.onStart()
        // Subscribe to the emissions of the user name from the view model.
        // Update the user name text view, at every onNext emission.
        // In case of error, log the exception.
       /* disposable += (viewModel.getFutureCruisesFromDatabase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ adapterFuture.addCruise(it) },
                { error -> Log.e(TAG, "Unable to get cruise info", error) }))

        disposable += (viewModel.getPreviousCruisesFromDatabase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ adapterPrevious.addCruise(it) },
                { error -> Log.e(TAG, "Unable to get cruise info", error) }))*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // get the DataBindingClass
        binding = DataBindingUtil.inflate(inflater, R.layout.cruises_overwiev_fragment, container, false)

        // get the ViewModel.
        viewModel = ViewModelProvider(this).get(CruisesOverviewViewModel::class.java)
        //get the RecyclerView adapter
        adapterFuture = FutureCruisesRecyclerViewAdapter(viewModel.getMyCruises(), this)

        adapterPrevious = PreviousCruisesRecyclerViewAdapter(viewModel.getMyCruises(), this)

        binding.futureCruisesView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.futureCruisesView.adapter = adapterFuture

        binding.previousCruisesView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.previousCruisesView.adapter = adapterPrevious


        gestureDetector = GestureDetector(activity, object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
                Log.i("FLING PASKA", "Udało się!")
                binding.root.findNavController().navigate(R.id.action_cruisesOverwievFragment_to_activeCruiseFragment)
                return true
            }

            override fun onDown(p0: MotionEvent?): Boolean {
                Log.i("DOWN PASKA", "Udało się!")
                return true
            }
            override fun onShowPress(p0: MotionEvent?) {
                Log.i("SHOW PRESS PASKA", "Udało się!")
            }

            override fun onSingleTapUp(p0: MotionEvent?): Boolean {
                Log.i("SINGLE TAP UP PASKA", "Udało się!")
                return true
            }

            override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
                Log.i("SCROLL PASKA", "Udało się!")
                return true
            }

            override fun onLongPress(p0: MotionEvent?) {
                Log.i("LONG PRESS PASKA", "Udało się!")
            }

        })

        initializeActiveCruisePanel()

        //setActiveCruisesInfoLabelValue()

        // Create the observer which updates the UI.
        val cruiseAddingObserver = Observer<Boolean> { newValue ->
          if(newValue){

          }
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.addCruise.observe(viewLifecycleOwner, cruiseAddingObserver)



        binding.root.bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_option -> {
                    // Respond to navigation item 1 click
                    true
                }

                R.id.profile_option ->{
             //       binding.root.findNavController().navigate(R.id.action_cruisesOverwievFragment_to_registrationPersonalInfoFragment)
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

 /*   private fun setActiveCruisesInfoLabelValue()
    {
        if(viewModel.cruises.isEmpty()){
            binding.activeCruisesStatusInformationText.visibility = View.VISIBLE
        }else{
            binding.activeCruisesStatusInformationText.visibility = View.INVISIBLE
        }
    }*/

    operator fun CompositeDisposable.plusAssign(disposable: Disposable){
        this.add(disposable)
    }

    override fun onClicked(number: Int) {
     //   binding.root.findNavController().navigate(R.id.action_cruisesOverwievFragment_to_activeCruiseFragment)
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun initializeActiveCruisePanel(){
        activeCruise = viewModel.getCurrentCruiseFromDatabase()
        if(activeCruise!=null){
            binding.root.active_cruise_info_panel.setOnTouchListener { _, motionEvent ->
                Log.i("Typ gestu:", motionEvent.toString())
                gestureDetector.onTouchEvent(motionEvent)
            }
        }else{
            binding.root.bottom_navigation.visibility = View.VISIBLE
        }
    }
}


