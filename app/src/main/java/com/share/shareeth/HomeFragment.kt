package com.share.shareeth

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.rongyi.baselibrary.ext.execute
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/26
 */

class HomeFragment : BaseFragment() {

    var mData = ArrayList<ImoocBean>()
    lateinit var mAdapter: EmptyAdapter

    var page = 0

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refreshLayout.setOnRefreshListener {
            initNetwork(0)
            refreshLayout.isRefreshing = false
        }

        mImoocRecycler.layoutManager = LinearLayoutManager(activity)
        mAdapter = EmptyAdapter(R.layout.fragment_item_imooc, mData)
        mAdapter.openLoadAnimation()
        mImoocRecycler.adapter = mAdapter

        mAdapter.onItemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { _, view, position ->

            when (view.id) {
                R.id.courseBanner -> {
                    val intent = Intent(activity, WebViewActivity::class.java)
                    intent.putExtra("url", mData[position].courseBaseUrl)
                    startActivity(intent)
                }
                R.id.content_frame -> {

                }
            }

        }

        mAdapter.setOnLoadMoreListener({


            initNetwork(++page)


        }, mImoocRecycler)

        initNetwork(page)
    }

    private fun initNetwork(page: Int) {

        val hashMap = HashMap<String, String>()
        hashMap["token"] = "yikwing"
        hashMap["pageIndex"] = page.toString()

        RetrofitFactory.instance.create(ImoocService::class.java)
                .getImoocInfo(hashMap)
                .execute(object : Observer<List<ImoocBean>> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: List<ImoocBean>) {

                        mData.addAll(t)
                        mAdapter.notifyDataSetChanged()

                        mAdapter.loadMoreComplete()

                    }

                    override fun onError(e: Throwable) {
                        mAdapter.loadMoreEnd()
                    }
                })
    }


}