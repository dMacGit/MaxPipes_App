package Drawables;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

/* ---------------------------------------------------------------------------------------------
 * 
 * This is custom Drawable in order to draw out Text onto a <item> within a layer-list.
 * 
 * ----------------------------------------------------------------------------------------------
 * 
 * Taken from SO: StackOverflow -> @ http://bit.ly/1Kuv0k1
 * Or original link: -> @ http://stackoverflow.com/questions/3972445/how-to-put-text-in-a-drawable
 * 
 * NOTE: Totally not COPY-PASTED.... Honest!
 */

public class TextDrawable extends Drawable
{
	private final String text;
	private final Paint paint;
	
	public TextDrawable(String text){
		this.text = text;
		
		this.paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(22f);
		paint.setAntiAlias(true);
		paint.setFakeBoldText(true);
		paint.setShadowLayer(6f, 0, 0 ,Color.BLACK);
		paint.setStyle(Paint.Style.FILL);
		paint.setTextAlign(Paint.Align.LEFT);
		
	}
	
	public void draw(Canvas canvas){
		canvas.drawText(text, 0, 0, paint);
	}
	
	public void setAlpha(int alpha){
		paint.setAlpha(alpha);
	}
	
	public void setColorFilter(ColorFilter cf){
		paint.setColorFilter(cf);
	}
	
	public int getOpacity(){
		return PixelFormat.TRANSLUCENT;
	}
}
