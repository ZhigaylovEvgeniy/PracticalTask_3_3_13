/**
 * @author Evgeny Zhigailov
 * @version 1
 *
 * На игровом поле находится робот.
 * Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
 * Ось X смотрит слева направо,
 * ось Y - снизу вверх.
 * (Помните, как рисовали графики функций в школе?)
 *
 * В начальный момент робот находится в некоторой позиции на поле.
 * Также известно, куда робот смотрит: вверх, вниз, направо или налево.
 * Ваша задача — привести робота в заданную точку игрового поля.
 *
 * Робот описывается классом Robot.
 * Вы можете пользоваться следующими его методами (реализация вам неизвестна):
 *
 * Пример:
 *  начальное состояние робота такое:
 *      robot.getX() == 0,
 *      robot.getY() == 0,
 *      robot.getDirection() == Direction.UP
 *
 *  В метод передано:
 *      toX == 3,
 *      toY == 0;
 *
 * Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
 *      robot.turnRight();
 *      robot.stepForward();
 *      robot.stepForward();
 *      robot.stepForward();
 *
 * Требования:
 * 1. должен быть метод public static void moveRobot(Robot robot, int toX, int toY)
 * 2. метод moveRobot должен переместить робота в позицию int toX, int toY
 * */
public class Robot {
    String robotNickname;//наименование робота
    String celNickname;//наименование цели

    String socialStatusRobot;//социальный статус робота (охотник или дичь)

    int toX;//координаты цели по X
    int toY;//координаты цели по Y

    int X;//координаты робота по X
    int Y;//координаты робота по Y

    int rasstoyaniyeDoCeliPoX;//расстояние до цели по X
    int rasstoyaniyeDoCeliPoY;//расстояние до цели по Y

    int chastotaShagaPoOsiX;//частота шага по оси X
    int chastotaShagaPoOsiY;//частота шага по оси Y

//    String napravleniyeDvizheniyaPoOsiX;//направление движения по оси X
//    String napravleniyeDvizheniyaPoOsiY;//направление движения по оси Y
    Direction direction;// текущее направление взгляда
    String sostoyaniyeRobota;//состояние робота (1поиск цели, 2перемещение до цели, 3цель достигнута)
    int kolichestvoDosignutykhCeley;//количество достигнутых целей


    public Robot(String robotNickname, String socialStatusRobot, int X, int Y){
        this.robotNickname = robotNickname;
        this.socialStatusRobot = socialStatusRobot;
        this.X = X;
        this.Y = Y;
        this.sostoyaniyeRobota = "PoiskCeli";
        this.kolichestvoDosignutykhCeley = 0;
        this.direction = Direction.UP;
    }



    public void zakhvatCeli(Robot r2){
        this.celNickname = r2.robotNickname;
        this.toX = r2.X;
        this.toY = r2.Y;
    }
    public void rasstoyaniyeDoCeli(Robot r2){
        this.rasstoyaniyeDoCeliPoX = r2.X - this.X;
        this.rasstoyaniyeDoCeliPoY = r2.Y - this.Y;
    }
    public void chastotaShaga(){
        if (this.rasstoyaniyeDoCeliPoX > this.rasstoyaniyeDoCeliPoY){
            double x = this.rasstoyaniyeDoCeliPoX;
            double y = this.rasstoyaniyeDoCeliPoY;
            if (Math.abs(y) > 0) {
                this.chastotaShagaPoOsiX = (int) Math.round((x / y));
            }
            this.chastotaShagaPoOsiY = 1;
            System.out.println(this.chastotaShagaPoOsiX);
            System.out.println(this.chastotaShagaPoOsiY);
        }
        if (this.rasstoyaniyeDoCeliPoX < this.rasstoyaniyeDoCeliPoY){
            double x = this.rasstoyaniyeDoCeliPoX;
            double y = this.rasstoyaniyeDoCeliPoY;
            this.chastotaShagaPoOsiX = 1;
            if (Math.abs(x) > 0) {
                this.chastotaShagaPoOsiY = (int) Math.round((y / x));
            }
            System.out.println(this.chastotaShagaPoOsiX);
            System.out.println(this.chastotaShagaPoOsiY);
        }
        if (this.rasstoyaniyeDoCeliPoX == this.rasstoyaniyeDoCeliPoY){
            this.chastotaShagaPoOsiX = 1;
            this.chastotaShagaPoOsiY = 1;
            System.out.println(this.chastotaShagaPoOsiX);
            System.out.println(this.chastotaShagaPoOsiY);
        }
    }

    public Direction getDirection() {
        System.out.println(this.direction.napravleniyeVzglyada);
        return this.direction;// текущее направление взгляда
    }
    public void turnLeft() {//поворот на лево (повернуться на 90 градусов против часовой стрелки)
        switch (getDirection()){
            case UP:
                this.direction = Direction.LEFT;
                break;

            case LEFT:
                this.direction = Direction.DOWN;
                break;

            case DOWN:
                this.direction = Direction.RIGHT;
                break;

            case RIGHT:
                this.direction = Direction.UP;
                break;

            default:
                System.out.println("взгляда нет");
        }

    }
    public void turnRight() {// поворот на право (повернуться на 90 градусов по часовой стрелке)
        switch (getDirection()){
            case UP:
                this.direction = Direction.RIGHT;
                break;

            case RIGHT:
                this.direction = Direction.DOWN;
                break;

            case DOWN:
                this.direction = Direction.LEFT;
                break;

            case LEFT:
                this.direction = Direction.UP;
                break;

            default:
                System.out.println("взгляда нет");
        }
    }
    public int getX() {
        System.out.println("текущая координата X:\t" + this.X);
        return this.X;// текущая координата X
    }
    public int getY() {
        System.out.println("текущая координата Y:\t" + this.Y);
        return  this.Y;// текущая координата Y
    }
    public void stepForward() {// шаг в направлении взгляда
        switch (getDirection()){// за один шаг робот изменяет одну свою координату на единицу
            case UP:
                this.Y = getY() + 1;
                break;

            case DOWN:
                this.Y = getY() - 1;
                break;

            case RIGHT:
                this.X = getX() + 1;
                break;

            case LEFT:
                this.X = getX() - 1;
                break;

            default:
                System.out.println("не могу идти, потому что глаза закрыты");

        }


    }

    public void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() != toX){
            if (robot.getX() < toX){
                for (;robot.getDirection() != Direction.RIGHT;){
                    if (robot.getDirection() == Direction.DOWN){
                        robot.turnLeft();
                    }else {
                        robot.turnRight();
                    }
                }
            }
            if (robot.getX() > toX){

                for (;robot.getDirection() != Direction.LEFT;){
                    if (robot.getDirection() == Direction.DOWN){
                        robot.turnRight();
                    }else {
                        robot.turnLeft();
                    }
                }

            }
            int a = Math.abs(robot.getX() - toX);
            for (int i = 0; i != a; ++i){
                robot.stepForward();
            }
        }
        if (robot.getY() != toY){
            if (robot.getY() < toY){
                for (;robot.getDirection() != Direction.UP;){
                    if (robot.getDirection() == Direction.RIGHT){
                        robot.turnLeft();
                    }else {
                        robot.turnRight();
                    }
                }
            }
            if (robot.getY() > toY){
                for (;robot.getDirection() != Direction.DOWN;){
                    if (robot.getDirection() == Direction.RIGHT){
                        robot.turnRight();
                    }else {
                        robot.turnLeft();
                    }
                }

            }
            int b = Math.abs(robot.getY() - toY);
            for (int i = 0; i != b; ++i){
                robot.stepForward();
            }
        }

    }

}
