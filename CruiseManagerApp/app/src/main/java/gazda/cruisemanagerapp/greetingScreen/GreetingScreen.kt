package gazda.cruisemanagerapp.greetingScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gazda.cruisemanagerapp.R

class GreetingScreen : Fragment() {

    companion object {
        fun newInstance() =
            GreetingScreen()
    }

    private lateinit var viewModel: GreetingScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.greeting_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GreetingScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}