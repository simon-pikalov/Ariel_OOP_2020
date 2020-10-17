
//package class5.Ex1;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * Note: this is only a partial solution as it is part of Ex0 & Ex1
 * @author Boaz
 *
 */

public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	
	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	public static Monom getNewZeroMonom() {return new Monom(ZERO);}
	
	// ***************** add your code below **********************
	public static Comparator<Monom> getComp() { return _Comp;}
	public Monom(String s) {
		this(init(s));
	}
	public boolean equals(Object m1) {
		boolean ans = false;
		if(m1!=null && m1 instanceof Monom) {
			Monom m = (Monom)m1;
			if(this.isZero() && m.isZero()) {ans = true;}
			else {
				double dc = m.get_coefficient() - this.get_coefficient();
				if(m.get_power() == this.get_power() && Math.abs(dc)<EPSILON) {
					ans = true;
				}
			}
		}
		else {
			if(m1!=null && m1 instanceof function) {
				ans = m1.equals(this);
			}
		}
		return ans;
	}
	public boolean isZero() {return this.get_coefficient() == 0;}
	public void add(Monom m) {
		if(m!=null && m.get_power() == this.get_power()) {
			double a = m.get_coefficient() + this.get_coefficient();
			this.set_coefficient(a);
		}
	}
	public void multipy(double d) {
		double c = this.get_coefficient() * d;
		this.set_coefficient(c);
	}
	public void multipy(Monom d) {
		double c = this.get_coefficient() * d.get_coefficient();
		int p = this.get_power() + d.get_power();
		this.set_coefficient(c);
		this.set_power(p);
	}
	public String toString() {
		String ans = "";
		if(isZero()) ans ="0";
		else {
			ans = ""+this.get_coefficient();
			if(this.get_power()>0) {
				ans += "x";
				if(this.get_power()>1) {
					ans+="^"+this.get_power();
				}
			}
		}
		return ans;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		if(this.get_power()==0) {return new Monom(ZERO);}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}

	private static Monom init(String monom) {
		Monom ans = null;
		double coef = 1;
		int pow = 1;
		try {
			monom = monom.toLowerCase();
			int i0 = monom.indexOf("x");
			int i2 = monom.indexOf("-x");
			int i3 = monom.indexOf("x^");
			if(i2>=0) {coef=-1;}
			else {
				if(i0>0) {
					coef = Double.parseDouble(monom.substring(0,i0));
				}
				if(i0<0) {
					coef = Double.parseDouble(monom.substring(0));
				}
			}
			if(i3>=0) {
				pow = Integer.parseInt(monom.substring(i3+2));
			}
			else {
				if(i0<0)  {pow = 0;}
			}
			ans = new Monom(coef,pow);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return ans;
	}
	
	public double f(double x) {
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	//****************** Private Methods and Data *****************
	

	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	
	private double _coefficient; 
	private int _power;
	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public function copy() {
		return new Monom(this.toString());
	}
	
}
