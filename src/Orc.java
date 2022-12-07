public class Orc extends PCharacter {


    public Orc(String name, int damage, int hp) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.type = "orc";
    }

    @Override
    public void description() {
        System.out.println("An Orc is a fictional humanoid monster like a goblin.");
    }

    public void display(){
        System.out.println(name + " | HP: " + hp + " Dmg: " + damage);
    }
}
