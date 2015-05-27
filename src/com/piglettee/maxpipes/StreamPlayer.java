package com.piglettee.maxpipes;

import java.io.IOException;






import android.annotation.TargetApi;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.piglettee.objects.VideoControllerView;

public class StreamPlayer extends Activity implements SurfaceHolder.Callback, OnPreparedListener, VideoControllerView.MediaPlayerControl
{
	private SurfaceView videoSurface;
	private MediaPlayer mediaPlayer;
	private VideoControllerView mediaController;
	private String sourceURL;
	@TargetApi(Build.VERSION_CODES.KITKAT)
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		
		if(false)
		{
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}
		else
		{
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE);
		}
	    
		
		setContentView(R.layout.activity_stream_player);
		
		Bundle passedData = getIntent().getExtras();
		if(passedData != null)
		{
			
			sourceURL = passedData.get("source").toString();
			//System.out.println("Found the Bundle! "+sourceURL);
		}
		
		
		videoSurface = (SurfaceView) findViewById(R.id.videoSurface);
		SurfaceHolder videoHolder = videoSurface.getHolder();
		videoHolder.addCallback(this);
		
		mediaPlayer = new MediaPlayer();
		mediaController = new VideoControllerView(this);
		
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);			//<----- Maybe need this too!
		try 
		{
			mediaPlayer.setDataSource(this, Uri.parse(sourceURL));
			mediaPlayer.setOnPreparedListener(this);
		}
		catch (IllegalArgumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalStateException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			if(!mediaController.isShowing())
			{
				mediaController.show();
				return true;
			}
			else 
			{
				mediaController.hide();
				return true;
			}
		}
		else return false;
		
	}
	
	
	
	@Override
	public void onPrepared(MediaPlayer mp) 
	{
		mediaController.setMediaPlayer(this);
		mediaController.setAnchorView( (FrameLayout) findViewById(R.id.videoSurfaceContainer));
		mediaPlayer.start();
	}
	
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) 
	{
		mediaPlayer.setDisplay(holder);
		mediaPlayer.prepareAsync();
		
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) 
	{
		//Nothing in this method!
		
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		//Nothing to change here yet!
		
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		mediaPlayer.start();
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		mediaPlayer.pause();
	}
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void seekTo(int pos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return mediaPlayer.isPlaying();
	}
	@Override
	public int getBufferPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean canPause() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean canSeekBackward() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean canSeekForward() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isFullScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	public void toggleFullScreen() {
		// TODO Auto-generated method stub
		
	}


}
