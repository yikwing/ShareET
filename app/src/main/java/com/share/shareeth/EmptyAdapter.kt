package com.share.shareeth

import com.cb.ratingbar.CBRatingBar
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class EmptyAdapter(layoutResId: Int, data: MutableList<ImoocBean>?) : BaseQuickAdapter<ImoocBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder, item: ImoocBean) {


        helper.setText(R.id.mTVcourseName, item.courseName)
        helper.setText(R.id.mTVcourseBuyNum, "购买人数: ${item.courseBuyNum}")
        helper.setText(R.id.mTVcourseIntroduction, item.courseIntroduction)

        val evaluation = item.courseEvaluation.replace("评价：", "")
                .replace("分", "").toFloat()

        (helper.getView(R.id.mRatingBar) as CBRatingBar)
                .starProgress = evaluation

        helper.setText(R.id.mTVcourseEvaluation, evaluation.toString())


        GlideApp.with(mContext).load(item.courseBanner)
                .into(helper.getView(R.id.courseBanner))



        helper.addOnClickListener(R.id.mRelative)
                .addOnClickListener(R.id.courseBanner)

    }
}