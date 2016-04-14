package wacode.yuki.designsupportlibrarysample.kotCode.NavigationView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.bindView
import wacode.yuki.designsupportlibrarysample.R


class ktNavigationViewActivity : AppCompatActivity() {

    private val content: LinearLayout by bindView(R.id.content)
    private val navigationView: NavigationView by bindView(R.id.navigationView)
    private val drawerLayout: DrawerLayout by bindView(R.id.drawerLayout)
    private val textView: TextView by bindView(R.id.textView)
    private val toolBar: Toolbar by bindView(R.id.toolBar)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_view)

        initToolBar()
        setupDrawer()
    }

    private fun initToolBar(){
        setSupportActionBar(toolBar)
        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_open, R.string.navigation_close)
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerToggle.syncState()
        drawerLayout.setDrawerListener(drawerToggle)
    }

    private fun setupDrawer(){
        navigationView.setNavigationItemSelectedListener({ menuItem ->
            Snackbar.make(content, menuItem.title, Snackbar.LENGTH_LONG).show()
            menuItem.isChecked = true
            textView.text = menuItem.title
            menuItem.isChecked
            drawerLayout.closeDrawers()
            true
        })
    }
}
