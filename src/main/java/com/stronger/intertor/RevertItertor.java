package com.stronger.intertor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  10:03 2018/6/6
 * @ModefiedBy:
 */
public class RevertItertor<T> extends ArrayList<T>{

    public RevertItertor(Collection<? extends T> c) {
        super(c);
    }
    public Iterable<T> revert(){
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current=size()-1;
                    public void remove() {

                    }

                    public boolean hasNext() {
                        return current>-1;
                    }

                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }


   /*public Iterator<T> revert(){
       return new Iterator<T>() {
           public void remove() {

           }
          int current=size()-1;
           public boolean hasNext() {
               return current>-1;
           }

           public T next() {
               return get(current--);
           }
       };
   }
   */
}
