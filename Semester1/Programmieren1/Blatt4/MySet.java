/**
 * Programm zum Aufgabenblatt 4
 * 
 * Aufgabe 4 - MySet
 * 
 * This is the MySet class. The Test class could be find in MySetTest.java.
 * 
 * @author Lisa Weickenmeier
 */

public class MySet{
    private int[] set;

    public MySet(int[] set){
        if (set == null || set.length == 0) {
            System.out.println("Error! Set does not exist.");
        }else{
            if(setIsPositive(set)){
                for(int i=0;i<set.length;i++){
                    addToSet(set[i]);
                }
            }else{
                System.out.println("Error! Negative integers are not allowed.");
            }
        }
    }

    /**
     * @method Method to check if all elements of set are higher than zero.
     * @param set Set to check.
     * @return true, if condition is fulfilled.
     */
    private boolean setIsPositive(int[] set){
        boolean setIsPositive = true;

        for(int i=0;i<set.length;i++){
            if(set[i]<=0){
                setIsPositive = false;
            }
        }

        return setIsPositive;
    }

    /***
     * Aufgabe 4a - addToSet
     */

    /**
     * @method Method of adding an element to the set if the set does not contain it.
     * @name addToSet
     * @param item elemten to add
     */
    public void addToSet(int item){
        if(item <=0){
            return;
        }
        if(set == null){
            set = new int[1];
            set[0]=item;
        }
        if(!elementInSet(item)){
            //Add to array
            int[] setCopy = set;
            set = new int[setCopy.length+1];
            for(int i = 0; i<setCopy.length;i++){
                set[i] = setCopy[i];
            }
            set[setCopy.length] = item;
        }
    }

    /**
     * @method Method of adding a couple of elements to the set. 
     *         Each element is only added if the set does not already contain it.
     * @name addToSet
     * @param s The set to add to the set.
     */
    public void addToSet(MySet s){
        if(setIsPositive(s.set)){
            for(int item : s.set){
                addToSet(item);
            }
        }else{
            System.out.println("Error! Only positive sets allowed.");
        }
    }

    /***
     * Aufgabe 4b - removeFromSet
     */


    /**
     * @method Method of removing an element from the set. 
     *         The element will only be removed if the set contains it.
     * @name removeFromSet
     * @param item item to remove
     */
    public void removeFromSet(int item){
        if(elementInSet(item)){
            //remove from array
            int[] setCopy = set;
            set = new int[setCopy.length-1];
            int indexEqualElement = -1;
            for(int i = 0; i<setCopy.length;i++){
                if(setCopy[i]==item){
                    indexEqualElement = i;
                }
            }
            for(int i = 0;i<indexEqualElement;i++){
                set[i] = setCopy[i];
            }
            for(int i = indexEqualElement+1;i<setCopy.length;i++){
                set[i-1]= setCopy[i];
            }
        }
    }

    /**
     * @method Method to remove a couple of elements from the set. 
     *         Each element is only removed if the set contains it.
     * @name removeFromSet
     * @param s set to remove
     */
    public void removeFromSet(MySet s){
        for(int item : s.set){
            removeFromSet(item);
        }
    }

    /***
     * Aufgabe 4c - sort
     */


    /**
     * @method Method to sort the set. First come the odd elements 
     *         sorted in ascending order, then the even ones. 
     * @names sort
     * @return the sorted set as int array
     */
    public int[] sort(){
        int[] sortedSet = new int[set.length];
        if(set != null && set.length != 0){
            MySet setToReduce = new MySet(set);

            int countOdd = 0;
            for(int i=0;i<set.length;i++){
                if(set[i]%2==1){
                    countOdd++;
                }
            }

            //Sort the odd elements
            for (int j=0;j<countOdd; j++) {
                int p=0;
                int min = setToReduce.set[p];
                while(min%2==0){
                    p++;
                    min = setToReduce.set[p];
                }
                for(int i=0; i<setToReduce.set.length;i++){
                    if(setToReduce.set[i]%2==1 && setToReduce.set[i]<min){
                        min = setToReduce.set[i];
                        p=i;
                    }
                }
                setToReduce.removeFromSet(min);
                sortedSet[j] = min;
            }


            //Sort the even elements
            for (int j=countOdd;j<set.length; j++) {
                int p=0;
                int min = setToReduce.set[p];
                
                for(int i=0; i<setToReduce.set.length;i++){
                    if(setToReduce.set[i]<min){
                        min = setToReduce.set[i];
                        p=i;
                    }
                }
                setToReduce.removeFromSet(min);
                sortedSet[j] = min;
            }
        }
        return sortedSet;
    }

    /**
     * @method Method to print the private set.
     * @name printSet
     */
    public void printSet(){
        if(this.set == null || this.set.length == 0){
            System.out.println("Error! Nothing to display!");
        }else{
            System.out.print("{");
            for(int i=0;i<set.length-1;i++){
                System.out.print(set[i] + ", ");
            }
            System.out.println(set[set.length-1] + "}");
        }
    }

    /**
     * @method Method to check if the set contains the element.
     * @param element element to check
     * @return true, if the set contains the element, else return false.
     */
    private boolean elementInSet(int element){
        boolean elementInSet = false;

        if(set != null && set.length !=0){
            for(int i=0; i<set.length;i++){
                if(element == set[i]){
                    elementInSet = true;
                }
            }
        }

        return elementInSet;
    }
}