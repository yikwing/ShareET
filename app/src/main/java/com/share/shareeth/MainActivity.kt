package com.share.shareeth

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mFragment: BaseFragment = HomeFragment()//刚显示的Fragment
    private val mBaseFragments = ArrayList<BaseFragment>()
    private var position: Int = 0 //当前选中的位置

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                position = 0
                val currentFragment = getFragment()
                replaceFragment(mFragment, currentFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                position = 1
                val currentFragment = getFragment()
                replaceFragment(mFragment, currentFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                position = 2
                val currentFragment = getFragment()
                replaceFragment(mFragment, currentFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        toolbar.title = "Share"
////        setSupportActionBar(toolbar)

        mBaseFragments.add(HomeFragment())
        mBaseFragments.add(HomeFragment())
        mBaseFragments.add(UserFragment())

        replaceFragment(mFragment, HomeFragment())

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun replaceFragment(lastFragment: BaseFragment?, currentFragment: BaseFragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        //如果两个不相等,说明切换了Fragment
        if (lastFragment !== currentFragment) {
            mFragment = currentFragment

            //隐藏刚显示的Fragment
            if (lastFragment != null) {
                transaction.hide(lastFragment)
            }
            /**
             * 显示 或者 添加当前要显示的Fragment
             *
             * 如果当前要显示的Fragment没添加过 则 添加
             * 如果当前要显示的Fragment被添加过 则 隐藏
             */
            if (!currentFragment.isAdded) {
                transaction.add(R.id.content_frame, currentFragment).commit()
            } else {
                transaction.show(currentFragment).commit()
            }
        }
    }

    /**
     * 根据返回到对应的Fragment
     * @return
     */
    private fun getFragment(): BaseFragment {
        return mBaseFragments[position]
    }
}
