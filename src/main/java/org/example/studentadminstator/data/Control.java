package org.example.studentadminstator.data;

import java.util.ArrayList;

public class Control<T> {
      private ArrayList<T> data;

      Control(ArrayList<T> data) {
            this.data = data;
      }

      public ArrayList<T> getData() {
            return data;
      }

      public void setData(ArrayList<T> data) {
            this.data = data;
      }

      public void addData(T item) {
            data.add(item);
      }

      public void removeData(T item) {
            data.remove(item);
      }

      public int size() {
            return data.size();
      }
}
