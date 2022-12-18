package transport;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.lang.Character;
import java.time.LocalDate;


public class Car {

        // Определяем свойства класса
        private final String brand; // марка автомобиля
        private final String model; // модель автомобиля
        private final String productionCountry; // страна сборки
        private final int productionYear; // год выпуска
        private final String carBodyType; // тип кузова
        private final int numberOfSeats; // количество мест
        private String color; // цвет кузова
        private double engineVolume; // объем двигателя в литрах
        private String transmission; // коробка передачи
        private String vehicleRegistrNumber; // регистрационный номер
        private boolean summerOrWinterTires; // признак «Летняя» или «Зимняя резина»
        private Key key;
        private Insurance insurance;

        // Конструктор
        public Car(String brand,
                   String model,
                   int productionYear,
                   String productionCountry,
                   String carBodyType,
                   String color,
                   double engineVolume,
                   String transmission,
                   String vehicleRegistrNumber,
                   int numberOfSeats) {

             if (key == null) {
                 this.key = new Key();
             }

            if (brand == null || brand.isEmpty() || brand.isBlank()) {
                this.brand = "default";
            } else {
                this.brand = brand;
            }
            if (model == null || model.isEmpty() || model.isBlank()) {
                this.model = "default";
            } else {
                this.model = model;
            }
            if (productionYear >= 2001) {
                this.productionYear = productionYear;
            } else {
                this.productionYear = 2000;
            }
            if (productionCountry == null || productionCountry.isEmpty() || productionCountry.isBlank()) {
                this.productionCountry = "default";
            } else {
                this.productionCountry = productionCountry;
            }
            if (carBodyType != null && !carBodyType.isEmpty() && !carBodyType.isBlank()) {
                this.carBodyType = carBodyType;
            } else {
                this.carBodyType = "седан";
            }
             if (numberOfSeats >= 5) {
                this.numberOfSeats = numberOfSeats;
            } else {
                this.numberOfSeats = 5;
            }

            this.color = color;
            this.engineVolume = engineVolume;
            this.transmission = transmission;
            this.vehicleRegistrNumber = vehicleRegistrNumber;
            this.summerOrWinterTires = summerOrWinterTires;
        }

        // геттеры для неизменяющихся параметров
        public String getBrand() {
            return brand;
        }
        public String getModel() {
            return model;
        }
        public String getProductionCountry() {
            return productionCountry;
        }
        public int getProductionYear() {
            return productionYear;
        }
        public String getCarBodyType() {
            return carBodyType;
        }
        public int getNumberOfSeats() {
            return numberOfSeats;
        }

        // Созданы геттеры и сеттеры для изменяющихся параметров
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            if (color != null && !color.isEmpty() && !color.isBlank()) {
                this.color = color;
            } else {
                this.color = "белый";
            }
        }

        public double getEngineVolume() {
            return engineVolume;
        }
        public void setEngineVolume(double engineVolume) {
            if (engineVolume >= 1.6) {
                this.engineVolume = engineVolume;
            } else {
                this.engineVolume = 1.5;
            }
        }

        public String getTransmission() {
            return transmission;
        }
        public void setTransmission(String transmission) {
            if (transmission != null && !transmission.isEmpty() && !transmission.isBlank()) {
                this.transmission = transmission;
            } else {
                this.transmission = "АКПП";
            }
        }

        public String getVehicleRegistrNumber() {
            return vehicleRegistrNumber;
        }
        public void setVehicleRegistrNumber(String vehicleRegistrNumber) {
            if (vehicleRegistrNumber != null && !vehicleRegistrNumber.isEmpty() && !vehicleRegistrNumber.isBlank()) {
                this.vehicleRegistrNumber = vehicleRegistrNumber;
            } else {
                this.vehicleRegistrNumber = "х000хх000";
            }
        }

        public boolean isSummerOrWinterTires() {
            return summerOrWinterTires;
        }
        public void setSummerOrWinterTires(boolean summerOrWinterTires) {
             this.summerOrWinterTires = summerOrWinterTires;
            }

// конструктор

    public Key getKey() {
                  return key;
              }
      public void setKey(Key key){
                  this.key = key;
              }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    // метод проверки смены автопокрышек по сезону
    public static void changeSummerOrWinterTires() {
        GregorianCalendar calendar;
        calendar = new GregorianCalendar(2022, Calendar.DECEMBER, 18);
        int month = calendar.get(Calendar.MONTH);
        boolean summerOrWinterTires = (month > 11 || month <= 3);
        if (summerOrWinterTires) {
            System.out.println("зимняя резина");
        } else {
            System.out.println("летняя резина ");
        }
    }

    // метод проверки регистрационного номера на корретность
    public boolean isDigitVehicleRegistrNumber() {
        if (vehicleRegistrNumber.length() != 9) {
            return false;
        }
        char[] chars = vehicleRegistrNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        if (!Character.isDigit(chars[1]) ||
                !Character.isDigit(chars[2]) ||
                !Character.isDigit(chars[3]) ||
                !Character.isDigit(chars[6]) ||
                !Character.isDigit(chars[7]) ||
                !Character.isDigit(chars[8])) {
            return false;
        }
        return true;
    }

        // Определяем функции класса
        public String toString () {
            return "Автомобиль марки " + this.brand +
                    ", модель " + this.model +
                    ", год выпуска " + this.productionYear +
                    ", страна сборки " + this.productionCountry +
                    ", тип кузова " + this.carBodyType +
                    ", цвет кузова " + this.color +
                    ", объем двигателя в литрах " + this.engineVolume +
                    ", коробка передач " + this.transmission +
                    ", регистрационный номер " + this.vehicleRegistrNumber +
                    ", количество мест " + this.numberOfSeats +
                    ", признак автошин ";
        }

        // встроенный класс
        public static class Key {
            private final boolean remoteStart;
            private final boolean keylessCarAccess;

            public Key(boolean remoteStart, boolean keylessCarAccess) {
                this.remoteStart = remoteStart;
                this.keylessCarAccess = keylessCarAccess;
            }

            public Key() {
                this(false, false);
            }
            public boolean isRemoteStart() {
                return remoteStart;
            }
              public boolean isKeylessCarAccess() {
                    return keylessCarAccess;
                }
       }


        // встроенный класс
        public static class Insurance {

            private final LocalDate exppireDate;
            private final double cost;
            private final String number;



            public Insurance(LocalDate exppireDate, double cost, String number) {

                if (exppireDate == null) {
                    this.exppireDate = LocalDate.now().plusDays(365);
                } else {
                    this.exppireDate = exppireDate;
                }
                this.cost = cost;

                if (number == null) {
                    this.number = "123456789";
                } else {
                    this.number = number;
                }
            }

            // метод
           public Insurance() {
                 this(null, 10_0000, null);
                }

            public LocalDate getExppireDate() {
                return exppireDate;
            }

            public double getCost() {
                return cost;
            }

            public String getNumber() {
                return number;
            }

            public void checkExppireDate() {
                if (exppireDate.isBefore(LocalDate.now()) || exppireDate.isEqual(LocalDate.now())) {
                    System.out.println("Нужно оформить новую страховку");
                }
            }
            public void checkNumber() {
                if (number.length() != 9) {
                    System.out.println("Номер страховки не корректный");
                }
            }
        }
    }













