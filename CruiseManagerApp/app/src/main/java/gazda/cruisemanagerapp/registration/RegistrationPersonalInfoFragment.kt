package gazda.cruisemanagerapp.registration

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import gazda.cruisemanagerapp.R


class RegistrationPersonalInfoFragment : Fragment() {

    companion object {
        fun newInstance() = RegistrationPersonalInfoFragment()
    }

    private lateinit var viewModel: RegistrationPersonalInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.registration_personal_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistrationPersonalInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }
}