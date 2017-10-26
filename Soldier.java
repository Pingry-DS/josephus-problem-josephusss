public class Soldier {
    private Soldier next;
    private Soldier last;
    private String name;
    private boolean live;

    Soldier(){
        next = null;
        last = null;
        name = null;
        live = true;
    }

    Soldier(String s){
        next = null;
        last = null;
        name = s;
        live = true;
    }

    Soldier(Soldier l){
        next = null;
        last = l;
        name = null;
        live = true;
    }

    Soldier(Soldier n, Soldier l){
        next = n;
        last = l;
        name = null;
        live = true;
    }

    Soldier(Soldier n, Soldier l, String s){
        next = n;
        last = l;
        name = s;
        live = true;
    }

    public Soldier getNext() {
        return next;
    }

    public void setNext(Soldier next) {
        this.next = next;
    }

    public Soldier getLast() {
        return last;
    }

    public void setLast(Soldier last) {
        this.last = last;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public String toString(){
        return name;
    }

    public boolean equals(Soldier s){
        return(this.name.equals(s.name));
    }
}
