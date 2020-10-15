public enum Direction {
    LEFT(360, "я смотрю на лево"),
    UP(90, "я смотрю на верх"),
    RIGHT(180, "я смотрю на право"),
    DOWN(270, "я смотрю на низ"),
    SLEEP(0,"я сплю, взгляда нет");
    int povorotVGradusah;
    String napravleniyeVzglyada;
    Direction(int povorotVGradusah, String napravleniyeVzglyada){
        this.povorotVGradusah = povorotVGradusah;
        this.napravleniyeVzglyada = napravleniyeVzglyada;
    }
}
