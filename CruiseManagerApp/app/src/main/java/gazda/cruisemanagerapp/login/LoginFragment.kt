package gazda.cruisemanagerapp.login

import android.R.attr.data
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import database.connection.AccountManager
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.view.*


class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        binding.continueLoginButton.setOnClickListener {

            val name = binding.root.login_name_input_field.text.toString()
            val surname = binding.root.login_surname_input_field.text.toString()

        /* if(checkInput(name, surname)){
             if(viewModel.manageLoginCredentials(name, surname)) {*/
                 binding.root.findNavController()
                     .navigate(R.id.action_loginFragment_to_cruisesOverwievFragment)
             /*}
         }*/

        }

        binding.registerLoginButton.setOnClickListener {
            binding.root.findNavController()
                .navigate(R.id.action_loginFragment_to_registrationPersonalInfoFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.setAccountManager(this.requireContext())
        // TODO: Use the ViewModel
    }

    private fun checkInput(name: String?, surname:String?):Boolean{
        var toReturn = false
        if(name != "" && surname != ""){
            toReturn = true

        }else{
            Toast.makeText(
                this.activity, "Wprowadź dane logowania",
                Toast.LENGTH_LONG
            ).show()
        }
        return toReturn
    }
}