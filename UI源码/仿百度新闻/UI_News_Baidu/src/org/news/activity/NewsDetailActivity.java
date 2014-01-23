package org.news.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class NewsDetailActivity extends Activity {

	private ViewFlipper mNewsBody;
	private LayoutInflater inflater;
	private ScrollView mScrollDetail;
	private View mView;
	private Button mNext;
	private Button mPrevious;
	private TextView mNewsTitle;
	private TextView mNewsZuoZhe;
	private TextView mNewsDayTime;
	private ImageView mNewsImage;
	private TextView mNewsContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_detail);
		mNewsBody = (ViewFlipper) findViewById(R.id.news_body_veiw);
		// 创建一个布局扩展
		inflater = getLayoutInflater();
		mView = inflater.inflate(R.layout.news_body, null);
		mNewsBody.addView(mView);
		mNext = (Button) findViewById(R.id.news_detail_next);
		mPrevious = (Button) findViewById(R.id.news_detail_previous);
		mNext.setOnClickListener(getShowNewsOnClick);
		mPrevious.setOnClickListener(getShowNewsOnClick);
		mScrollDetail = (ScrollView)mView.findViewById(R.id.news_detail_scrollview);
		mScrollDetail.setOnTouchListener(getNewsBodyOnTotch);
	}

	private OnClickListener getShowNewsOnClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.news_detail_next:
				showNewxNews();
				break;
			case R.id.news_detail_previous:
				showPreviousNews();
				break;
			default:
				break;
			}
		}
	};
	
	int count = 0;

	/**点击查看下一条新闻**/
	private void showNewxNews() {
		mNewsBody.setInAnimation(NewsDetailActivity.this, R.anim.push__right_in);
		mNewsBody.setOutAnimation(NewsDetailActivity.this, R.anim.push_right_out);
		mNewsBody.showNext();
		View mView1 = inflater.inflate(R.layout.news_body, null);
		mNewsTitle = (TextView)mView1.findViewById(R.id.news_detail_scrollview_newstitle);
		mNewsContent = (TextView) mView1.findViewById(R.id.news_detail_scrollview_layout_buttom_content);
		mScrollDetail = (ScrollView)mView1.findViewById(R.id.news_detail_scrollview);
		mNewsTitle.setText("小小吴新闻微博发布了"+(++count));
		mNewsContent.setText(R.string.news_content);
		mNewsBody.addView(mView1);
		mScrollDetail.setOnTouchListener(getNewsBodyOnTotch);
	}

	/**上一条新闻**/
	private void showPreviousNews() {
		mNewsBody.setInAnimation(NewsDetailActivity.this, R.anim.push_left_in);
		mNewsBody.setOutAnimation(NewsDetailActivity.this, R.anim.push_left_out);
		mNewsBody.showPrevious();
	}
	
	/*手势起始坐标*/
	private float mStartX;
	
	/**在ViewFlipper手势左右滑动查看新闻**/
	private OnTouchListener getNewsBodyOnTotch = new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				//手指按下记录坐标
				case MotionEvent.ACTION_DOWN:
					mStartX = event.getX();
					break;
				//手指抬起
				case MotionEvent.ACTION_UP:
					//往左滑动
					if(event.getX() < mStartX){
						//下一条新闻
						showNewxNews();
					//往右滑动
					}else if(event.getX() > mStartX){
						//上一条新闻
						showPreviousNews();
					}
					break;
				}
				return true;
			}
		};
}
	
	
	
