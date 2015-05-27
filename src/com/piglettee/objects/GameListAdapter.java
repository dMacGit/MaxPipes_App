package com.piglettee.objects;

import java.util.ArrayList;
import java.util.List;

import com.piglettee.maxpipes.R;


import android.graphics.Bitmap;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GameListAdapter extends BaseAdapter 
{
	private final String TAG = "[MaxPipes] GameListAdapter"; 
			
	private List<GameObject> dataList = new ArrayList<GameObject>();
	private List<Bitmap> imageList = new ArrayList<Bitmap>();
	
	public void updateDataList(List<GameObject> objectList)
	{
		this.dataList = objectList;
	}
	public void updateImageList(List<? extends Parcelable> objectList)
	{
		this.imageList = (List<Bitmap>) objectList;
	}
	

	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}


	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return dataList.get(position);
	}


	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	public View getView(int position, View convertView, ViewGroup parent) 
	{
		if(convertView==null)
		{
			LayoutInflater inflater = (LayoutInflater) LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.game_view, parent,false);
		}
		TextView GameName = (TextView)convertView.findViewById(R.id.gameName);
		TextView GameViews = (TextView)convertView.findViewById(R.id.gameViews);
		ImageView ImageURL = (ImageView)convertView.findViewById(R.id.gameImage);
		
		final GameObject tempGame = dataList.get(position);
		if(tempGame.getGame()!=null)
		{	
			GameName.setText(tempGame.getGame().getName());
			GameViews.setText(Integer.toString(tempGame.getViewers()));
			if(!imageList.isEmpty())
			{
				ImageURL.setImageBitmap(imageList.get(position));
			}
		}
		return convertView;
	}
	
}
