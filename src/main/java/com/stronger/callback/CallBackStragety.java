package com.stronger.callback;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:23 2018/6/24
 * @ModefiedBy:
 */
public class CallBackStragety {

    private interface CallBackMethod {
        public boolean acccept(CallBackStragety stragety, String match) throws InterruptedException;
    }

    public static class CalBackMethodImp implements CallBackMethod {
        private String regix;

        public CalBackMethodImp(String regix) {
            this.regix = regix;
        }

        @Override
        public boolean acccept(CallBackStragety stragety, String match) {
            return regix.equals(match);
        }
    }

    String name;

    public CallBackStragety(String name) {
        this.name = name;
    }

    public String getVal(CallBackMethod method) throws InterruptedException {
        String val = "";
        TimeUnit.SECONDS.sleep(2);
        if (method.acccept(this, "fusong")) {
            val = "Handsome";
        } else {
            val = "Noty";
        }
        System.out.println(val);
        return val;
    }

    public static void main(String[] args) throws InterruptedException {
        CallBackStragety stragety = new CallBackStragety("fusong");
        String val = stragety.getVal(new CalBackMethodImp("fusong"));
        /*System.out.println(val);*/
        for (int i = 0; i < 5; i++) {
            System.out.println("  " + i);
        }
    }
}
