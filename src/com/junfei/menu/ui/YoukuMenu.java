package com.junfei.menu.ui;

import com.junfei.menu.R;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * 创建一个自定义组合控件
 * 
 * @author Administrator
 * 
 */
public class YoukuMenu extends RelativeLayout {
	public RelativeLayout getMLevel1() {
		return mLevel1;
	}

	public void setMLevel1(RelativeLayout mLevel1) {
		this.mLevel1 = mLevel1;
	}

	public RelativeLayout getMLevel2() {
		return mLevel2;
	}

	public void setMLevel2(RelativeLayout mLevel2) {
		this.mLevel2 = mLevel2;
	}

	public RelativeLayout getMLevel3() {
		return mLevel3;
	}

	public void setMLevel3(RelativeLayout mLevel3) {
		this.mLevel3 = mLevel3;
	}

	private RelativeLayout mLevel1;
	private RelativeLayout mLevel2;
	private RelativeLayout mLevel3;
	private YoukuMenu ykm;
	private boolean isAnimotion;
	private boolean YoukuMenUVisable;

	public YoukuMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public YoukuMenu(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initView(context);
	}

	private void initView(Context context) {
		// TODO Auto-generated method stub
		View.inflate(context, R.layout.youkumenu, this);
		mLevel1 = (RelativeLayout) findViewById(R.id.menu_rl_level1);
		mLevel2 = (RelativeLayout) findViewById(R.id.menu_rl_level2);
		mLevel3 = (RelativeLayout) findViewById(R.id.menu_rl_level3);
		ykm = (YoukuMenu) findViewById(R.id.ykm);
	}

	public void rolate(View view, int fromAngle, int toAngle, int delay) {
		// fromDegrees 开始的角度
		// toDegrees 结束的角度
		// pivotXType 相对于父控件还是自己的X轴的中心点,影响下一个参数
		// pivotXValue 具体的X值,这里写0.5f说明X轴旋转的中心点在自己控件的X轴中心
		// pivotYType 相对于父控件还是自己的Y轴的中心点,影响下一个参数
		// pivotYValue 具体的X值,这里写1.0f说明Y轴旋转的中心点在自己控件的Y轴最底部.
		RotateAnimation ra = new RotateAnimation(fromAngle, toAngle,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				1.0f);
		ra.setDuration(900);
		// 这个方法设置动画做完后的状态是否保存.
		ra.setFillAfter(true);
		// 這個方法設置延遲時間,讓第一层的动画做完后再做第二层动画
		ra.setStartOffset(delay);
		view.startAnimation(ra);
	}

	private void showMenu() {
		if (isAnimotion) {
			return;
		}
		isAnimotion = true;
		ykm.rolate(ykm.getMLevel3(), 0, -180, 0);
		ykm.rolate(ykm.getMLevel2(), 0, -180, 300);
		ykm.rolate(ykm.getMLevel1(), 0, -180, 600);
		new Thread() {
			public void run() {
				SystemClock.sleep(900);
				isAnimotion = false;
				YoukuMenUVisable=true;
			};
		}.start();
	}

	private void hideMenu() {
		if (isAnimotion) {
			return;
		}
		isAnimotion = true;
		ykm.rolate(ykm.getMLevel1(), -180, 0, 0);
		ykm.rolate(ykm.getMLevel2(), -180, 0, 300);
		ykm.rolate(ykm.getMLevel3(), -180, 0, 600);
		new Thread() {
			public void run() {
				SystemClock.sleep(900);
				isAnimotion = false;
				YoukuMenUVisable=false;
			};
		}.start();

	}

	public void switchMenu() {
		if(YoukuMenUVisable) {
			hideMenu();
		}else {
			showMenu();
		}
	}
}
