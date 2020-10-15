/**
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
public class WalkingRobotGame {
    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        System.out.println("ВВедите имя Робота");
        //String nN1 = s.nextLine();
        String nN1 = "Tom";
        System.out.println(nN1);

        System.out.println("ВВедите Социальный статус Робота");
        //String sSR1 = s.nextLine();
        String sSR1 = "Okhotnik";
        System.out.println(sSR1);

        System.out.println("ВВедите Координату X");
        //String x1 = s.nextLine();
        String x1 = "12";
        System.out.println(x1);

        System.out.println("ВВедите Координату Y");
        //String y1 = s.nextLine();
        String y1 = "6";
        System.out.println(y1);

        Robot r1 = new Robot(nN1, sSR1, Integer.valueOf(x1), Integer.valueOf(y1));


        //Scanner s = new Scanner(System.in);
        System.out.println("ВВедите имя Робота");
        //String nN2 = s.nextLine();
        String nN2 = "Jeri";
        System.out.println(nN2);

        System.out.println("ВВедите Социальный статус Робота");
        //String sSR2 = s.nextLine();
        String sSR2 = "Dich";
        System.out.println(sSR2);

        System.out.println("ВВедите Координату X");
        //String x2 = s.nextLine();
        String x2 = "28";
        System.out.println(x2);

        System.out.println("ВВедите Координату Y");
        //String y2 = s.nextLine();
        String y2 = "14";
        System.out.println(y2);

        Robot r2 = new Robot(nN2, sSR2, Integer.valueOf(x2), Integer.valueOf(y2));


        r1.zakhvatCeli(r2);
        r1.rasstoyaniyeDoCeli(r2);
        r1.chastotaShaga();
        r1.moveRobot(r1, r2.X, r2.Y);
        System.out.println("Мы приехали в точку X = " + r1.X + "\tY = " + r1.Y);


    }



}
