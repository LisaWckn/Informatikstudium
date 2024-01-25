/** 
 * Programm zum Aufgabenblatt 3
 * 
 * Aufgabe 3b - IsEqual
 * 
 * This is the IsEqual class. The test class could be find in IsEqualTest.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class IsEqual {

    /**
     * @method to check if two arrays icludes an equivalent count of all numbers.
     * @name isEqual
     * @param a first array
     * @param b second array
     * @return true, if arrays fulfills the specification, else return false
     */
    public boolean isEqual(int[] a, int[] b){
        if(a == null || b == null || a.length == 0 || b.length == 0){
            System.out.println("Error!");
            return false;
        }else{
            boolean isEqual = true;

            if(a.length != b.length){
                isEqual = false;
            }else{
                /**
                 * To avoid the change of the originally arrays the sorted array is returned to a copy.
                 */
                int[] aCopy = sort(a);
                int[] bCopy = sort(b);

                for(int i=0;i<a.length;i++){
                    if (aCopy[i] != bCopy[i]) {
                        isEqual = false;
                    }
                }
            }

            return isEqual;
        }
    }

    /**
     * @method InsertionSort to sort an array from the smallest number to the highest.
     * @name sort
     * @param x Array to sort
     * @return sorted array
     */
    public int[] sort(int[] x){
        if(x==null || x.length == 0){
            System.out.println("Error!");
            return x;
        }else{
            for(int i=1;i<x.length;i++){
                int m=x[i];
                int j=i;
                boolean ready = false;

                while (!ready) {
                    if(x[j-1]>m){
                        x[j]=x[j-1];
                        j-=1;
                        if (j<1) {
                            ready = true;
                        }
                    }else{
                        ready = true;
                    }
                }
                x[j] = m;
            }
            return x;
        }
    }
}
