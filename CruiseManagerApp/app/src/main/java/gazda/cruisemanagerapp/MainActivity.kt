package gazda.cruisemanagerapp

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.findNavController
import database.connection.RealmContainer
import database.connection.Task
import database.entities.AppUser
import io.realm.OrderedRealmCollectionChangeListener
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import io.realm.mongodb.sync.SyncConfiguration
import kotlinx.android.synthetic.main.activity_main.*
import org.bson.types.ObjectId

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var app: App
    private val APP_ID : String = "applicationpiotreg-zuvkr"
    private lateinit var credentials: Credentials

    override fun onStart() {
        super.onStart()
        navController = this.nav_host_fragment.findNavController()
        val graphInflater = navController.navInflater
        val navGraph = graphInflater.inflate(R.navigation.nav_graph)

        val destination = /*if (intent.getBooleanExtra(
                IS_PRIVACY_POLICY_ACCEPTED,
                false
            )
        ) R.id.homeFragment else*/ R.id.loginFragment
        navGraph.startDestination = destination
        navController.graph = navGraph
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this) // context, usually an Activity or Application

        app = App(
                AppConfiguration.Builder(APP_ID)
                        .build())
        credentials = Credentials.anonymous()
        app.loginAsync(credentials) {
            if (it.isSuccess) {
                Log.v("QUICKSTART", "Successfully authenticated anonymously.")
                val user: User? = app.currentUser()

                val partitionValue: Long = 1L
                val config = SyncConfiguration.Builder(user, partitionValue)
                        .build()
                RealmContainer.myRealm = Realm.getInstance(config)

              /*  val mongoClient =
                        user!!.getMongoClient("mongodb-atlas") // service for MongoDB Atlas cluster containing custom user data
                val mongoDatabase =
                        mongoClient.getDatabase("PiotreG_Database")
                val mongoCollection =
                        mongoDatabase.getCollection("PiotreG_Database.User")
                val me = AppUser(
                        1L,
                        "lily of the valley",
                        "full"
                )
                mongoCollection?.insertOne(me)?.getAsync() { task ->
                    if (task.isSuccess) {
                        Log.v(
                                "EXAMPLE",
                                "successfully inserted a document with id: ${task.get().insertedId}"
                        )
                    } else {
                        Log.e("EXAMPLE", "failed to insert documents with: ${task.error}")
                    }
                }*/
               /* RealmContainer.myRealm.executeTransactionAsync {  r: Realm ->
                    // Instantiate the class using the factory function.
                    val newUser = r.createObject(AppUser::class.java, 1L)
                    // Configure the instance.
                    newUser.name = "Piotr"
                    newUser.surname = "Gazda"
                       }

                       // all tasks in the realm
                      // val tasks : RealmResults<AppUser> = RealmContainer.myRealm.where<AppUser>().findAllAsync()
                val task = RealmContainer.myRealm.where(AppUser::class.java)
                        .equalTo("_id", 1L).findFirst()
                Log.v("EXAMPLE", "Fetched object by primary key: $task")*/
                      // Log.i("First user is: ",tasks[0]?.name + tasks[0]?.surname)
            } else {
                Log.e("QUICKSTART", "Failed to log in. Error: ${it.error}")
            }
        }
    }


    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            if(currentFocus != null) {
                val v: View = currentFocus as View
                if (v is EditText) {
                    val outRect = Rect()
                    v.getGlobalVisibleRect(outRect)
                    if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                        v.clearFocus()
                        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?)?.hideSoftInputFromWindow(v.getWindowToken(), 0)
                    }
                }
            }
        }
        return super.dispatchTouchEvent( event )
    }

    fun addChangeListenerToRealm(realm : Realm) {
        // all tasks in the realm
        val tasks : RealmResults<Task> = realm.where<Task>().findAllAsync()
        tasks.addChangeListener(OrderedRealmCollectionChangeListener<RealmResults<Task>> { collection, changeSet ->
            // process deletions in reverse order if maintaining parallel data structures so indices don't change as you iterate
            val deletions = changeSet.deletionRanges
            for (i in deletions.indices.reversed()) {
                val range = deletions[i]
                Log.v("QUICKSTART", "Deleted range: ${range.startIndex} to ${range.startIndex + range.length - 1}")
            }
            val insertions = changeSet.insertionRanges
            for (range in insertions) {
                Log.v("QUICKSTART", "Inserted range: ${range.startIndex} to ${range.startIndex + range.length - 1}")
            }
            val modifications = changeSet.changeRanges
            for (range in modifications) {
                Log.v("QUICKSTART", "Updated range: ${range.startIndex} to ${range.startIndex + range.length - 1}")
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        RealmContainer.myRealm.close()
        app.currentUser()?.logOutAsync() {
            if (it.isSuccess) {
                Log.v("QUICKSTART", "Successfully logged out.")
            } else {
                Log.e("QUICKSTART", "Failed to log out, error: ${it.error}")
            }
        }
    }

}