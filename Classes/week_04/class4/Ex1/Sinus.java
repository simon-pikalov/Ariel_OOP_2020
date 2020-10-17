//package class5.Ex1;

/**
 * This class represents a simple sin(x) function (actually sin(f(x))).
 * It is mainly used as an example for demonstrating Ex1
 *
 *
 */
public class Sinus implements function{
	private function _parm_func;
	
	public Sinus(function f) {
		_parm_func = f.copy();
	}
	public Sinus() {
		_parm_func = new Idle();
	}
	public double f(double x) {
		double y = _parm_func.f(x);
		double ans = Math.sin(y);
		return ans;
	}
	public String toString() {return "sin("+this._parm_func.toString()+")";}
	@Override
	public function initFromString(String s) {
		function ans = null;
		s = s.toLowerCase();
		String st = "sin(";
		int start = s.indexOf(st);
		if(start>=0 && s.endsWith(")")) {
			String s1 = s.substring(start+st.length(),s.length()-1);
			function ff = initFromString(s1);
			ans = new Sinus(ff);
		}
		else {
			;
			// this code was removed - as it is part of Ex1
		//	ans = new ComplexFunction(s);
		}
		return ans;
	}

	@Override
	public function copy() {
		Sinus ans = new Sinus(this._parm_func.copy());
		return ans;
	}
	/** Very basic & simple example for innec class */
	class Idle implements function{
		public Idle() {;}
		public double f(double x) {return x;}
		public function initFromString(String s) {
			// TODO Auto-generated method stub
			return null;
		}
		public function copy() {
			return new Idle();}
		public String toString() {return "x";}
	}  

}
