# TwotabLayout

标签（空格分隔）： 开源项目

---
####显示效果如下  相关注释已经在代码中  具体修改地方也有标记
![](http://ww1.sinaimg.cn/mw690/006jcGvzly1fe1dow9tbej30u01hcjsa.jpg)

```
 /**
     * 设置未读消息偏移,原点为文字的右上角.当控件高度固定,消息提示位置易控制,显示效果佳
     * 位置表示  从0开始
     */
    public void setMsgMargin(int position, float leftPadding, float bottomPadding) {
        if (position >= mTabCount) {
            position = mTabCount - 1;
        }
        View tabView = mTabsContainer.getChildAt(position);
        MsgView tipView = (MsgView) tabView.findViewById(R.id.rtv_msg_tip);
        if (tipView != null) {
            TextView tv_tab_title = (TextView) tabView.findViewById(R.id.tv_tab_title);
            mTextPaint.setTextSize(mTextsize);
            float textWidth = mTextPaint.measureText(tv_tab_title.getText().toString());
            float textHeight = mTextPaint.descent() - mTextPaint.ascent();
            MarginLayoutParams lp = (MarginLayoutParams) tipView.getLayoutParams();

            //用于调整当只有两个tab的时候 msg显示位置错乱问题  // TODO: 2017/3/25 当有多个的时候可以在这里进行判断一下
            lp.leftMargin = mTabWidth >= 0 ? (int) (mTabWidth / 2 + textWidth / 2 + dp2px(leftPadding)) :
                    (int) (mTabPadding * 3 / 2 + textWidth * 3 / 2 + dp2px(leftPadding));

            //一下的这一句是当tab数量多于2个,也就是多个的时候  MsgView的显示位置是正常的
//            lp.leftMargin = mTabWidth >= 0 ? (int) (mTabWidth / 2 + textWidth / 2 + dp2px(leftPadding)) :
//                    (int) (mTabPadding + textWidth  + dp2px(leftPadding));
//            lp.leftMargin
            lp.topMargin = mHeight > 0 ? (int) (mHeight - textHeight) / 2 - dp2px(bottomPadding) : 0;

            tipView.setLayoutParams(lp);
        }
    }

```


