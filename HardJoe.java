public class HardJoe {

  public static void main(String[] args) {
    Soldier_Circle c = new Soldier_Circle(Integer.parseInt(args[0]));
    Soldier current = c.get(1);
    Soldier next = current;
    Soldier temp;
    int count;
      System.out.println(c);
    while(c.getNumberLiving() > 1){
        count = c.getNumberLiving() / 2;

        temp = current;
        for(int x = 0; x < count; x++){
            next = temp.getNext();
            while(!next.isLive()) {
                next = next.getNext();
            }
            temp = next;
        }
        c.kill(next, current);

        System.out.println(c);

        current = current.getNext();
        while(!current.isLive())
            current = current.getNext();

    }
    for(int x = 1; x <= c.getSize(); x++){
      if(c.get(x).isLive()){
        System.out.println("Soldier " + x + ", " + c.get(x) + " is the last soldier remaining");
      }
    }
  }
}
