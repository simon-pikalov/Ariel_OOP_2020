package q1;

import java.util.Date;

public class CodeAns implements car_code {

    public static final long TIME_OUT = 1000*60*15;
    public static final long MAX_TIME = 1000*60;
    private static final long MAX_ERROR = 3;

    private car pCar;
    private long lastBlock , lastOpen;
    private int currError;

    public CodeAns(car c) {
        this.pCar = c;
        this.currError = 0;
        this.lastBlock = 0;
        this.lastOpen = 0;
    }

    private long now(){
        return new Date().getTime();
    }

    public boolean open(String key) {
        boolean ans = false;
        if(isOpen()) {ans= true;} //case car is open
        if(!ans && canBeOpen()) { //try to open the car
            if(getCar().open(key)) { //open was successful
                ans=true;
                currError=0;
                lastOpen =  now();
            }
            else { // open was unsuccessful
                this.currError++;
                if(currError>=MAX_ERROR) {
                    this.lastBlock =now();
                }
            }
        }
        return ans;
    }



    @Override
    public boolean  isOpen() {
        if(getCar().isRunning()) return true;
        if(now()-lastOpen < MAX_TIME) return true;
        return false;
    }

    @Override
    public boolean canBeOpen() {
        if(isOpen()) return true; // case already open
        else if(now()-this.lastBlock > TIME_OUT) return true;
        else return false;
    }


}
