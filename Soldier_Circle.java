import java.util.HashMap;
import java.util.ArrayList;

public class Soldier_Circle {
    private int size;
    private Soldier first;
    private HashMap<Integer, String> names = new HashMap<>();

    void init(int n){
        ArrayList<String> arrl = new ArrayList<>();
        arrl.add("Alex");
        arrl.add("Ami");
        arrl.add("Ethan");
        arrl.add("Jenny");
        arrl.add("Orndorff");
        arrl.add("Jack");
        arrl.add("Lindsey");
        arrl.add("Michael");
        arrl.add("Nate");
        arrl.add("Bert");
        arrl.add("Apu");
        arrl.add("Will");

        for(int x = 0; x < 12; x++){
            String str = arrl.remove(x);
            arrl.add((int) (12 * Math.random()), str);
        }
        int i ;

        if(n < 12)
            i = n;

        i = 12;

        for(int x = 1; x <= i; x++){
            names.put(x, arrl.get(x - 1));
        }

        if(n > 12) {
            for(int x = 13; x <= n; x++){
                int s = x - 12;
                names.put(x, "Unnamed Soldier " + s);
            }
        }
        System.out.println(names);
    }

    Soldier_Circle (int n){
        size = n;

        init(n);

        Soldier last;
        first = new Soldier(names.get(1));
        last = first;

        for(int x = 2; x <= n; x++){
            Soldier s = new Soldier(last);
            s.setName(names.get(x));
            last.setNext(s);
            last = s;
        }

        last.setNext(first);
        first.setLast(last);
    }

    void kill(int n, Soldier s){
        if(n > size){
            throw new IndexOutOfBoundsException();
        }
        Soldier toKill = first;
        for(int x = 1; x < n; x++){
            toKill = toKill.getNext();
        }
        toKill.setLive(false);
        System.out.println(toKill.getName() + " has been killed by " + s);
    }

    Soldier get(int n){
        Soldier toReturn = first.getLast();
        for(int x = 0; x < n; x++){
            toReturn = toReturn.getNext();
        }
        return toReturn;
    }

    void kill(Soldier s, Soldier b){
        for(int x = 1; x <= size; x++){
            if(get(x).equals(s)){
                get(x).setLive(false);
                System.out.println(get(x).getName() + " has been killed by " + b);
            }
        }
    }

    int getNumberLiving(){
        int r = 0;
        for(int x = 1; x <= size; x++){
            if(get(x).isLive())
                r++;
        }
        return r;
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        String str = "";
        str += "{";
        for(int x = 1; x <= size; x++){
            str += x;
            str += ": ";
            str += get(x);

            if(!get(x).isLive())
                str+= " (dead) ";
            else
                str += " (live) ";
        }
        str += "}";
        return str;
    }
}
