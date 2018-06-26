package com.share.shareeth

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class EmptyAdapter(layoutResId: Int, data: MutableList<ImoocBean>?) : BaseQuickAdapter<ImoocBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder, item: ImoocBean) {


        helper.setText(R.id.mTVcourseName, item.courseName)
        GlideApp.with(mContext).load(item.courseBanner)
                .into(helper.getView(R.id.courseBanner))



        helper.addOnClickListener(R.id.mRelative)

    }
}