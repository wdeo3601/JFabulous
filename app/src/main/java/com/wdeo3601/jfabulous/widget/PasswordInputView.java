//package com.wdeo3601.jfabulous.widget;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.RectF;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.util.TypedValue;
//import android.widget.EditText;
//
//import com.quxiangtou.release.R;
//
//import static android.graphics.Paint.ANTI_ALIAS_FLAG;
//
///**
// * Desc:
// * User: tiansj
// */
//public class PasswordInputView extends EditText {
//
//    private static final int defaultContMargin = 5;
//    private static final int defaultSplitLineWidth = 3;
//
//    private int borderColor = 0xFFCCCCCC;
//    private float borderWidth = 5;
//    private float borderRadius = 3;
//
//    private int passwordLength = 6;
//    private int passwordColor = 0xFFCCCCCC;
//    private float passwordWidth = 8;
//    private float passwordRadius = 3;
//
//    private Paint passwordPaint = new Paint(ANTI_ALIAS_FLAG);
//    private Paint borderPaint = new Paint(ANTI_ALIAS_FLAG);
//    private int textLength;
//    private CharSequence text;
//
//    public PasswordInputView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//
//        DisplayMetrics dm = getResources().getDisplayMetrics();
//        borderWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, borderWidth, dm);
//        borderRadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, borderRadius, dm);
//        passwordLength = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, passwordLength, dm);
//        passwordWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, passwordWidth, dm);
//        passwordRadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, passwordRadius, dm);
//
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PasswordInputView, 0, 0);
//        borderColor = a.getColor(R.styleable.PasswordInputView_pivBorderColor, borderColor);
//        borderWidth = a.getDimension(R.styleable.PasswordInputView_pivBorderWidth, borderWidth);
//        borderRadius = a.getDimension(R.styleable.PasswordInputView_pivBorderRadius, borderRadius);
//        passwordLength = a.getInt(R.styleable.PasswordInputView_pivPasswordLength, passwordLength);
//        passwordColor = a.getColor(R.styleable.PasswordInputView_pivPasswordColor, passwordColor);
//        passwordWidth = a.getDimension(R.styleable.PasswordInputView_pivPasswordWidth, passwordWidth);
//        passwordRadius = a.getDimension(R.styleable.PasswordInputView_pivPasswordRadius, passwordRadius);
//        a.recycle();
//
//        borderPaint.setStrokeWidth(borderWidth);
//        borderPaint.setColor(borderColor);
////        passwordPaint.setStrokeWidth(passwordWidth);
////        passwordPaint.setStyle(Paint.Style.FILL);
//        passwordPaint.setColor(passwordColor);
//        passwordPaint.setTextSize(60f);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        int width = getWidth();
//        int height = getHeight();
//
//        // 外边框
//        RectF rect = new RectF(0, 0, width, height);
//        borderPaint.setColor(borderColor);
//        canvas.drawRoundRect(rect, borderRadius, borderRadius, borderPaint);
//
//        // 内容区
//        RectF rectIn = new RectF(rect.left + defaultContMargin, rect.top + defaultContMargin,
//                rect.right - defaultContMargin, rect.bottom - defaultContMargin);
//        borderPaint.setColor(Color.WHITE);
//        canvas.drawRoundRect(rectIn, borderRadius, borderRadius, borderPaint);
//
//        // 分割线
//        borderPaint.setColor(borderColor);
//        borderPaint.setStrokeWidth(defaultSplitLineWidth);
//        for (int i = 1; i < passwordLength; i++) {
//            float x = width * i / passwordLength;
//            canvas.drawLine(x, 0, x, height, borderPaint);
//        }
//
//        // 密码
//        float cx, cy = height * 2 / 3.2f;
//        float half = width / passwordLength / 2;
//        for (int i = 0; i < textLength; i++) {
//            cx = width * i / passwordLength + half - 14;
////            canvas.drawCircle(cx, cy, passwordWidth, passwordPaint);
//            canvas.drawText(String.valueOf(text.charAt(i)), cx, cy, passwordPaint);
//        }
//    }
//
//    @Override
//    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
//        super.onTextChanged(text, start, lengthBefore, lengthAfter);
//        this.textLength = text.toString().length();
//        this.text = text;
//        invalidate();
//    }
//
//    public int getBorderColor() {
//        return borderColor;
//    }
//
//    public void setBorderColor(int borderColor) {
//        this.borderColor = borderColor;
//        borderPaint.setColor(borderColor);
//        invalidate();
//    }
//
//    public float getBorderWidth() {
//        return borderWidth;
//    }
//
//    public void setBorderWidth(float borderWidth) {
//        this.borderWidth = borderWidth;
//        borderPaint.setStrokeWidth(borderWidth);
//        invalidate();
//    }
//
//    public float getBorderRadius() {
//        return borderRadius;
//    }
//
//    public void setBorderRadius(float borderRadius) {
//        this.borderRadius = borderRadius;
//        invalidate();
//    }
//
//    public int getPasswordLength() {
//        return passwordLength;
//    }
//
//    public void setPasswordLength(int passwordLength) {
//        this.passwordLength = passwordLength;
//        invalidate();
//    }
//
//    public int getPasswordColor() {
//        return passwordColor;
//    }
//
//    public void setPasswordColor(int passwordColor) {
//        this.passwordColor = passwordColor;
//        passwordPaint.setColor(passwordColor);
//        invalidate();
//    }
//
//    public float getPasswordWidth() {
//        return passwordWidth;
//    }
//
//    public void setPasswordWidth(float passwordWidth) {
//        this.passwordWidth = passwordWidth;
//        passwordPaint.setStrokeWidth(passwordWidth);
//        invalidate();
//    }
//
//    public float getPasswordRadius() {
//        return passwordRadius;
//    }
//
//    public void setPasswordRadius(float passwordRadius) {
//        this.passwordRadius = passwordRadius;
//        invalidate();
//    }
//}

/**
 * 即刻app反编译的代码  FavorView
 * **/
//package com.ruguoapp.jike.view.widget;
//
//import android.animation.Animator;
//import android.animation.AnimatorSet;
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Paint.Style;
//import android.graphics.drawable.Drawable;
//import android.support.v4.content.c;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.AccelerateDecelerateInterpolator;
//import android.view.animation.AccelerateInterpolator;
//import android.view.animation.LinearInterpolator;
//import android.widget.ImageView;
//import com.ruguoapp.jike.lib.b.f;
//import com.ruguoapp.jike.lib.c.b.a;
//
//public class FavorView extends ViewGroup
//{
//    private ImageView a;
//    private ImageView b;
//    private ImageView c;
//    private a d;
//    private int e;
//    private int f;
//    private float g;
//    private AnimatorSet h;
//    private ValueAnimator i;
//
//    public FavorView(Context paramContext)
//    {
//        super(paramContext);
//        b();
//    }
//
//    public FavorView(Context paramContext, AttributeSet paramAttributeSet)
//    {
//        super(paramContext, paramAttributeSet);
//        b();
//    }
//
//    public FavorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
//    {
//        super(paramContext, paramAttributeSet, paramInt);
//        b();
//    }
//
//    private void b()
//    {
//        this.a = new ImageView(getContext());
//        this.a.setImageResource(2130837735);
//        this.b = new ImageView(getContext());
//        this.b.setImageResource(2130837733);
//        this.c = new ImageView(getContext());
//        this.c.setImageResource(2130837734);
//        this.d = new a(getContext());
//        addView(this.d);
//        addView(this.b);
//        addView(this.c);
//        addView(this.a);
//        c();
//        d();
//    }
//
//    private void c()
//    {
//        Bitmap localBitmap1 = BitmapFactory.decodeResource(getContext().getResources(), 2130837735);
//        this.e = Math.max(localBitmap1.getWidth(), localBitmap1.getHeight());
//        Bitmap localBitmap2 = BitmapFactory.decodeResource(getContext().getResources(), 2130837734);
//        this.f = Math.max(localBitmap2.getWidth(), localBitmap2.getHeight());
//        localBitmap1.recycle();
//        localBitmap2.recycle();
//        this.g = (this.e + this.f);
//    }
//
//    private void d()
//    {
//        this.h = new AnimatorSet();
//        this.i = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
//    }
//
//    private void e()
//    {
//        ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
//        localValueAnimator1.addUpdateListener(r.a(this));
//        localValueAnimator1.setDuration(50L);
//        localValueAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
//        localValueAnimator1.start();
//        AnimatorSet localAnimatorSet1 = new AnimatorSet();
//        ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
//        localValueAnimator2.addUpdateListener(s.a(this));
//        localValueAnimator2.setDuration(200L);
//        ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { 1.1F, 0.9F, 1.0F });
//        localValueAnimator3.addUpdateListener(t.a(this));
//        localValueAnimator3.setDuration(125L);
//        localAnimatorSet1.playSequentially(new Animator[] { localValueAnimator2, localValueAnimator3 });
//        localAnimatorSet1.setStartDelay(50L);
//        localAnimatorSet1.setInterpolator(new LinearInterpolator());
//        localAnimatorSet1.start();
//        ValueAnimator localValueAnimator4 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.1F, 1.0F });
//        localValueAnimator4.addUpdateListener(u.a(this));
//        localValueAnimator4.setDuration(350L);
//        localValueAnimator4.setStartDelay(50L);
//        localValueAnimator4.setInterpolator(new AccelerateInterpolator());
//        localValueAnimator4.start();
//        ValueAnimator localValueAnimator5 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
//        localValueAnimator5.addUpdateListener(v.a(this));
//        localValueAnimator5.setDuration(275L);
//        ValueAnimator localValueAnimator6 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
//        localValueAnimator6.addUpdateListener(w.a(this));
//        localValueAnimator6.setDuration(75L);
//        AnimatorSet localAnimatorSet2 = new AnimatorSet();
//        localAnimatorSet2.playSequentially(new Animator[] { localValueAnimator5, localValueAnimator6 });
//        localAnimatorSet2.addListener(new a()
//        {
//            public void onAnimationStart(Animator paramAnonymousAnimator)
//            {
//                FavorView.b(FavorView.this).setScaleX(0.0F);
//                FavorView.b(FavorView.this).setScaleY(0.0F);
//                FavorView.b(FavorView.this).setAlpha(1.0F);
//            }
//        });
//        ValueAnimator localValueAnimator7 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.2F });
//        localValueAnimator7.addUpdateListener(x.a(this));
//        localValueAnimator7.setDuration(350L);
//        this.h.playTogether(new Animator[] { localValueAnimator7, localAnimatorSet2 });
//        this.h.setInterpolator(new AccelerateDecelerateInterpolator());
//        this.h.start();
//    }
//
//    private void f()
//    {
//        this.i.removeAllListeners();
//        this.i.addUpdateListener(y.a(this));
//        this.i.addListener(new a()
//        {
//            public void onAnimationEnd(Animator paramAnonymousAnimator)
//            {
//                FavorView.this.setHasSelected(false);
//            }
//        });
//        this.i.setInterpolator(new AccelerateDecelerateInterpolator());
//        this.i.setDuration(200L);
//        this.i.start();
//    }
//
//    private float getFavorScale()
//    {
//        return Math.max(getMeasuredHeight(), getMeasuredWidth()) / this.g;
//    }
//
//    public void a()
//    {
//        this.a.setImageResource(2130837735);
//        this.b.setImageResource(2130837733);
//        this.c.setVisibility(0);
//        this.d.setVisibility(0);
//    }
//
//    public void a(Drawable paramDrawable1, Drawable paramDrawable2)
//    {
//        this.a.setImageDrawable(paramDrawable1);
//        this.b.setImageDrawable(paramDrawable2);
//        this.c.setVisibility(4);
//        this.d.setVisibility(4);
//    }
//
//    public void a(boolean paramBoolean)
//    {
//        this.h.removeAllListeners();
//        if (paramBoolean)
//        {
//            e();
//            return;
//        }
//        if (this.h.isRunning())
//        {
//            this.h.addListener(new a()
//            {
//                public void onAnimationEnd(Animator paramAnonymousAnimator)
//                {
//                    FavorView.a(FavorView.this);
//                }
//            });
//            return;
//        }
//        f();
//    }
//
//    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
//    {
//        int j = getMeasuredWidth();
//        int k = getMeasuredHeight();
//        int m = getPaddingLeft() - getPaddingRight();
//        int n = getPaddingTop() - getPaddingBottom();
//        int i1 = (int)(this.e * getFavorScale());
//        int i2 = (j - i1) / 2;
//        int i3 = (k - i1) / 2;
//        int i4 = i2 + i1;
//        int i5 = i3 + i1;
//        this.a.layout(i2 + m, i3 + n, m + (i2 + i1), n + (i3 + i1));
//        this.b.layout(i2 + m, i3 + n, m + (i2 + i1), n + (i3 + i1));
//        int i6 = (int)(this.f * getFavorScale());
//        int i7 = i2 + (i1 - i6) / 2;
//        int i8 = i3 - i6 / 2;
//        this.c.layout(i7 + m, i8 + n, m + (i7 + i6), n + (i6 + i8));
//        this.d.layout(m + (i2 - i1 / 4), n + (i3 - i1 / 4), m + (i4 + i1 / 4), n + (i5 + i1 / 4));
//    }
//
//    protected void onMeasure(int paramInt1, int paramInt2)
//    {
//        super.onMeasure(paramInt1, paramInt2);
//        measureChildren(paramInt1, paramInt2);
//        setMeasuredDimension(paramInt1, paramInt2);
//    }
//
//    public void setHasSelected(boolean paramBoolean)
//    {
//        if (paramBoolean)
//        {
//            this.b.setAlpha(1.0F);
//            this.c.setAlpha(1.0F);
//            this.a.setAlpha(0.0F);
//        }
//        while (true)
//        {
//            this.d.setAlpha(0.0F);
//            return;
//            this.b.setAlpha(0.0F);
//            this.c.setAlpha(0.0F);
//            this.a.setAlpha(1.0F);
//        }
//    }
//
//    class a extends View
//    {
//        public int a = f.a(2.0F);
//        private Paint c;
//
//        public a(Context arg2)
//        {
//            super();
//            a();
//        }
//
//        private void a()
//        {
//            this.c = new Paint(1);
//            this.c.setStyle(Paint.Style.STROKE);
//            this.c.setColor(c.c(getContext(), 2131689500));
//            this.c.setStrokeWidth(this.a);
//        }
//
//        public void a(float paramFloat)
//        {
//            this.c.setStrokeWidth(paramFloat);
//            invalidate();
//        }
//
//        protected void onDraw(Canvas paramCanvas)
//        {
//            super.onDraw(paramCanvas);
//            paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 2) - this.a, this.c);
//        }
//    }
//}
