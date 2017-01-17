package com.wardman.chatheads;

public class ChatHeadService extends Service {

  private WindowManager windowManager;
  private ImageView chatHead;

  @Override public IBinder onBind(Intent intent) {
    // Not used
    return null;
  }

  @Override public void onCreate() {
    super.onCreate();

    windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

    chatHead = new ImageView(this);
    chatHead.setImageResource(R.drawable.android_head);

    WindowManager.LayoutParams params = new WindowManager.LayoutParams(
        WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.TYPE_PHONE,
        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
        PixelFormat.TRANSLUCENT);

    params.gravity = Gravity.TOP | Gravity.LEFT;
    params.x = 0;
    params.y = 100;

    windowManager.addView(chatHead, params);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    if (chatHead != null) windowManager.removeView(chatHead);
  }
}