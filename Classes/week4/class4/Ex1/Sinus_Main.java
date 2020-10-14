//package class5.Ex1;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class demonstrate a simple set of sin funxtions and draw them in a GUI window.
 * A trivial example of inner class is also presented.
 */
class Sinus_Main {
	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, 
			Color.red, Color.GREEN, Color.PINK};
	public static void main(String[] args) {
		ArrayList<function> ff = new ArrayList<function>();
		ff.addAll(init());
		drawFunctions(ff);
	}

	public static ArrayList<function> init() {
		ArrayList<function> ans = new ArrayList<function>();
		Sinus s0 = new Sinus();
		Monom m1 = new Monom("4x");
		Monom m2 = new Monom("0.3x^3");
		Sinus s1 = new Sinus(m1);
		Sinus s2 = new Sinus(m2);
		ans.add(s0); ans.add(s1); ans.add(s2);
		return ans;
	}
	public static void drawFunctions(ArrayList<function> ff) {drawFunctions(ff, GUI_Params.DEFAULT_GUI_PARAMS);}
	public static void drawFunctions(ArrayList<function> ff, GUI_Params gp) {
		drawFunctions(ff, gp.get_width(),gp.get_height(),gp.get_rx(), gp.get_ry(),gp.get_resolution());
	}
	public static void drawFunctions(ArrayList<function> ff, int width, int height, Range rx, Range ry, int res) {
		int n = res;
		StdDraw.setCanvasSize(width, height);
		int size = ff.size();
		double[] x = new double[n+1];
		double[][] yy = new double[size][n+1];
		double x_step = (rx.get_max()-rx.get_min())/n;
		double x0 = rx.get_min();
		for (int i=0; i<=n; i++) {
			x[i] = x0;
			for(int a=0;a<size;a++) {
				yy[a][i] = ff.get(a).f(x[i]);
			}
			x0+=x_step;
		}
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		
		
		// plot the approximation to the function
		for(int a=0;a<size;a++) {
			int c = a%Colors.length;
			StdDraw.setPenColor(Colors[c]);
		
			System.out.println(a+") "+Colors[a]+"  f(x)= "+ff.get(a));
			for (int i = 0; i < n; i++) {
				StdDraw.line(x[i], yy[a][i], x[i+1], yy[a][i+1]);
			}
		}	
	}

	/**
	 * Simple example for inner class.
	 */
	static class GUI_Params {
		public static final int W=800, H=600, RES=100;
		public static final Range RX=new Range(0,10);
		public static final Range RY=new Range(-1.2,1.5);
		public static GUI_Params  DEFAULT_GUI_PARAMS = new GUI_Params(W,H,RX,RY,RES);
		private int _width;
		private int _height;
		private Range _rx;
		private Range _ry;
		private int _resolution;
		public GUI_Params(int w, int h, Range rx, Range ry, int res) {
			this._width = w;
			this._height = h;
			this._rx = rx;
			this._ry = ry;
			this._resolution = res;
		}
		public int get_width() {return this._width;}
		public int get_height() {return this._height;}
		public int get_resolution() {return this._resolution;}
		public Range get_rx() {return this._rx;}
		public Range get_ry() {return this._ry;}
	}
}
