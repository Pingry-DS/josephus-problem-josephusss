public class EasyJoe {

  public static void main(String[] args) {
    Soldier_Circle c = new Soldier_Circle(Integer.parseInt(args[0]));
    Soldier current = c.get(1);
    System.out.println(c);
      while(c.getNumberLiving() > 1){

        Soldier next = current.getNext();
        while(!next.isLive()) {
          next = next.getNext();

        }
        c.kill(next, current);

        System.out.println(c);
        while(!next.isLive())
          next = next.getNext();
        current = next;
      }
      for(int x = 1; x <= c.getSize(); x++){
        if(c.get(x).isLive()){
          System.out.println("Soldier " + x + ", " + c.get(x) + " is the last soldier remaining");
        }
      }
  }

}
