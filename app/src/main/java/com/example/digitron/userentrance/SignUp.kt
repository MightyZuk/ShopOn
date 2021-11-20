package com.example.digitron.userentrance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.digitron.MainActivity
import com.example.digitron.R
import com.example.digitron.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.FirebaseDatabase.getInstance
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.DelicateCoroutinesApi
import java.lang.ref.PhantomReference
import java.util.jar.Manifest

class SignUp : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = null
        setContentView(view)

        auth = Firebase.auth

        binding.signInLittle.setOnClickListener {
            Intent(this,SignIn::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    fun createAccount(view: android.view.View) {
        val username = binding.name.text.toString()
        val email = binding.email.text
        val password = binding.password.text
        val terms = binding.terms

        when{
            username.isEmpty() ->{
                binding.name.requestFocus()
                binding.name.error = "required"
            }
            email.isEmpty() -> {
                binding.email.error = "required"
                binding.email.requestFocus()
            }
            password.isEmpty() -> {
                binding.password.error = "required"
                binding.password.requestFocus()
            }
            !terms.isChecked -> {
                terms.error = "required"
                terms.requestFocus()
            }
            else -> {
                startActivity(Intent(this,MainActivity::class.java))
            }

        }
    }

    fun terms(view: android.view.View) {
        val terms = "1.DEFINITIONS\n" +
                "1.1 “Customer” means the person, firm, company or other organisation purchasing the product.\n" +
                "1.2 “Confidential Information” means all information confidential to the Customer whether relating to the Customer’s business, customers, clients, suppliers or otherwise but excluding information now or at any time hereafter becoming generally known or accessible to the general public (unless due to the default of the Company hereunder) and information obtained by the Company from a third party free of restrictions on use or disclosure.\n" +
                "1.3 “Contract” means the agreement between the Customer and the Company covering the products provided.\n" +
                "1.4 “Intellectual Property Rights” means all and any of the following, namely patents, designs, registered designs (and applications for any of the same) copyright, design right, inventions, improvements, discoveries, techniques, know-how and any other intellectual property rights.\n" +
                "1.5 “Products” means the products and/or services to be delivered under this Contract.\n" +
                "1.6 “Company” means Marketing Software.\n" +
                "\n" +
                "2.COMPANY’S OBLIGATIONS\n" +
                "2.1 The Company will provide the Product to the Customer in accordance with the Contract.\n" +
                "2.2 The company never share clients personal details with any third party.\n" +
                "2.3 The Company will use all reasonable endeavours to provide the Products to the Customer within the estimated timings provided but all timings agreed to by the Contractor are business estimates only (but given in good faith) and the Company will not be liable for any loss, injury, damage or expenses arising directly or indirectly from any delay and time will not and cannot ever be of the essence in respect of the Contractor’s performance of its obligations hereunder.\n" +
                "\n" +
                "3.INVOICING &amp; PAYMENT\n" +
                "3.1: The customer has to pay full payment in advance.\n" +
                "3.2: If payment for licence renewal is not received by the due date stated on the renewal quotation, then we reserve the right to deem the licence expired and for any renewal to be invoiced a full list price.\n" +
                "3.3: There is no refund policy by the company any cost.\n" +
                "\n" +
                "4.FORCE MEASURE\n" +
                "4.1 Neither party shall be liable to the other under this Agreement, nor deemed in breach of this Agreement, for failure to carry out its provisions to the extent that such failure is caused by any cause beyond the parties’ respective reasonable control, including without limitation fire, war, riot, sabotage, sickness or industrial action.\n" +
                "\n" +
                "5.INTELLECTUAL PROPERTY RIGHTS\n" +
                "5.1 Each party acknowledges the existence of the other’s intellectual property at the commencement of this Contract and neither party obtains any right to the other’s intellectual property by entering into this contract\n" +
                "5.2 Subject to the Customer first paying to the Company all sums payable to the Company hereunder, the Customer shall obtain a Run Time Licence for its use of the whole system, including Third Party Components, subject to all the terms and conditions attaching to these items.\n" +
                "5.3 The Company shall not infringe the Intellectual Property Rights of any third party and shall indemnify the Customer against all claims, costs and expenses that the Customer may suffer as a result of any such infringement.\n" +
                "\n" +
                "6.PROPRIETARY RIGHTS IN SOFTWARE\n" +
                "6.1 The Customer hereby acknowledges that any proprietary rights in any Product supplied hereunder including but not limited to any title or ownership rights, patent rights, copyrights and trade secret rights shall at all times and for all purposes rest and remain vested in the Product owner.\n" +
                "6.2 The Customer hereby acknowledges that it is its sole responsibility to comply with any terms and conditions of licence attaching to Products supplied and delivered by the Company (including if so required the execution and return of a Product licence). The Customer is hereby notified that failure to comply with such terms and conditions could result in the Customer being refused a software licence or having the same revoked by the Product owner. The Customer further agrees to indemnify the Company in respect of any costs, charges or expenses incurred by the Company at the suit of a Product owner as a result of any breach by the Customer of such conditions.\n" +
                "\n" +
                "7.DATA PROTECTION\n" +
                "7.1 By entering into this Contract, the Customer agrees that any “personal data”, as defined by the Data Protection Act 2018 provided to the Company pursuant to this Contract may be processed by the Company for the following purposes:\n" +
                "Administration and provisioning of the Products, including support and billing of the Products.\n" +
                "To identify and inform the Customer, whether by mail, facsimile, electronic mail or other means of communication of additional services and products available from the Company that may be of interest.\n" +
                "7.2 By entering into this Contract, the Customer represents and warrants that it has drawn the attention of its employees and agents to this clause and has obtained informed and express consent from them to the processing of their data as outlined.\n" +
                "7.3 If the Customer, its employees or agents do not wish to receive further information from the Company, then a request to this effect should be sent to the Company’s Commercial Director.\n" +
                "\n" +
                "8.MISCELLANEOUS\n" +
                "8.1 If any of the terms of this Contract are held to be void or unenforceable by any reason of law they shall be void or unenforceable to that extent only and no further and all other terms shall remain valid and fully enforceable.\n" +
                "8.2 The Customer shall not have any right of set-off.\n" +
                "8.3 No indulgence granted by either party to the other in relation to any term hereof shall be deemed a waiver of such term or prejudice the later enforcement of that or any other term hereof.\n" +
                "8.4 The headings in this Contract are for convenience only and shall not affect its interpretation."

        if (binding.terms.isChecked) {
            val dialog = AlertDialog.Builder(this,R.style.WelcomeStyle)
            dialog.setCancelable(false)
            dialog.setTitle("Terms & Condition")
            dialog.setMessage(terms)
            dialog.setPositiveButton("Accept",null)
            dialog.create()
            dialog.show()

        }
    }


}