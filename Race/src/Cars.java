public class Cars {
    public static class Car {
        private static int count = 0;
        private int id;
        private String _nameCar;
        private int _speedCar;
        private int _positionCar;

        public String get_nameCar() {
            return _nameCar;
        }
        public void set_nameCar(String _nameCar) {
            this._nameCar = _nameCar;
        }
        public int get_speedCar() {
            return _speedCar;
        }
        public void set_speedCar(int _speedCar) {
            this._speedCar = _speedCar;
        }
        public int get_positionCar() {
            return _positionCar;
        }
        public void set_positionCar(int _positionCar) {
            this._positionCar = _positionCar;
        }
        //конструктор з параметрами, який ініціалізує всі поля класу
        public Car(String nameCar, int speedCar, int positionCar) {
            _nameCar = nameCar;
            _speedCar = speedCar;
            _positionCar = positionCar;
            count++;
            id = count;
        }
        //заміщення (перевизначення) методу toString() класу Object
        //замість дескриптора об'єкта, він виводитеме інформацію по автомобілю
        @Override
        public String toString() {
            return id + ". " + _nameCar + " " + " " + _speedCar + " " + _positionCar + " ";
        }
        //метод для отримання значення поля id
        public int getId() {
            return id;
        }
        //метод для отримання кількості автомобілів
        public static int getCount() {
            return count;
        }
        //тестовий метод main
        public static void main(String[] args) {
            Car car[] = new Car[5];
            car[0] = new Car("Audi", 10000, 1);
            car[1] = new Car("BMW", 12000, 2);
            car[2] = new Car("Daewoo", 8000, 3);
            car[3] = new Car("Reno", 12000, 4);
            System.out.println("Машини в заезде: Наименование, скорость. позиция");
            for (int i = 0; i < Car.getCount(); i++) {
                System.out.println(car[i]);
                            }
            public void whoIsWinner (Car[]){
              /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
            for (int i = 0; i < car.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
                int min = car[i].get_speedCar();
                int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
                for (int j = i + 1; j < car.length; j++) {
                    //Если находим, запоминаем его индекс
                    if (car[j]._speedCar < min) {
                        min = car[j]._speedCar;
                        min_i = j;
                    }
                }
            }
           }
        }
    }
}