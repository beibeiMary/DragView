# DragView
DragView from one to Another
  private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
            else {
                return false;
            }
        }
    }
        class MyDragListener implements View.OnDragListener {
            Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
            Drawable normalShape = getResources().getDrawable(R.drawable.shape);

            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // Do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundDrawable(enterShape);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundDrawable(normalShape);
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        View view = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        LinearLayout container = (LinearLayout) v;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        v.setBackgroundDrawable(normalShape);
                    default:
                        break;
                }
                return true;
            }
        }
        
        
二、静态壁纸和动态壁纸相关的内容
     4.Android 静态/动态壁纸（Live wallpaper）
         使用Bitmap做为壁纸
WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
  	   try {
    	    Bitmap wallpaperBitmap = BitmapFactory.decodeResource(getResources(), R.raw.girl);
        	wallpaperManager.setBitmap(wallpaperBitmap);
 	   } catch (IOException e) {
       		 e.printStackTrace();
	    }
    使用资源文件做为壁纸
wallpaperManager.setResource(R.raw.wallpaper);
    系统壁纸和锁屏壁纸的区分
            //WallpaperManager.FLAG_LOCK  WallpaperManager.FLAG_SYSTEM
            wallpaperManager.setResource(R.raw.wallpaper, WallpaperManager.FLAG_SYSTEM);
 	   清除壁纸
wallpaperManager.clear();
   	   在集成ContextWrapper的类中直接使用，例如：Activity中设置壁纸
           setWallpaper(wallpaperBitmap);或
           setWallpaper(getResources().openRawResource(R.raw.girl));
           clearWallpaper();
           设置壁纸需添加壁纸的权限：
           <uses-permission android:name="android.permission.SET_WALLPAPER" />
           <uses-permission android:name="android.permission.WRITE_SETTINGS"/>
          动态壁纸
          首先创建一个壁纸Service（LiveWallpaperService），继承WallpaperService 
          在LiveWallpaperService中创建一个引擎（LiveWallpaperEngine），继                LiveWallpaperService.Engine 
          在LiveWallpaperService的onCreateEngine方法中，返回LiveWallpaperEngine的实例 
          在AndroidManifest添加Service
          
          
          
三、简单的自定义View
