import java.util.*;



public class HashFinal<K , V>{
    ArrayList<LinkedList<Entity>> li;
    private int size = 0;
    private float lf = 0.5f;
    
    public HashFinal(){
      li = new ArrayList<>();
      for(int i=0;i<li.size();i++){
         li.add(new LinkedList<>());
      }
    }

    public void add(K key, V value){
      int hash = Math.abs(key.hashCode() % li.size());
      LinkedList<Entity> entities = li.get(hash);
      
      for(Entity entity : entities){
        if(entity.key.equals(key)){
            entity.value = value;
            return ;
        }
      }

      if((float)(size) / li.size() > lf){
         reHash();
      }

      entities.add(new Entity(key, value));
      size++;
    }

    //rehase this copy list in other list
    public void reHash(){
      System.out.println("we are now rehashing");  
      ArrayList<LinkedList<Entity>>list = li;
      li = new ArrayList<>();
      size = 0;
      for(int i=0;i<list.size()*2;i++){
         li.add(new LinkedList<>());
      }
      
      for(LinkedList<Entity>entries : list){
        for(Entity entry : entries){
            put(entry.key, entry.value);
        }
      }
    }


    public class Entity {
      String key;
      String value;
      public Entity(K key, V value){
        this.key = key;
        this.value = value;
      }  
    }
}
